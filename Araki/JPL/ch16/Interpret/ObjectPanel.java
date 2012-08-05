package ch16.Interpret;

import java.awt.Dimension;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.lang.reflect.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.TransferHandler;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class ObjectPanel extends JPanel implements ActionListener{

    private static final long serialVersionUID = 1726910916306653766L;

    private JTree tree;
    private DefaultMutableTreeNode classTree = new DefaultMutableTreeNode("Object");
    private DefaultTreeModel model;
    private JTextField objectName;
    private ConstructorField constructorField;
        
    public ObjectPanel() {
        
        tree = new JTree(classTree);

        JScrollPane treePanel = new JScrollPane(tree, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //treePanel.setPreferredSize(new Dimension(400, 300));

        model = (DefaultTreeModel) tree.getModel();

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
                    final DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                    if (node != null) {
                        Object obj = node.getUserObject();
                        
                        // Field
                        if (obj instanceof Field) {
                            final Field field = (Field) obj;
                            System.out.println("Selected node is Field: " + field);
                            try {
                                propertiesPanal.updateInfo(getObjectNode(node).getUserObject(), field, node.getChildAt(0));
                            } catch (Exception e1) {
                                Console.err.println(e1);
                                e1.printStackTrace();
                            }
                        }
                        // Method
                        else if (obj instanceof Method) {
                            final Method method = (Method) obj;
                            System.out.println("Selected node is Method: " + method);
                            JPopupMenu popup = new JPopupMenu();
                            JMenuItem exec = new JMenuItem("exec");
                            exec.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                }
                            });
                            popup.add(exec);
                            popup.show(e.getComponent(), e.getX(), e.getY());
                        }
                    }
                }
                super.mouseClicked(e);
            }
        };
        tree.addMouseListener(ml);
    }

    public void createObjectTree(Object obj, String name) {

        DefaultMutableTreeNode root = new DefaultMutableTreeNode(name);

        // Create object tree
        DefaultMutableTreeNode objectTree = new DefaultMutableTreeNode(obj);

        // Create object field tree
        DefaultMutableTreeNode fieldTree = new DefaultMutableTreeNode("Field");
        Field[] fields = obj.getClass().getDeclaredFields();
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

        // Create object method tree
        DefaultMutableTreeNode methodTree = new DefaultMutableTreeNode("Method");

        Method[] methods = obj.getClass().getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            DefaultMutableTreeNode m = new DefaultMutableTreeNode(method);
            methodTree.add(m);
        }
        
        // Create object 
        
        
        root.add(objectTree);
        root.add(fieldTree);
        root.add(methodTree);
        
        classTree.add(root);
        model.reload();
    }
    
    public void changeFieldValue(Field field, String value) {

        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (node == null || node.getParent() == null) {
            return;
        }
        
        DefaultMutableTreeNode root = getObjectNode(node);
        Object obj = root.getNextNode().getUserObject();
        
        field.setAccessible(true);
        try {
            Class<?> type = field.get(obj).getClass();
            field.set(obj, ObjectUtility.convertObject(type, value));
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        createObjectTree(obj, root.getUserObject().toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();

        if (action.equals("Add")) {
            String constructorName = constructorField.getText();
            String objectName = this.objectName.getText();
            if (!constructorName.equals("") && !objectName.equals("")) {
                Object obj;
                try {
                    // Create new instance!!
                    obj = constructorField.getConstructor().newInstance();
                    createObjectTree(obj, objectName);
                    model.reload();
                } catch (IllegalArgumentException e1) {
                    Console.err.println(e1);
                } catch (InstantiationException e1) {
                    Console.err.println(e1);
                } catch (IllegalAccessException e1) {
                    Console.err.println(e1);
                } catch (InvocationTargetException e1) {
                    Console.err.println(e1);
                }
            }
        }
        else if (action.equals("Delete")) {
            DefaultMutableTreeNode node = 
                (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

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
    
    private DefaultMutableTreeNode getObjectNode(DefaultMutableTreeNode node) {
        if (node == null || node.getParent() == null) {
            return null;
        }

        while ( node.getParent().toString().equals("Object") == false ) {
            node = (DefaultMutableTreeNode) node.getParent();
        }
        return node;
    }
        
    private ObjectPropertiesPanel propertiesPanal;
    public void setPropertiesPanel(ObjectPropertiesPanel panel) {
        propertiesPanal = panel;
    }
}

