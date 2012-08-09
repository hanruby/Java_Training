package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class InterpretGUI extends JFrame{
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        new InterpretGUI("Interpret");
    }
    
    private JTextArea textArea;
    private Console console = new Console();
    
    @SuppressWarnings("rawtypes")
    public InterpretGUI(String title) {
        setTitle(title);
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel viewerPanel = new JPanel();
        JPanel operationPanel = new JPanel();

        JPanel subPanel = new JPanel();
    
        textArea = new JTextArea();
        textArea.setLineWrap(true);

        ObjectTree objectTree = new ObjectTree();
        ClassTree classTree = new ClassTree();
        ControlPanel controlPanel = new ControlPanel(objectTree);
        classTree.setPropertiesPanel(controlPanel);
        objectTree.setPropertiesPanel(controlPanel,subPanel);
        
        JScrollPane consoleScrollPanel = new JScrollPane(console, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        JScrollPane controlScrollPanel = new JScrollPane(controlPanel, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        consoleScrollPanel.setPreferredSize(new Dimension(200, 360));
        classTree.setPreferredSize(new Dimension(400, 360));
        objectTree.setPreferredSize(new Dimension(400, 360));
        controlScrollPanel.setPreferredSize(new Dimension(600, 200));
        subPanel.setPreferredSize(new Dimension(400, 200));
        
        
        viewerPanel.add(consoleScrollPanel);
        viewerPanel.add(classTree);
        viewerPanel.add(objectTree);

        operationPanel.add(controlScrollPanel);
        operationPanel.add(subPanel);

        Container contentPane = getContentPane();
        contentPane.add(viewerPanel, BorderLayout.WEST);
        contentPane.add(operationPanel, BorderLayout.SOUTH);
        
        classTree.createClassTree(java.lang.Object.class);
        classTree.createClassTree(java.util.HashMap.class);
        classTree.createClassTree(GUI.InterpretGUI.class);
        classTree.createClassTree(java.awt.Frame.class);
        
        objectTree.createObjectTree(new java.util.HashMap(), "HashMap object");
        objectTree.createObjectTree("string", "string object");
        objectTree.createObjectTree(new Boolean(true), "true");
        String[][] hoge = {{"aaa","bbb"},{"ccc","ddd"}};
        objectTree.createObjectTree(hoge, "string array");
        objectTree.createObjectTree(new Integer[4][3], "null array");
        pack();

        setVisible(true);
    }

}