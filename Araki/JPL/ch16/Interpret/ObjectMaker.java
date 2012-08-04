package ch16.Interpret;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.*;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.TransferHandler;

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


class ConstructorField extends JTextField {

    private static final long serialVersionUID = 2552391809039249611L;

    private Constructor<?> constructor;

    public ConstructorField(int col) {
        super(col);
        this.setEditable(false);
        
        // ドロップされたとき
        this.setTransferHandler(new TransferHandler(){

            private static final long serialVersionUID = 1156812525274063158L;

            public final DataFlavor localObjectFlavor = new DataFlavor (
                    Constructor.class, "Constructor aa");

            @Override
            public boolean canImport(TransferSupport support) {
                // クリップボード経由のデータ転送は扱わない
                if (!support.isDrop()) {
                    return false;
                }

                // ドロップする位置を常に表示する
                support.setShowDropLocation(true);

                // フレーバの指定
                if (support.isDataFlavorSupported(localObjectFlavor)) {
                    return true;
                }

                return false;
            }

            @Override
            public boolean importData(TransferSupport support) {
                // クリップボード経由のデータ転送は扱わない
                if (!support.isDrop()) {
                    return false;
                }

                ConstructorField text = (ConstructorField)support.getComponent();
                try {
                    // ドロップデータ
                    Object obj = support.getTransferable().getTransferData(localObjectFlavor);
                    if (obj instanceof Constructor<?>) {
                        Constructor<?> constructor = (Constructor<?>) obj;
                        text.setText(constructor.toString());
                        text.setConstructor(constructor);
                    }
                    return true;

                } catch (UnsupportedFlavorException ex) {
                    System.out.println(ex);
                } catch (IOException ex) {
                    System.out.println(ex);
                }

                return false;
            }
        });
    }
    
    public void setConstructor(Constructor<?> constructor) {
        this.constructor = constructor;
    }

    public Constructor<?> getConstructor() {
        return constructor;
    }
}
