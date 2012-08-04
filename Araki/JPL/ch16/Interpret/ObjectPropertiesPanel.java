package ch16.Interpret;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ObjectPropertiesPanel extends JPanel implements ActionListener{

    private static final long serialVersionUID = 1406985790901319936L;

    private JPanel panel;

    private JTextField fieldField;
    private JTextField objectField;
    private JLabel typeField;
    private JTextField valueField;
    
    private Object obj;
    private Field field;
    
    ObjectPropertiesPanel() {
        super();
        panel = new JPanel();

        objectField = new JTextField(10);
        fieldField = new JTextField(20);
        typeField = new JLabel("", 10);
        valueField = new JTextField(10);

        add(panel);
    }
    
    public void updateInfo(Object obj, Field field, Object h) throws IllegalArgumentException, IllegalAccessException {
        this.obj = obj;
        this.field = field;
        
        this.panel.removeAll();
        
        this.field.setAccessible(true);
        objectField.setText((String) this.obj);
        fieldField.setText(this.field.getName());
        typeField.setText(this.field.getType().getCanonicalName());
        valueField.setText(h.toString());
        //FieldUtility.printObjectField(obj, field);
                
        panel.add(objectField);
        panel.add(fieldField);
        panel.add(typeField);
        panel.add(valueField);
        
        this.updateUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
