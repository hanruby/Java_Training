package ch16.Interpret;

import java.awt.Dimension;

import javax.swing.JFrame;

public class ConsoleTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        
        Console consolePanel = new Console();
        frame.add(consolePanel);
        
        consolePanel.setPreferredSize(new Dimension(400, 360));
        frame.pack();
        frame.setVisible(true);        
        
        Console.err.println("hoge");
        Console.err.println("hoge");
    }
}
