package practice;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ColorDialog extends Dialog{

    private static final long serialVersionUID = 1L;
    
    private BufferedImage colorImage = null;
    private Panel colorPanel = null;
    private Panel controlPanel = null;   
    
    private Color newColor = Color.WHITE;

    public ColorDialog(Frame owner) {
        super(owner);

        setTitle("Color Picker");
        //setSize(400, 400);
        Rectangle bounds = this.getGraphicsConfiguration().getBounds();
        setBounds((int)(bounds.width/2)-200,((int)bounds.height/2-200),400,300);
        
        addWindowListener(new LocalWindowListener());
        LocalMouseListener mouseEvent = new LocalMouseListener();
        
        loadColorImage();
        
        colorPanel = new Panel();
        colorPanel.addMouseListener(mouseEvent);
        colorPanel.addMouseMotionListener(mouseEvent);
        colorPanel.setSize(colorImage.getWidth(), colorImage.getHeight());
        
        controlPanel = new Panel();

        createWindow();
        setResizable(false);
       
        setVisible(true);
    }
    
    private void createWindow() {
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        
        setFont(new Font("Arial",Font.PLAIN,12)); // font set for properties dialog.
        setLayout(gridbag);
        
        c.fill = GridBagConstraints.BOTH;
        {
            c.weightx = 1;
            c.weighty = 0;
            c.gridheight = 1;
            c.gridwidth = 2;
            {
                c.gridwidth = GridBagConstraints.REMAINDER;
                Label label = new Label("Please select a color from the color chart by click.");
                gridbag.setConstraints(label, c);
                add(label);
            }
        }
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
                Label label = new Label("Selected color : ", Label.LEFT);
                gridbag.setConstraints(label, c);
                add(label);
            }
            {
                c.gridwidth = GridBagConstraints.REMAINDER;
                gridbag.setConstraints(controlPanel, c);
                add(controlPanel);
            }
            {
                c.weighty = 3.0;
                Panel panel = new Panel();
                gridbag.setConstraints(panel, c);
                add(panel);
            }
        }
        
        {
            
        }
        
    }

    private void loadColorImage() {
        try {
            colorImage = ImageIO.read(new File("image/color.png"));
            System.out.println("Image loaded");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        System.out.println("paint");
        Graphics2D colorPanelGraphic = (Graphics2D) colorPanel.getGraphics();
        colorPanelGraphic.drawImage((Image)colorImage, 0, 0, this);
        
        Graphics2D gr = (Graphics2D) controlPanel.getGraphics();
        gr.setColor(newColor);
        gr.fillRect(10, 10, 60, 40);
        
    }
        
    class LocalWindowListener extends WindowAdapter {
        @Override
        public void windowClosing (WindowEvent event) {
            // Dialogを閉じる
            dispose();
        }
    }
    
    class LocalMouseListener extends MouseAdapter {

        @Override
        public void mouseDragged(MouseEvent e) {
            
            // Left button of mouse
            if ( e.getButton() == MouseEvent.BUTTON1) {
                Point draggedPos = e.getPoint();
                if (draggedPos.x >= 0 && draggedPos.y >= 0 &&
                        draggedPos.x < colorImage.getWidth() &&
                        draggedPos.y < colorImage.getHeight() ) {
                    newColor = new Color(colorImage.getRGB(draggedPos.x, draggedPos.y));
                    System.out.println(newColor);
                    repaint();
                }
            }
            super.mouseDragged(e);
        }
    }
    
    
    public static void main(String[] args) {
        Frame frame = new Frame();
        @SuppressWarnings("unused")
        ColorDialog dialog = new ColorDialog(frame);
    }

}
