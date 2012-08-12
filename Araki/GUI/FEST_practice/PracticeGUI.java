package FEST_practice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PracticeGUI extends JFrame {

    private static final long serialVersionUID = 3262411061115510610L;
    private JTextField textToCopy;
    private JLabel copiedText;
    
    public PracticeGUI() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        textToCopy = new JTextField(20);
        textToCopy.setName("textToCopy");
        panel.add(textToCopy);

        JButton copyButton = new JButton("Copy Text!");
        copyButton.setName("copyButton");
        panel.add(copyButton);
        copyButton.setActionCommand("Copy");
        copyButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String action = e.getActionCommand();
                if (action.equals("Copy")) {
                    // set text 
                    copiedText.setText(textToCopy.getText());
                }
            }
        });

        copiedText = new JLabel("text");
        copiedText.setName("copiedText");
        panel.add(copiedText);
        
        this.add(panel);
        this.pack();
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        new PracticeGUI();
    }
}
