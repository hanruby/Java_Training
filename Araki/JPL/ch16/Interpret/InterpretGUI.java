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
    
    public InterpretGUI(String title) {
        setTitle(title);
    
        setBounds(20, 60, 1000, 400);
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        JPanel p = new JPanel();
    
    
        textArea = new JTextArea();
        textArea.setLineWrap(true);

        JScrollPane scrollTextPanel = new JScrollPane(textArea, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        OutlinePanel outline = new OutlinePanel();
        JScrollPane scrollClassPanel = new JScrollPane(outline, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        
        scrollTextPanel.setPreferredSize(new Dimension(600, 360));
        scrollClassPanel.setPreferredSize(new Dimension(400, 360));
        
        p.add(scrollTextPanel);
        p.add(scrollClassPanel);

        Container contentPane = getContentPane();
        contentPane.add(p, BorderLayout.WEST);
    }
}
