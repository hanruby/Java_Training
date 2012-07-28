package ch16.Interpret;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class OutlinePanel extends JPanel implements ActionListener{

    private static final long serialVersionUID = 1L;

    private JTree tree;
    private DefaultMutableTreeNode classTree = new DefaultMutableTreeNode("Class");
    private DefaultTreeModel model;
    private JTextField text;
  
    private Class<?> cls;
    private Constructor<?>[] constructors;
    private Field[] fields;
    private Method[] methods;
        
    public OutlinePanel() {
        
        tree = new JTree(classTree);

        JScrollPane treePanel = new JScrollPane(tree, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //treePanel.setPreferredSize(new Dimension(400, 300));

        model = (DefaultTreeModel) tree.getModel();

        // create control contents
        text = new JTextField(10);
        JPanel textPanel = new JPanel();
        textPanel.add(text);
        JButton addButton = new JButton("+");
        addButton.addActionListener(this);
        addButton.setActionCommand("Add");
        JButton deleteButton = new JButton("-");
        deleteButton.addActionListener(this);
        deleteButton.setActionCommand("Delete");
    
        // create control panel
        JPanel controlPanel = new JPanel();
        controlPanel.add(text);
        controlPanel.add(addButton);
        controlPanel.add(deleteButton);
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(treePanel);
        add(controlPanel);
    
        MouseListener ml = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Open the popupmenu using right click
                if ( e.getButton() == MouseEvent.BUTTON3) {

                    // Get a member of the class object
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                    if (node != null) {
                        final Object obj = node.getUserObject();
                        // Constructor
                        if (obj instanceof Constructor<?>) {
                            System.out.println("Selected node is Constructor: " + obj);
                            JPopupMenu popup = new JPopupMenu();
                            JMenuItem exec = new JMenuItem("Create object using this Constructor.");
                            exec.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    System.out.println(obj);
                                }
                            });
                            popup.add(exec);
                            popup.show(e.getComponent(), e.getX(), e.getY());
                        }
                        // Field
                        else if (obj instanceof Field) {
                            System.out.println("Selected node is Field: " + obj);
                        }
                        // Method
                        else if (obj instanceof Method) {
                            System.out.println("Selected node is Method: " + obj);
                        }
                    }
                }
                super.mouseClicked(e);
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
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();

        if (action.equals("Add")) {
            String name = text.getText();
            if (!name.equals("")) {
                Class<?> cls = null;
                try {
                    cls = Class.forName(name);
                    createClassTree(cls);
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                model.reload();
            }
        }
        else if (action.equals("Delete")) {
            DefaultMutableTreeNode node = 
                (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

            if (node == null || node.getParent() == null) {
                return;
            }

            while ( node.getParent().toString().equals("Class") == false ) {
                node = (DefaultMutableTreeNode) node.getParent();
            }

            node.removeFromParent();
            model.reload();
        }

        text.setText("");
    }
    
    @Override
    public void setPreferredSize(Dimension arg0) {
        super.setPreferredSize(arg0);
    }
}

