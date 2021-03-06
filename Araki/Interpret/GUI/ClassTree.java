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

public class ClassTree extends JPanel implements ActionListener{

    private static final long serialVersionUID = 671352749780328461L;
    
    private JTree classTree;
    private DefaultMutableTreeNode root = new DefaultMutableTreeNode("Class");
    private DefaultTreeModel model;
    private JTextField className;
    
    public ClassTree() {
        
        classTree = new JTree(root);
        classTree.setName("classTree");

        JScrollPane treePanel = new JScrollPane(classTree, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //treePanel.setPreferredSize(new Dimension(400, 300));

        model = (DefaultTreeModel) classTree.getModel();

        // create control contents
        className = new JTextField(10);
        className.setName("classNameField");
        
        JButton addClassButton = new JButton("+");
        addClassButton.setName("addClassButton");
        addClassButton.addActionListener(this);
        addClassButton.setActionCommand("Add");
        
        JButton deleteClassButton = new JButton("-");
        deleteClassButton.setName("deleteClassButton");
        deleteClassButton.addActionListener(this);
        deleteClassButton.setActionCommand("Delete");
    
        // create control panel
        JPanel controlPanel = new JPanel();
        controlPanel.add(className);
        controlPanel.add(addClassButton);
        controlPanel.add(deleteClassButton);
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(treePanel);
        add(controlPanel);
    
        MouseListener ml = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                // Open the popupmenu using left click
                if ( e.getButton() == MouseEvent.BUTTON1) {

                    // Get a member of the class object
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) classTree.getLastSelectedPathComponent();
                    if (node != null) {
                        final Object obj = node.getUserObject();
                        // Constructor
                        if (obj instanceof Constructor<?>) {
                            Constructor<?> constructor = (Constructor<?>) obj;
                            controlPanal.addObject(constructor);
                        }
                    }
                }
                super.mouseClicked(e);
            }
        };
        classTree.addMouseListener(ml);

        // support for drag and drop
        classTree.setDragEnabled(true);
        classTree.setTransferHandler(new ConstructorTransfer());
    }
    

        
    public void addMouseListener(MouseListener ml) {
        this.classTree.addMouseListener(ml);
    }

    public void createClassTree(Class<?> cls) {

        DefaultMutableTreeNode newClass = new DefaultMutableTreeNode(cls.getCanonicalName());

        Constructor<?>[] constructors = cls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            newClass.add(new DefaultMutableTreeNode(constructor));
        }
                
        root.add(newClass);
        model.reload();
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();

        if (action.equals("Add")) {
            String name = className.getText();
            if (!name.equals("")) {
                Class<?> cls = null;
                try {
                    cls = Class.forName(name);
                    createClassTree(cls);
                } catch (ClassNotFoundException e1) {
                    Console.err.printf("Could not found class \"%s\". Please check your input.%n", name);
                }
                model.reload();
            }
        }
        else if (action.equals("Delete")) {
            DefaultMutableTreeNode node = 
                (DefaultMutableTreeNode) classTree.getLastSelectedPathComponent();

            if (node == null || node.getParent() == null) {
                return;
            }

            while ( node.getParent().toString().equals("Class") == false ) {
                node = (DefaultMutableTreeNode) node.getParent();
            }

            node.removeFromParent();
            model.reload();
        }

        className.setText("");
    }
    
    @Override
    public void setPreferredSize(Dimension arg0) {
        super.setPreferredSize(arg0);
    }
    
    private ControlPanel controlPanal;
    public void setPropertiesPanel(ControlPanel panel) {
        controlPanal = panel;
    }
}

class ConstructorTransfer extends TransferHandler {

    private static final long serialVersionUID = -1426178157203230501L;

    // Ref : http://docs.oracle.com/javase/tutorial/uiswing/dnd/dataflavor.html
    public final static DataFlavor localObjectFlavor = new DataFlavor (
            Constructor.class, "This is Constructor");

    public static final DataFlavor[] flavors = {
        localObjectFlavor
    };

    @Override
    protected Transferable createTransferable(JComponent c) {
        JTree tree = (JTree) c;
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (node != null) {
            Object obj = node.getUserObject();

            // Accept constructor object.
            if(obj instanceof Constructor<?>) {
                DataHandler dh = new DataHandler(obj, localObjectFlavor.getMimeType());
                return dh;
            }
        }
        return null;
    }

    @Override
    public int getSourceActions(JComponent arg0) {
        return COPY_OR_MOVE;
    }
}

