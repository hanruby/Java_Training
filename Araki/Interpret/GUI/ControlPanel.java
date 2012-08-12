package GUI;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.swing.BoxLayout;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.TransferHandler;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class ControlPanel extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1406985790901319936L;

    private JPanel panel;

    private JTextField fieldField;
    private JTextField methodField;
    private JTextField objectField;
    private JLabel typeField;
    private JTextField valueField;
    private ObjectField objField;
    
    private JTextField dimsField;
    
    private JButton changeButton;
    
    private Object obj;
    private Field field;
    private Method method;
    private Constructor<?> constructor;
    
    private TransferHandler transferHandler;
    
    private ObjectTree objectTree;
    
    ControlPanel(ObjectTree objectTree) {
        super();
        
        this.objectTree = objectTree;
        panel = new JPanel();

        objectField = new JTextField(10);
        fieldField = new JTextField(20);
        typeField = new JLabel("", 10);
        valueField = new JTextField(10);
        methodField = new JTextField(20);

        changeButton = new JButton("Set");
        changeButton.addActionListener(this);
        changeButton.setActionCommand("Change");

        add(panel);

        transferHandler = new TransferHandler() {

            private static final long serialVersionUID = 496673230072108468L;

            public final DataFlavor localObjectFlavor = new DataFlavor (
                    DefaultMutableTreeNode.class, "This is tree node.");

            @Override
            public boolean canImport(TransferSupport support) {
                // クリップボード経由のデータ転送は扱わない
                if (!support.isDrop()) {
                    return false;
                }

                // Drop locate
                JTable.DropLocation dl = (JTable.DropLocation) support.getDropLocation();

                // タイトル列は無視
                if (dl.getColumn() == 0) {
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
                
                // Drop locate
                JTable.DropLocation dl = (JTable.DropLocation) support.getDropLocation();
 
                try {
                    // ドロップデータ
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) support.getTransferable().getTransferData(localObjectFlavor);
                    Object obj = node.getUserObject();
                    
                    tableModel.setValueAt(obj, dl.getRow(), dl.getColumn());
                    
                    return true;

                } catch (UnsupportedFlavorException ex) {
                    System.out.println(ex);
                } catch (IOException ex) {
                    System.out.println(ex);
                }

                return false;
            }
        };
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
                
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(objectField);
        panel.add(fieldField);
        panel.add(typeField);
        panel.add(valueField);
        panel.add(changeButton);
        
        this.updateUI();
    }
    

    private JTextField objectName;
    private ConstructorField constructorField;
    
    private DefaultTableModel tableModel;
    
    public void addObject(Constructor<?> constructor) {
        this.constructor = constructor;
        removeContents();
        
        // create control contents
        objectName = new JTextField(10);
        constructorField = new ConstructorField(20);
        JButton addButton = new JButton("+");
        addButton.addActionListener(this);
        addButton.setActionCommand("Add");
        
        objField = new ObjectField(20);
        
        constructorField.setText(constructor.getName());

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));
        controlPanel.add(objectName);
        controlPanel.add(constructorField);
        controlPanel.add(objField);
        controlPanel.add(addButton);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(controlPanel);
        
        Class<?>[] clss = constructor.getParameterTypes();
        
        // 引数を持ってない場合
        //if (clss.length == 0) {
            dimsField = new JTextField(20);
            panel.add(dimsField);
        //}
        //else {
            Object[] names = clss;
            Object[] objs = new Object[clss.length];
            tableModel = new DefaultTableModel();
            JTable table = new JTable(tableModel);
            tableModel.addColumn("arg", names);
            tableModel.addColumn("value", objs);

            panel.add(table);
            // ドロップされたとき
            table.setDropMode(DropMode.ON);
            table.setDragEnabled(true);
            table.setTransferHandler(transferHandler);
        //}

        this.updateUI();
    }
    
    public void execMethod(Object obj, Method method) {
        this.obj = obj;
        this.method = method;
        
        removeContents();
        
        typeField.setText(this.method.getReturnType().getCanonicalName());
        objectField.setText((String) this.obj);
        methodField.setText(this.method.getName());

        JButton execButton = new JButton("Exec");
        execButton.addActionListener(this);
        execButton.setActionCommand("Exec");
                
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));
        controlPanel.add(typeField);
        controlPanel.add(objectField);
        controlPanel.add(methodField);
        controlPanel.add(execButton);

        Class<?>[] clss = method.getParameterTypes();
        
        Object[] names = clss;
        Object[] objs = new Object[clss.length];
        tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        tableModel.addColumn("arg", names);
        tableModel.addColumn("value", objs);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(controlPanel);
        panel.add(table);

        // ドロップされたとき
        table.setDropMode(DropMode.ON);
        table.setDragEnabled(true);
        table.setTransferHandler(transferHandler);

        this.updateUI();
    }
    
    private void removeContents() {
        this.panel.removeAll();
        this.updateUI();
    }

    private Object[] collectArgumentsFromTable() {
        // collect arguments
        Object[] initargs = new Object[tableModel.getRowCount()];

        Class<?>[] types = (Class<?>[]) constructor.getParameterTypes(); 
        for (int i = 0; i < initargs.length; i++) {
            initargs[i] = tableModel.getValueAt(i, 1);
            if (initargs[i].getClass().equals(String.class)) {
                try {
                    initargs[i] = ObjectUtility.convertObject(types[i], tableModel.getValueAt(i, 1).toString());                                
                } catch (java.lang.NumberFormatException e1) {
                    Console.err.printf("Number format was wrong at \"%s\" of table. Your input string was : \"%s\". Please input \"%s\" type string. %n",types[i] , tableModel.getValueAt(i, 1).toString(), types[i]);
                    return null;
                }
            }
        }
        return initargs;
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

                // collect arguments
                Object[] initargs = collectArgumentsFromTable();
                if (initargs == null) {
                    return;
                }

                // 配列の指定がある
                if (!dimsField.getText().equals("")) {

                    // 次元をパース
                    int[] dims = null;
                    try {
                        dims = ArrayUtility.parseDimensionString(dimsField.getText());
                    }
                    catch (Exception e1){
                        Console.err.println(e1);
                        e1.printStackTrace();
                    }

                    objectTree.addArrayObject(objectName, constructor, constructor.getDeclaringClass(), dims, initargs);
                }
                // 配列の指定がない
                else {

                    // create new instance
                    objectTree.addObject(objectName, constructor,initargs);
                }
            }

        }
        else if (action.equals("Exec")) {

            // collect arguments
            Object[] initargs = collectArgumentsFromTable();
            if (initargs == null) {
                return;
            }
            
            objectTree.execMethod("result", method, initargs);
        }
    }
}


