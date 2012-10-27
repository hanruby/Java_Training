package ex02_04;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ColorPicker extends JPanel{

    private static final long serialVersionUID = 1L;
    
    private BufferedImage colorImage = null;
    private JPanel colorPanel = null;
    private JPanel selectedColorPanel = null;   
    private JPanel previousColorPanel = null;
    
    private Color previousColor;
    private Color selectedColor;

    public ColorPicker(Color color) {
        previousColor = color;
        selectedColor = color;
        
        LocalMouseListener mouseEvent = new LocalMouseListener();
        
        loadColorImage();
        
        colorPanel = new JPanel();
        colorPanel.addMouseListener(mouseEvent);
        colorPanel.addMouseMotionListener(mouseEvent);
        colorPanel.setSize(colorImage.getWidth(), colorImage.getHeight());
        
        previousColorPanel = new JPanel();
        selectedColorPanel = new JPanel();
        createWindow();
        setSize(430, 280);
        setPreferredSize(getSize());
    }
    
    private void createWindow() {
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        
        setFont(new Font("Arial",Font.PLAIN,12)); // font set for properties dialog.
        setLayout(gridbag);
        
        c.fill = GridBagConstraints.BOTH;
        {
            c.weightx = 30;
            c.weighty = 3.0;
            c.gridheight = 3;
            c.gridwidth = 1;
            {
                gridbag.setConstraints(colorPanel, c);
                add(colorPanel);
            }
        }
        {
            c.weightx = 5;
            c.weighty = 1.0;
            c.gridheight = 1;
            c.gridwidth = 1;
            {
                c.gridwidth = GridBagConstraints.REMAINDER;
                JLabel label = new JLabel("Previous color : ", JLabel.LEFT);
                previousColorPanel.add(label);
                gridbag.setConstraints(previousColorPanel, c);
                add(previousColorPanel);
            }
            {
                c.gridwidth = GridBagConstraints.REMAINDER;
                JLabel label = new JLabel("Selected color : ", JLabel.LEFT);
                selectedColorPanel.add(label);
                gridbag.setConstraints(selectedColorPanel, c);
                add(selectedColorPanel);
            }
            {
                c.weighty = 3.0;
                c.gridwidth = GridBagConstraints.REMAINDER;
                JPanel panel = new JPanel();
                gridbag.setConstraints(panel, c);
                add(panel);
            }
        }
    }

    private void loadColorImage() {
        try {
            colorImage = ImageIO.read(new File("image/color.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        Graphics2D colorPanelGraphic = (Graphics2D) colorPanel.getGraphics();
        colorPanelGraphic.drawImage((Image)colorImage, 0, 0, this);
        
        Graphics2D grd = (Graphics2D) previousColorPanel.getGraphics();
        grd.setColor(previousColor);
        grd.fillRect(10, 23, 60, 20);

        Graphics2D gr = (Graphics2D) selectedColorPanel.getGraphics();
        gr.setColor(selectedColor);
        gr.fillRect(10, 23, 60, 20);
    }
    
    @Override
    public void repaint() {
        super.repaint();
    }
    
    public Color getColor() {
        return selectedColor;
    }
    
    class LocalMouseListener extends MouseAdapter {

        int mouseButton;
        
        @Override
        public void mousePressed(MouseEvent e) {
            mouseButton = e.getButton();
            
            super.mousePressed(e);
        }
        
        @Override
        public void mouseDragged(MouseEvent e) {
            
            // Left button of mouse
            if ( e.getButton() == MouseEvent.BUTTON1 || mouseButton == MouseEvent.BUTTON1) {
                Point draggedPos = e.getPoint();
                if (draggedPos.x >= 0 && draggedPos.y >= 0 &&
                        draggedPos.x < colorImage.getWidth() &&
                        draggedPos.y < colorImage.getHeight() ) {
                    selectedColor = new Color(colorImage.getRGB(draggedPos.x, draggedPos.y));
                    repaint();
                    ColorPicker.this.firePropertyChange("color", previousColor, selectedColor);
                }
            }
            super.mouseDragged(e);
        }
    }
}
