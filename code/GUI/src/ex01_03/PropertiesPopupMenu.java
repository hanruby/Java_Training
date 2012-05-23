package ex01_03;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PropertiesPopupMenu extends PopupMenu{

    private static final long serialVersionUID = 1L;
    private DigitalClock clock;

    public PropertiesPopupMenu(Frame owner) {
        clock = (DigitalClock)owner;

        Menu properties_menu = new Menu("Properties");

        {
            // Ref: http://www.java2s.com/Code/Java/Swing-JFC/AsimpleexampleofJPopupMenu.htm

            // Font name
            Menu menu = new Menu("Font");
            MenuItem item;
 
            ActionListener menuListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Config conf = new Config(clock.getConfig());
                    conf.setFont(new Font((String)e.getActionCommand(),conf.getFont().getStyle(),conf.getFont().getSize()));
                    clock.setConfig(conf);
                }
            };

            item = new MenuItem("Monaco");
            item.addActionListener(menuListener);
            menu.add(item);

            item = new MenuItem("Console");
            item.addActionListener(menuListener);
            menu.add(item);

            item = new MenuItem("Times");
            item.addActionListener(menuListener);
            menu.add(item);

            properties_menu.add(menu);
        }
        {
            // Font size
            Menu menu = new Menu("Font size");
            MenuItem item;
            
            ActionListener menuListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Config conf = new Config(clock.getConfig());
                    conf.setFont(new Font(conf.getFont().getFontName(),conf.getFont().getStyle(),Integer.parseInt((String)e.getActionCommand())));
                    clock.setConfig(conf);
                }
            };

            item = new MenuItem("12"); 
            item.addActionListener(menuListener);
            menu.add(item);

            item = new MenuItem("20"); 
            item.addActionListener(menuListener);
            menu.add(item);

            item = new MenuItem("30");
            item.addActionListener(menuListener);
            menu.add(item);
            
            properties_menu.add(menu);
        }

        add(properties_menu);
        
    }

}
