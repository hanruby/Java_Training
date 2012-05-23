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
            Menu font_name_menu = new Menu("Font");
            MenuItem font_item;
 
            ActionListener menuListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Config conf = new Config(clock.getConfig());
                    conf.setFont(new Font((String)e.getActionCommand(),conf.getFont().getStyle(),conf.getFont().getSize()));
                    clock.setConfig(conf);
                }
            };

            font_item = new MenuItem("Monaco");
            font_item.addActionListener(menuListener);
            font_name_menu.add(font_item);

            font_item = new MenuItem("Console");
            font_item.addActionListener(menuListener);
            font_name_menu.add(font_item);

            font_item = new MenuItem("Times");
            font_item.addActionListener(menuListener);
            font_name_menu.add(font_item);

            properties_menu.add(font_name_menu);
        }
        
        add(properties_menu);
        
    }

}
