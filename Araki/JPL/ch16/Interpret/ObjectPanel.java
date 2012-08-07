package ch16.Interpret;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ObjectPanel extends JPanel {

    private static final long serialVersionUID = -4723436391362004377L;

    private JPanel base;
    private DefaultTableModel tableModel;
    
    private Object array;
    
    public ObjectPanel (Object obj) {
        array = obj;

        
        base = new JPanel();
        JScrollPane tablePanel = new JScrollPane(base, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        drawArray(obj);
        add(tablePanel);

        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                updateArray();
            }
        });
        
        add(ok);
    }
    
    public void drawArray(Object obj) {
        
        if (array.getClass().isArray()) {
            base.removeAll();

            int colmun = Array.getLength(array);

            tableModel = new DefaultTableModel(0,colmun);       
            JTable table = new JTable(tableModel);
        
            
            Object[] arr = new Object[colmun];
            
            for (int row = 0; row < colmun; row++) {
                arr = (Object[]) Array.get(array,row);
                tableModel.addRow(arr);
            }
            base.add(table);
            updateUI();
        }
    }
    
    public void updateArray() {

        int rowl = Array.getLength(array);
        
        for (int r = 0; r < rowl; r++) {
            
            Object line = Array.get(array,r);
            int column = Array.getLength(line);
            
            for (int c = 0; c < column; c++) {
                Array.set(line, c, tableModel.getValueAt(r, c));
            }
        }
        drawArray(array);
    }
    
    public Object getArrayObject() {
        return array;
    }
}
