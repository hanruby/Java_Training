package ex01_03;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    
    private Color newColor;
    private Color oldColor;

    public ColorDialog(Window owner, String title, Color color) {
        super(owner, title, ModalityType.APPLICATION_MODAL);
        oldColor = color;
        newColor = color;
        
        //setSize(400, 400);
        Rectangle bounds = this.getGraphicsConfiguration().getBounds();
        setBounds((int)(bounds.width/2)-200,((int)bounds.height/2-200),400,340);
        
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
                c.gridwidth = GridBagConstraints.REMAINDER;
                Panel panel = new Panel();
                gridbag.setConstraints(panel, c);
                add(panel);
            }
        }
        {
            c.weightx = 0;
            c.weighty = 0;
            c.gridheight = 1;
            c.gridwidth = 2;
            {
                Panel panel = new Panel();
                gridbag.setConstraints(panel, c);
                
                panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
                Button cancel = new Button("Cancel");
                cancel.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Dialogを閉じる
                        dispose();
                        newColor = oldColor; // revert
                    }
                });
                Button ok = new Button("OK");
                ok.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        // Dialogを閉じる
                        dispose();
                    }
                });
                panel.add(cancel);
                panel.add(ok);

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
        
        Graphics2D gr = (Graphics2D) controlPanel.getGraphics();
        gr.setColor(newColor);
        gr.fillRect(10, 10, 60, 40);
        
    }
     
    @Override
    public void update(Graphics g) {
        // clearは呼ばない
        this.paint(g);
    }
    
    @Override
    public void repaint() {
        super.repaint();
    }
    
    public Color getColor() {
        return newColor;
    }
   
    class LocalWindowListener extends WindowAdapter {
        @Override
        public void windowClosing (WindowEvent event) {
            // Dialogを閉じる
            dispose();
        }
        
        @Override
        public void windowActivated(WindowEvent e) {
            repaint();
            super.windowActivated(e);
        }
        
        @Override
        public void windowDeactivated(WindowEvent e) {
            repaint();
            super.windowDeactivated(e);
        }
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
                    newColor = new Color(colorImage.getRGB(draggedPos.x, draggedPos.y));
                    repaint();
                }
            }
            super.mouseDragged(e);
        }
    }
}
