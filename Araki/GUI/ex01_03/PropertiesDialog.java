package ex01_03;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PropertiesDialog extends Dialog {

    private static final long serialVersionUID = 210549325687453262L;
    
    private DigitalClock clock;
    private Config defaultConf;
    
    public PropertiesDialog(Window owner) {
        super(owner);

        clock = (DigitalClock)owner;
        defaultConf = new Config(clock.getConfig());

        createPropertiesDialog();
        
        setTitle("Properties");
        //setSize(400, 400);
        Rectangle bounds = this.getGraphicsConfiguration().getBounds();
        setBounds((int)(bounds.width/2)-200,((int)bounds.height/2-200),400,400);
        
        addWindowListener(new PropertiesDialogListener());
                
        setVisible(true);
    }
    
    private void createPropertiesDialog() {
        
        setFont(new Font("Arial",Font.PLAIN,12)); // font set for properties dialog.
        
        setLayout(new GridLayout(2, 1));
        
        Panel propertiesPanel = new Panel(); 
        Panel controlPanel = new Panel();
        
        add(propertiesPanel);
        add(controlPanel);

        {
            propertiesPanel.setLayout(new GridLayout(4, 2));
            
            Choice font_name_list, font_size_list, font_color_list, bg_color_list;
            
            {
                // Font name
                propertiesPanel.add(new Label("Font name",Label.RIGHT));
                font_name_list = new Choice();

                // Load System fonts.
                String fonts[] = PropertiesContents.supportedFonts();

                for (String font : fonts) {
                    font_name_list.add(font);
                }
                
                font_name_list.select(clock.getConfig().getFont().getName());
                font_name_list.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        Config conf = new Config(clock.getConfig());
                        conf.setFont(new Font((String)e.getItem(),conf.getFont().getStyle(),conf.getFont().getSize()));
                        clock.setConfig(conf);
                    }
                });
                propertiesPanel.add(font_name_list);
            }
            {
                // Font size
                propertiesPanel.add(new Label("Font size",Label.RIGHT));
                font_size_list = new Choice();

                // Load Supported size
                int[] sizes = PropertiesContents.supportedFontSizes();

                for (int size : sizes) {
                    font_size_list.add(String.valueOf(size)); 
                }
                
                font_size_list.select(Integer.toString(clock.getConfig().getFont().getSize()));
                font_size_list.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        Config conf = new Config(clock.getConfig());
                        conf.setFont(new Font(conf.getFont().getFontName(),conf.getFont().getStyle(),Integer.parseInt((String)e.getItem())));
                        clock.setConfig(conf);
                    }
                });
                propertiesPanel.add(font_size_list);
            }
            {
                // Font color
                propertiesPanel.add(new Label("Font color",Label.RIGHT));
                font_color_list = new Choice();

                // Load supported colors
                String[] colors = PropertiesContents.supportedColors();

                for (String color : colors) {
                    font_color_list.add(color); 
                }
                
                font_color_list.select(clock.getConfig().getFontColor().toString()); // TODO fix
                System.out.println(clock.getConfig().getFontColor().getClass().getName());
                font_color_list.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        Config conf = new Config(clock.getConfig());
                        try {
                            conf.setFontColor((Color)(Color.class.getField((String)e.getItem()).get(null)));
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
                });
                propertiesPanel.add(font_color_list);
            }
            {
                // Background color
                propertiesPanel.add(new Label("Background color",Label.RIGHT));
                bg_color_list = new Choice();

                // Load supported colors
                String[] colors = PropertiesContents.supportedColors();

                for (String color : colors) {
                    font_color_list.add(color); 
                }

                bg_color_list.select(clock.getConfig().getBackgroundColor().toString());        // TODO fix        
                bg_color_list.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        Config conf = new Config(clock.getConfig());
                        try {
                            conf.setBackgroundColor((Color)(Color.class.getField((String)e.getItem()).get(null)));
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
                });
                propertiesPanel.add(bg_color_list);
            }
        }
        {
            controlPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
            // cancel 
            Button cancel = new Button("Cancel");
            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    clock.setConfig(defaultConf); // もとに戻す
                    dispose();
                }
            });
            // ok
            Button ok = new Button("OK");
            ok.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
            
            controlPanel.add(cancel , BorderLayout.CENTER);
            controlPanel.add(ok , BorderLayout.CENTER);
        }
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
    
    /**
     * Windowがクローズされた場合
     * @author ato
     *
     */
    class PropertiesDialogListener extends WindowAdapter {
        @Override
        public void windowClosing (WindowEvent event) {
            // Dialogを閉じる
            dispose();
        }
    }
    
    /**
     * プロパティが変更されたとき
     * @author ato
     *
     */
    public class PropertiesListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            Config conf = new Config(new Font("Times", Font.CENTER_BASELINE,10), Color.WHITE, Color.DARK_GRAY);
            clock.setConfig(conf);
        }
    }


}
