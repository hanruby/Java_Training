package practice.image;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ShowImage extends Window implements Runnable {

    private static final long serialVersionUID = 155671690920126690L;

    private Image backgroundImage;
    
    ShowImage(Frame owner) throws HeadlessException {
        super(owner);
        // TODO Auto-generated constructor stub
        loadImage();
        setSize(backgroundImage.getWidth(this),backgroundImage.getHeight(this));
        setBackground(new Color(0,0,0,0));
        setVisible(true);
    }
    
    private void loadImage() {
        try {
            backgroundImage = ImageIO.read(new File("image/1000px-BlankMap-World-162E.svg.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        g.drawImage(backgroundImage, 0, 0, this);
        super.paint(g); 
    }
    
    public static void main(String[] args) {
        Frame f = new Frame();
        new ShowImage(f);
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }
        
    /**
     * Windowがクローズされた場合
     * @author ato
     *
     */
    class WindowListener extends WindowAdapter {
        @Override
        public void windowClosing (WindowEvent event) {
            System.exit (0);
        }
    }

}
