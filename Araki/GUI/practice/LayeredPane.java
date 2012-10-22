package practice;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class LayeredPane extends JFrame {

    public static void main(String[] args) {
        new LayeredPane();
    }

    public LayeredPane() {
        // set LAF to default
        String lafClassName = "javax.swing.plaf.metal.MetalLookAndFeel";
        try {
            UIManager.setLookAndFeel(lafClassName);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit

        // setup
        setTitle("Layerd Panel");
        setSize(300, 300);
        setVisible(true);

        // layer
        JLayeredPane layer = new JLayeredPane();
        add(layer);

        // opaque panel setup
        JPanel panel1 = getOpaquePanel(250, 200, 1);
        JPanel panel2 = getOpaquePanel(200, 150, 2);
        JPanel panel3 = getOpaquePanel(300, 50, 3);

        // add panel to stage
        layer.add(panel1, 0);
        layer.add(panel2, 1);
        layer.add(panel3, 2);
    }

    public JPanel getOpaquePanel(int width, int height, int num) {
        // create new instance
        JPanel panel = new JPanel() {
            public void paint(Graphics g) {
                // clear buffer
                super.paint(g);

                Graphics2D graphics = (Graphics2D) g;
                graphics.setColor(new Color(30, 30, 30, 30));
                graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
            }
        };
        // panel setup
        panel.setSize(width, height);
        panel.setOpaque(false); // transparency
        panel.setLocation(0, 0);
        

        // set label
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel("Panel : " + new Integer(num).toString()),
                BorderLayout.PAGE_END);
        panel.add(new JButton("hoge"), BorderLayout.EAST);

        return panel;
    }

}
