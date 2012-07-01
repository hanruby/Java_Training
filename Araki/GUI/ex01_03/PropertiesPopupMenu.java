package ex01_03;

import java.awt.Color;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PropertiesPopupMenu extends PopupMenu{

    private static final long serialVersionUID = 1L;
    private DigitalClock clock;

    public PropertiesPopupMenu(Window owner) {
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

            // Load Supported fonts.
            String fonts[] = SupportedProperties.supportedFonts();

            for (String font : fonts) {
                item = new MenuItem(font);
                item.addActionListener(menuListener);
                menu.add(item);
            }

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

            // Load Supported size
            int[] sizes = SupportedProperties.supportedFontSizes();
            
            for (int size : sizes) {
                item = new MenuItem(String.valueOf(size)); 
                item.addActionListener(menuListener);
                menu.add(item);
            }
            
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

            // color picker
            {
                item = new MenuItem("Using color picker");
                item.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Config conf = new Config(clock.getConfig());
                        ColorDialog dialog = new ColorDialog(clock.getOwner(), "Color picker for clock text", conf.getFontColor());
                        conf.setFontColor(dialog.getColor());
                        clock.setConfig(conf);
                    }
                });
                menu.add(item);
            }

            // Load supported colors
            String[] colors = SupportedProperties.supportedColors();
            
            for (String color : colors) {
                item = new MenuItem(color); 
                item.addActionListener(menuListener);
                menu.add(item);
            }

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

            // color picker
            {
                item = new MenuItem("Using color picker");
                item.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Config conf = new Config(clock.getConfig());
                        ColorDialog dialog = new ColorDialog(clock.getOwner(), "Color picker for background", conf.getBackgroundColor());
                        conf.setBackgroundColor(dialog.getColor());
                        clock.setConfig(conf);
                    }
                });
                menu.add(item);
            }

            // Load supported colors
            String[] colors = SupportedProperties.supportedColors();
            
            for (String color : colors) {
                item = new MenuItem(color); 
                item.addActionListener(menuListener);
                menu.add(item);
            }
            
            add(menu);
        }
        {
            // Quit
            MenuItem item = new MenuItem("Quit");
            
            ActionListener menuListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit (0);
                }
            };

            item.addActionListener(menuListener);

            add(item);
        }
        
    }

}
