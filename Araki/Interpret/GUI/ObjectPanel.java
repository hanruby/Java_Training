package GUI;

import java.awt.Dimension;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Array;

import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.TransferHandler;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class ObjectPanel extends JPanel {

    private static final long serialVersionUID = -4723436391362004377L;

    private JPanel base;
    private DefaultTableModel tableModel;
    private JScrollPane tablePanel;

    private Object array;

    private TransferHandler transferHandler;
    
    public ObjectPanel(Object obj) {
        base = new JPanel();
        tablePanel = new JScrollPane(base, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        transferHandler = new TransferHandler() {

            private static final long serialVersionUID = 5178612028854788315L;

            public final DataFlavor localObjectFlavor = new DataFlavor (
                    DefaultMutableTreeNode.class, "This is tree node.");

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

        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                updateArray();
                drawArray(array);
            }
        });

        drawArray(obj);
        add(tablePanel);
        add(ok);
        updateUI();
    }
    
    @Override
    public void setPreferredSize(Dimension preferredSize) {
        tablePanel.setPreferredSize(new Dimension(preferredSize.width, preferredSize.height - 40));
        super.setPreferredSize(preferredSize);
    }
    
    public void drawArray(Object obj) {
        array = obj;            
        
        switch (ArrayUtility.getDim(array)) {
        case 2: 
        {
            base.removeAll();

            int colmun = Array.getLength(Array.get(array,0));
            int row = Array.getLength(array);

            tableModel = new DefaultTableModel(0,colmun);       
            JTable table = new JTable(tableModel);
            
            for (int r = 0; r < row; r++) {
                Object line = Array.get(array,r);
                Object[] l = ArrayUtility.castArray(line);
                tableModel.addRow(l);
            }

            setDropHandler(table);
            base.add(table);
            updateUI();
            
            break;
        }
        case 1:
        {
            base.removeAll();
            
            int index = Array.getLength(array);
            
            tableModel = new DefaultTableModel(0,index);       
            JTable table = new JTable(tableModel);
            
            Object[] l = ArrayUtility.castArray(array);
            tableModel.addRow(l);

            setDropHandler(table);
            base.add(table);
            updateUI();
            
            break;
        }

        }
    }
    
    private void setDropHandler(JTable table) {
        // ドロップされたとき
        table.setDropMode(DropMode.ON);
        table.setDragEnabled(true);
        table.setTransferHandler(transferHandler);
    }
    
    public void updateArray() {

        int rowl = Array.getLength(array);

        switch (ArrayUtility.getDim(array)) {                
        case 2:
        {
            for (int r = 0; r < rowl; r++) {

                Object line = Array.get(array,r);
                int column = Array.getLength(line);
                for (int c = 0; c < column; c++) {
                    try {
                        Array.set(line, c, ObjectUtility.convertObject(Array.get(line, c).getClass(), tableModel.getValueAt(r, c).toString()));    
                    } catch (java.lang.NumberFormatException e) {
                        Console.err.printf("Number format was wrong at (%d,%d) of table. Your input string was : \"%s\". Please input correct format string. %n",c+1 , r+1, tableModel.getValueAt(r, c).toString());
                    }
                }

            }
            break;
        }
        case 1:
        {
            int index = Array.getLength(array);
                for (int i = 0; i < index; i++) {
                    try {
                        Array.set(array, i, ObjectUtility.convertObject(Array.get(array, i).getClass(), tableModel.getValueAt(0, i).toString()));    
                    } catch (java.lang.NumberFormatException e) {
                        Console.err.printf("Number format was wrong at (%d) of table. Your input string was : \"%s\". Please input correct format string. %n",i+1 , tableModel.getValueAt(0, i).toString());
                    }
                }
            
        }
        }
    }
    
    public Object getArrayObject() {
        return array;
    }
}
