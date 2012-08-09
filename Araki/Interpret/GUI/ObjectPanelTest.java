package GUI;

import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class ObjectPanelTest {

    public static void main(String[] args) {
        
        String[][] strs = {{"aaa", "bbb"},{"ccc", "ddd"}};
        
        JFrame frame = new JFrame();

        ObjectPanel panel = new ObjectPanel(strs);

        frame.add(panel);
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        
        panel.updateArray();
    }

}
