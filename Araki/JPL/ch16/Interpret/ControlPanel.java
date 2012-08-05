package ch16.Interpret;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ControlPanel extends JPanel implements ActionListener{

    private static final long serialVersionUID = 1406985790901319936L;

    private JPanel panel;

    private JTextField fieldField;
    private JTextField objectField;
    private JLabel typeField;
    private JTextField valueField;
    private ObjectField objField;
    
    private JButton changeButton;
    
    private Object obj;
    private Field field;
    
    private ObjectTree objectTree;
    
    ControlPanel(ObjectTree objectTree) {
        super();
        
        this.objectTree = objectTree;
        panel = new JPanel();

        objectField = new JTextField(10);
        fieldField = new JTextField(20);
        typeField = new JLabel("", 10);
        valueField = new JTextField(10);

        changeButton = new JButton("Set");
        changeButton.addActionListener(this);
        changeButton.setActionCommand("Change");

        add(panel);
    }
    
    public void updateInfo(Object obj, Field field, Object h) throws IllegalArgumentException, IllegalAccessException {
        this.obj = obj;
        this.field = field;
        
        removeContents();
        
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
        panel.add(changeButton);
        
        this.updateUI();
    }
    

    private JTextField objectName;
    private ConstructorField constructorField;
    
    public void addObject(Constructor<?> constructor) {
     
        removeContents();
        
        // create control contents
        objectName = new JTextField(10);
        constructorField = new ConstructorField(20);
        JButton addButton = new JButton("+");
        addButton.addActionListener(this);
        addButton.setActionCommand("Add");
        JButton deleteButton = new JButton("-");
        deleteButton.addActionListener(this);
        deleteButton.setActionCommand("Delete");
        
        objField = new ObjectField(20);

        panel.add(objectName);
        panel.add(constructorField);
        panel.add(objField);
        panel.add(addButton);
        panel.add(deleteButton);

        
        this.updateUI();
    }
    
    private void removeContents() {
        this.panel.removeAll();
        this.updateUI();
    }
   

    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();

        if (action.equals("Change")) {
            // Modify the object of Tree
            objectTree.changeFieldValue(field, valueField.getText());
            removeContents();
        }
        else if (action.equals("Add")) {
            String constructorName = constructorField.getText();
            String objectName = this.objectName.getText();
            if (!constructorName.equals("") && !objectName.equals("")) {
                objectTree.addObject(objectName, constructorField.getConstructor());
            }

        }

    }
}
