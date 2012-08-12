package GUI;

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

    public ObjectPanel(Object obj) {
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
                drawArray(array);
            }
        });

        add(ok);
        updateUI();
    }
    
    public void drawArray(Object obj) {
        array = obj;            
        
        if (array.getClass().isArray()) {
        
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
                try {
                    Array.set(line, c, ObjectUtility.convertObject(Array.get(line, c).getClass(), tableModel.getValueAt(r, c).toString()));    
                } catch (java.lang.NumberFormatException e) {
                    Console.err.printf("Number format was wrong at (%d,%d) of table. Your input string was : \"%s\". Please input correct format string. %n",c+1 , r+1, tableModel.getValueAt(r, c).toString());
                }
            }
        }
    }
    
    public Object getArrayObject() {
        return array;
    }
}
