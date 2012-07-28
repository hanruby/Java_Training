package practice;

import javax.swing.JFrame;
import javax.swing.JLabel;
 
public class HelloSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JLabel("Hello, world!"));
        frame.pack(); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    
    
}

