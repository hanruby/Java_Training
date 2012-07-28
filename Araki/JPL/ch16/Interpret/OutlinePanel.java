package ch16.Interpret;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.*;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class OutlinePanel extends JPanel implements TreeSelectionListener{

    private static final long serialVersionUID = 1L;

    private JTree tree;
    private DefaultMutableTreeNode classTree = new DefaultMutableTreeNode("Class");
    private DefaultTreeModel model;

    private Class<?> cls;
    private Constructor<?>[] constructors;
    private Field[] fields;
    private Method[] methods;
        
    public OutlinePanel() {

        tree = new JTree(classTree);
        add(tree);
        
        model = (DefaultTreeModel) tree.getModel();

        MouseListener ml = new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int selRow = tree.getRowForLocation(e.getX(), e.getY());
                TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
                if(selRow != -1) {
                    System.out.println(selRow +" : "+ selPath.getPathCount());
                }
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (node != null) {
                    Object obj = node.getUserObject();
                    if (obj instanceof Constructor<?>) {
                        System.out.println("Selected node is Constructor: " + node.getUserObject());
                    }
                    else if (obj instanceof Field) {
                        System.out.println("Selected node is Field: " + node.getUserObject());
                    }
                    else if (obj instanceof Method) {
                        System.out.println("Selected node is Method: " + node.getUserObject());
                    }
                }
            }
        };
        tree.addMouseListener(ml);
    }
    
    public void createClassTree(Class<?> cls) {
        this.cls = cls;
        
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(cls.getCanonicalName());

        DefaultMutableTreeNode constructorTree = new DefaultMutableTreeNode("Constructor");
        DefaultMutableTreeNode fieldTree = new DefaultMutableTreeNode("Field");
        DefaultMutableTreeNode methodTree = new DefaultMutableTreeNode("Method");

        constructors = cls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            constructorTree.add(new DefaultMutableTreeNode(constructor));
        }
        
        fields = cls.getDeclaredFields();
        for (Field field : fields) {
            fieldTree.add(new DefaultMutableTreeNode(field));
        }
        
        methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            methodTree.add(new DefaultMutableTreeNode(method));
        }
                
        root.add(constructorTree);
        root.add(fieldTree);
        root.add(methodTree);
        
        classTree.add(root);
        model.reload();
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        // TODO Auto-generated method stub
    }
    
    
}

