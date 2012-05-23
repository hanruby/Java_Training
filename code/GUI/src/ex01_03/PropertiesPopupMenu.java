package ex01_03;

import java.awt.Color;
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

            add(menu);
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
            
            add(menu);
        }
        {
            // Font color
            Menu menu = new Menu("Font color");
            MenuItem item;
            
            ActionListener menuListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Config conf = new Config(clock.getConfig());
                    try {
                        conf.setFontColor((Color)(Color.class.getField((String)e.getActionCommand()).get(null)));
                    } catch (IllegalArgumentException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (SecurityException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (IllegalAccessException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (NoSuchFieldException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    clock.setConfig(conf);
                }
            };

            item = new MenuItem("BLACK"); 
            item.addActionListener(menuListener);
            menu.add(item);

            item = new MenuItem("GREEN"); 
            item.addActionListener(menuListener);
            menu.add(item);

            item = new MenuItem("ORANGE");
            item.addActionListener(menuListener);
            menu.add(item);
            
            item = new MenuItem("WHITE");
            item.addActionListener(menuListener);
            menu.add(item);
            
            add(menu);
        }
        {
            // Background color
            Menu menu = new Menu("Background color");
            MenuItem item;
            
            ActionListener menuListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Config conf = new Config(clock.getConfig());
                    try {
                        conf.setBackgroundColor((Color)(Color.class.getField((String)e.getActionCommand()).get(null)));
                    } catch (IllegalArgumentException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (SecurityException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (IllegalAccessException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (NoSuchFieldException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    clock.setConfig(conf);
                }
            };

            item = new MenuItem("BLACK"); 
            item.addActionListener(menuListener);
            menu.add(item);

            item = new MenuItem("GREEN"); 
            item.addActionListener(menuListener);
            menu.add(item);

            item = new MenuItem("ORANGE");
            item.addActionListener(menuListener);
            menu.add(item);
            
            item = new MenuItem("WHITE");
            item.addActionListener(menuListener);
            menu.add(item);
            
            add(menu);
        }
        
    }

}
