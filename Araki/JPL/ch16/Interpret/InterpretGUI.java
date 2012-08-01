package ch16.Interpret;

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
        InterpretGUI interpret = new InterpretGUI("Interpret");
        interpret.setVisible(true);
    }
    
    private JTextArea textArea;
    private Console console = new Console();
    
    public InterpretGUI(String title) {
        setTitle(title);
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel viewerPanel = new JPanel();
        JPanel operationPanel = new JPanel();
    
        textArea = new JTextArea();
        textArea.setLineWrap(true);

        OutlinePanel outline = new OutlinePanel();
        ObjectMaker objMaker = new ObjectMaker();
        
        JScrollPane consolePanel = new JScrollPane(console, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        JScrollPane scrollTextPanel = new JScrollPane(objMaker, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        outline.setPreferredSize(new Dimension(400, 360));
        consolePanel.setPreferredSize(new Dimension(400, 360));
        scrollTextPanel.setPreferredSize(new Dimension(800, 80));
        
        viewerPanel.add(consolePanel);
        viewerPanel.add(outline);

        operationPanel.add(scrollTextPanel);

        Container contentPane = getContentPane();
        contentPane.add(viewerPanel, BorderLayout.WEST);
        contentPane.add(operationPanel, BorderLayout.SOUTH);
        
        outline.createClassTree(java.lang.Object.class);
        outline.createClassTree(java.util.HashMap.class);
        
        pack();
    }

}
