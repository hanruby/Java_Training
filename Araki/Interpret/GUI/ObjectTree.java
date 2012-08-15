package GUI;

import java.awt.Dimension;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.activation.DataHandler;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.TransferHandler;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class ObjectTree extends JPanel implements ActionListener{

    private static final long serialVersionUID = 1726910916306653766L;

    private JTree objectTree;
    private DefaultMutableTreeNode root = new DefaultMutableTreeNode("Object");
    private DefaultTreeModel model;
    private JTextField objectName;
    private ConstructorField constructorField;
        
    public ObjectTree() {
        
        objectTree = new JTree(root);
        objectTree.setName("objectTree");

        JScrollPane treePanel = new JScrollPane(objectTree, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //treePanel.setPreferredSize(new Dimension(400, 300));

        model = (DefaultTreeModel) objectTree.getModel();

        // create control contents
        objectName = new JTextField(10);
        constructorField = new ConstructorField(20);
        JButton addButton = new JButton("+");
        addButton.addActionListener(this);
        addButton.setActionCommand("Add");
        JButton deleteButton = new JButton("-");
        deleteButton.addActionListener(this);
        deleteButton.setActionCommand("Delete");
    
        // create control panel
        JPanel controlPanel = new JPanel();
        controlPanel.add(objectName);
        controlPanel.add(constructorField);
        controlPanel.add(addButton);
        controlPanel.add(deleteButton);
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(treePanel);
        add(controlPanel);
    
        MouseListener ml = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Open the popupmenu using right click
                if ( e.getButton() == MouseEvent.BUTTON1) {

                    // Get a member of the class object
                    final DefaultMutableTreeNode node = (DefaultMutableTreeNode) objectTree.getLastSelectedPathComponent();
                    if (node != null) {
                        Object obj = node.getUserObject();
                        
                        // Field
                        if (obj instanceof Field) {
                            Field field = (Field) obj;
                            System.out.println("Selected node is Field: " + field);
                            try {
                                controlPanal.updateInfo(getObjectNode(node).getUserObject(), field, node.getChildAt(0));
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        }
                        // Method
                        else if (obj instanceof Method) {
                            Method method = (Method) obj;
                            System.out.println("Selected node is Method: " + method);
                            
                            controlPanal.execMethod(getObjectNode(node).getUserObject(), method);
                        }
                        // Array
                        else if (obj != null && obj.getClass().isArray() && ArrayUtility.getDim(obj) == 2) {
                                                        
                            System.out.println("Selected node is Array");
                            
                            ObjectPanel op = new ObjectPanel(obj);
                            
                            subPanel.removeAll();
                            subPanel.add(op);
                            subPanel.updateUI();
                        }
                        else if (obj != null && obj.getClass().isArray() == false && node.isLeaf()) {
                            System.out.println("Selected node is object");
                            
                            createMethodTree(node, obj);
                            objectTree.updateUI();
                        }
                    }
                }
                super.mouseClicked(e);
            }
        };
        objectTree.addMouseListener(ml);

        // support for drag and drop
        objectTree.setDragEnabled(true);
        objectTree.setTransferHandler(new ObjectTransfer());
    }

    private DefaultMutableTreeNode createArrayTree(Object obj) {
        DefaultMutableTreeNode arrayTree = new DefaultMutableTreeNode(obj);
        if (obj == null || ! obj.getClass().isArray()) {
            return arrayTree;
        }

        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object o = Array.get(obj, i); 
            
            DefaultMutableTreeNode arr = createArrayTree(o);
            arrayTree.add(arr);
        }
        return arrayTree;
    }
    
    public void createObjectTree(Object obj, String name) {

        DefaultMutableTreeNode newObject = new DefaultMutableTreeNode(name);

        // is Array
        if (obj.getClass().isArray()) {
            // Create object array tree
            DefaultMutableTreeNode arrayTree = new DefaultMutableTreeNode("Array");
            
            arrayTree.add(createArrayTree(obj));
            
            newObject.add(arrayTree);
        }
        else {
            // Create object node
            DefaultMutableTreeNode objectTree = new DefaultMutableTreeNode(obj);
            
            newObject.add(objectTree);
        }
        root.add(newObject);
        model.reload();
    }
    
    public void createMethodTree(DefaultMutableTreeNode objctRoot, Object obj) {

        Type type = obj.getClass().getGenericSuperclass();
        ArrayList<Class<?>> classArr = new ArrayList<Class<?>>(); 
        
        classArr.add(obj.getClass());
        
        while(type != null) {

            Class<?> cls = null;
            if (type instanceof Class<?>) {
                cls = (Class<?>) type;
            }
            else if (type instanceof ParameterizedType) {
                cls = (Class<?>) ((ParameterizedType)type).getRawType();
            }
            else {
                throw new Error("Unexpected non-class type");
            }

            classArr.add(cls);

            type = cls.getGenericSuperclass();
        }
        
        // Create object field tree
        DefaultMutableTreeNode fieldTree = new DefaultMutableTreeNode("Field");
        for (Class<?> cls : classArr) {
            Field[] fields = cls.getDeclaredFields();    
            for (Field field : fields) {
                DefaultMutableTreeNode f = new DefaultMutableTreeNode(field);
                fieldTree.add(f);
                field.setAccessible(true);
                Object value = null;
                try {
                    value = field.get(obj);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                f.add(new DefaultMutableTreeNode(value));
            }
        }

        // Create object method tree
        DefaultMutableTreeNode methodTree = new DefaultMutableTreeNode("Method");
        Set<Method> methodArr = new HashSet<Method>();
        for (Class<?> cls : classArr) {
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                methodArr.add(method);
            }
        }
        // Sort
        TreeSet<Method> methodSortedArr =  new TreeSet<Method>(new Comparator<Method>() {
            @Override
            public int compare(Method m1, Method m2) {
                
                return m1.toString().compareTo(m2.toString());
            }
        }); 
        methodSortedArr.addAll(methodArr);
        // Add tree
        for (Method method : methodSortedArr) {
            method.setAccessible(true);
            DefaultMutableTreeNode m = new DefaultMutableTreeNode(method);
            methodTree.add(m);
        }

        // Create object 
        objctRoot.add(fieldTree);
        objctRoot.add(methodTree);
    }

    public void changeFieldValue(Field field, String value) {

        DefaultMutableTreeNode node = (DefaultMutableTreeNode) objectTree.getLastSelectedPathComponent();
        if (node == null || node.getParent() == null) {
            return;
        }

        DefaultMutableTreeNode objectRoot = getObjectNode(node);
        Object obj = objectRoot.getNextNode().getUserObject();

        field.setAccessible(true);
        try {
            Class<?> type = field.get(obj).getClass();
            field.set(obj, ObjectUtility.convertObject(type, value));
        } catch (IllegalArgumentException e) {
            Console.err.println("Your input argument is invalid. reason : " + e.getMessage());
        } catch (IllegalAccessException e) {
            Console.err.println("Cannot access this. reason : " + e.getMessage());
        }

        createObjectTree(obj, objectRoot.getUserObject().toString());
    }
    
    public void addObject(String objectName, Constructor<?> constructor, Object[] objs) {
        if (constructor != null && objectName != null && !objectName.equals("")) {
            Object obj;
            try {
                // Create new instance!!
                obj = constructor.newInstance(objs);
                createObjectTree(obj, objectName);
                model.reload();
            } catch (IllegalArgumentException e) {
                Console.err.println("Your input argument is invalid. reason : " + e.getMessage());
            } catch (InstantiationException e) {
                Console.err.println(e);
            } catch (IllegalAccessException e) {
                Console.err.println("Cannot access this. reason : " + e.getMessage());
            } catch (InvocationTargetException e) {
                Console.err.println(e);
                Console.err.println(e.getCause());
            }
        }
    }

    public void addArrayObject(String objectName, Constructor<?> constructor, Class<?> type, int[] dims, Object... initargs) {
        if (constructor != null && objectName != null && !objectName.equals("") && type != null && dims != null) {
            Object obj;
            try {
                obj = Array.newInstance(type, dims);
                try {
                    ArrayUtility.initArray(obj, constructor, initargs);
                } catch (ArrayIndexOutOfBoundsException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                createObjectTree(obj, objectName);
            } catch (IllegalArgumentException e) {
                Console.err.println(e);
                e.printStackTrace();
            }
        }
    }
    
    public void execMethod(String objectName, Method method, Object[] objs) {
        
        // ツリーからオブジェクトを取得
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) objectTree.getLastSelectedPathComponent();
        if (node == null || node.getParent() == null) {
            return;
        }
        DefaultMutableTreeNode objectRoot = getObjectNode(node);
        Object obj = objectRoot.getNextNode().getUserObject();

        if (method != null && objectName != null && !objectName.equals("")) {

            Object ret = null;
            method.setAccessible(true);
            try {
                ret = method.invoke(obj, objs);
            } catch (IllegalArgumentException e) {
                Console.err.println(e);
            } catch (IllegalAccessException e) {
                Console.err.println(e);
            } catch (InvocationTargetException e) {
                Console.err.println(e);
            };
            
            if (ret != null) {
                createObjectTree(ret, objectName);
            }
        }            
    }
    
    public void updateTree() {
        objectTree.updateUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();

        if (action.equals("Add")) {
            String constructorName = constructorField.getText();
            String objectName = this.objectName.getText();
            if (!constructorName.equals("") && !objectName.equals("")) {
                addObject(objectName, constructorField.getConstructor(), null);
            }
        }
        else if (action.equals("Delete")) {
            DefaultMutableTreeNode node = 
                (DefaultMutableTreeNode) objectTree.getLastSelectedPathComponent();

            node = getObjectNode(node);

            if(node == null) {
                return;
            }

            node.removeFromParent();
            model.reload();
        }

        objectName.setText("");
    }
    
    @Override
    public void setPreferredSize(Dimension arg0) {
        super.setPreferredSize(arg0);
    }
    
    public static DefaultMutableTreeNode getObjectNode(DefaultMutableTreeNode node) {
        if (node == null || node.getParent() == null) {
            return null;
        }

        while ( node.getParent().toString().equals("Object") == false ) {
            node = (DefaultMutableTreeNode) node.getParent();
        }
        return node;
    }
        
    private ControlPanel controlPanal;
    private JPanel subPanel;
    
    public void setPropertiesPanel(ControlPanel panel, JPanel subPanel) {
        controlPanal = panel;
        this.subPanel = subPanel;
    }
}

class ObjectTransfer extends TransferHandler {

    private static final long serialVersionUID = -1426178157203230501L;

    // Ref : http://docs.oracle.com/javase/tutorial/uiswing/dnd/dataflavor.html
    public final static DataFlavor localObjectFlavor = new DataFlavor (
            DefaultMutableTreeNode.class, "This is tree node.");

    public static final DataFlavor[] flavors = {
        localObjectFlavor
    };

    @Override
    protected Transferable createTransferable(JComponent c) {
        JTree tree = (JTree) c;
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (node != null) {
            // Accept object.
            DataHandler dh = new DataHandler(node.clone(), localObjectFlavor.getMimeType());
            return dh;
        }
        return null;
    }

    @Override
    public int getSourceActions(JComponent arg0) {
        return COPY_OR_MOVE;
    }
}