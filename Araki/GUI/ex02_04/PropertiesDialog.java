package ex02_04;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
        
        JPanel propertiesPanel = new JPanel(); 
        JPanel controlPanel = new JPanel();

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
                        
            {
                // Font name
                propertiesPanel.add(new JLabel("Font name",JLabel.RIGHT));

                // Load System fonts.
                String fonts[] = SupportedProperties.supportedFonts();

                JComboBox font_name_list = new JComboBox(fonts);

                font_name_list.setSelectedItem(config.getFont().getName());
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
                propertiesPanel.add(new JLabel("Font size",JLabel.RIGHT));
                JSlider font_size_slider = new JSlider(JSlider.HORIZONTAL);

                // slider settings
                font_size_slider.setMaximum(120);
                font_size_slider.setMinimum(10);
                font_size_slider.setMajorTickSpacing(10);
                font_size_slider.setMinorTickSpacing(2);
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
                propertiesPanel.add(new JLabel("Font color",JLabel.RIGHT));

                ColorPicker colorpicker = new ColorPicker(config.getFontColor());
                propertiesPanel.add(colorpicker);
                colorpicker.addPropertyChangeListener(new PropertyChangeListener() {
                    
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        if (evt.getPropertyName().equals("color")) {
                            config.setFontColor((Color)evt.getNewValue());
                        }
                    }
                });
            }
            {
                // Background color
                propertiesPanel.add(new JLabel("Background color",JLabel.RIGHT));

                ColorPicker colorpicker = new ColorPicker(config.getBackgroundColor());
                propertiesPanel.add(colorpicker);
                colorpicker.addPropertyChangeListener(new PropertyChangeListener() {
                    
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        if (evt.getPropertyName().equals("color")) {
                            config.setBackgroundColor((Color)evt.getNewValue());
                        }
                    }
                });
            }
        }
        {
            controlPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
            // cancel 
            JButton cancel = new JButton("Cancel");
            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    PropertiesDialog.this.revert(); // もとに戻す
                    dispose();
                }
            });
            // ok
            JButton ok = new JButton("OK");
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
