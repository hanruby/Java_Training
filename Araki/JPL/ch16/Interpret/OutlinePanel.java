package ch16.Interpret;

import java.lang.reflect.*;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

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

