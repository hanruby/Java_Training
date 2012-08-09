package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.*;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ObjectMaker extends JPanel implements ActionListener {
    
    private static final long serialVersionUID = 3919669191717348185L;
    
    private JTextField objectName;
    private ConstructorField methodName;
    private JButton execButton;

    public static Object createObject(Constructor<?> constructor, String argstr) throws Exception {
        Object obj = null;
        
        String[] values = argstr.split(",");
        Class<?>[] types = (Class<?>[]) constructor.getGenericExceptionTypes(); 
        Object[] objs = null;

        objs = ObjectUtility.convertObjects(types, values);
        obj = constructor.newInstance(objs);

        return obj;
    }

    public static Object createObject(Constructor<?> constructor, Object... argo) throws Exception {
        Object obj = null;

        obj = constructor.newInstance(argo);

        return obj;
    }
    
    public ObjectMaker() {
        JPanel panel = new JPanel();
        
        objectName = new JTextField(10);
        methodName = new ConstructorField(30);
                
        execButton = new JButton("OK");
        execButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("OKOK");
                System.out.println(methodName.getConstructor().toString());
            }
        });
        
        panel.add(objectName);
        panel.add(methodName);
        panel.add(execButton);
        
        add(panel);
    }
    
    public void updateMethodName(String name){
        this.methodName.setText(name);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        
    }
}


