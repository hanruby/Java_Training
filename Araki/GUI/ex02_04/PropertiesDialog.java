package ex02_04;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PropertiesDialog extends JDialog {

    private static final long serialVersionUID = 210549325687453262L;
    
    private Config config;
    private Config defaultConf;
    
    public PropertiesDialog(Config config) {
        super(null, ModalityType.APPLICATION_MODAL);

        this.config = config;
        defaultConf = new Config(config);

        createPropertiesDialog();
        
        setTitle("Properties");
        pack();
        
        addWindowListener(new PropertiesDialogListener());
                
        setVisible(true);
    }
    
    private void createPropertiesDialog() {
        
        setFont(new Font("Arial",Font.PLAIN,12)); // font set for properties dialog.
        
        
        GridBagLayout layout = new GridBagLayout();
        
        setLayout(layout);
        
        Panel propertiesPanel = new Panel(); 
        Panel controlPanel = new Panel();

        GridBagConstraints gbc = new GridBagConstraints();

        // Layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.weightx = 1.0d;
        gbc.weighty = 1.0d;
        layout.setConstraints(controlPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0d;
        gbc.weighty = 1.0d;
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        layout.setConstraints(controlPanel, gbc);
    
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
                String fonts[] = SupportedProperties.supportedFonts();

                for (String font : fonts) {
                    font_name_list.add(font);
                }
                
                font_name_list.select(config.getFont().getName());
                font_name_list.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        config.setFont(new Font((String)e.getItem(),config.getFont().getStyle(),config.getFont().getSize()));
                    }
                });
                propertiesPanel.add(font_name_list);
            }
            {
                // Font size
                propertiesPanel.add(new Label("Font size",Label.RIGHT));
                font_size_list = new Choice();

                JSlider font_size_slider = new JSlider(JSlider.HORIZONTAL, 0, 24, 0);
                font_size_slider.setMajorTickSpacing(3);
                font_size_slider.setMinorTickSpacing(1);
                font_size_slider.setPaintTicks(true);
                font_size_slider.setPaintLabels(true);

                // set saved size 
                font_size_slider.setValue(config.getFont().getSize());
                
                font_size_slider.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        JSlider source = (JSlider)e.getSource();
                        config.setFont(new Font(config.getFont().getFontName(),config.getFont().getStyle(),source.getValue()));
                    }
                });
                propertiesPanel.add(font_size_slider);
            }
            {
                // Font color
                propertiesPanel.add(new Label("Font color",Label.RIGHT));
                font_color_list = new Choice();

                // Load supported colors
                String[] colors = SupportedProperties.supportedColors();

                for (String color : colors) {
                    font_color_list.add(color); 
                }
                
                font_color_list.select(config.getFontColor().toString()); // TODO fix
                //System.out.println(config.getFontColor().getClass().getName());
                font_color_list.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        try {
                            config.setFontColor((Color)(Color.class.getField((String)e.getItem()).get(null)));
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
                    }
                });
                propertiesPanel.add(font_color_list);
            }
            {
                // Background color
                propertiesPanel.add(new Label("Background color",Label.RIGHT));
                bg_color_list = new Choice();

                // Load supported colors
                String[] colors = SupportedProperties.supportedColors();

                for (String color : colors) {
                    bg_color_list.add(color); 
                }

                bg_color_list.select(config.getBackgroundColor().toString());        // TODO fix        
                bg_color_list.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        try {
                            config.setBackgroundColor((Color)(Color.class.getField((String)e.getItem()).get(null)));
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
                    PropertiesDialog.this.revert(); // もとに戻す
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
    
    private void revert() {
        config.set(defaultConf); // もとに戻す
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
    
    /**
     * Windowがクローズされた場合
     */
    class PropertiesDialogListener extends WindowAdapter {
        @Override
        public void windowClosing (WindowEvent event) {
            PropertiesDialog.this.revert(); // もとに戻す
            // Dialogを閉じる
            dispose();
        }
    }
}
