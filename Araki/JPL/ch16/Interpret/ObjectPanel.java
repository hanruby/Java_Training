package ch16.Interpret;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.lang.reflect.Array;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class ObjectPanel extends JPanel {

    private static final long serialVersionUID = -4723436391362004377L;

    private JPanel base;
    private DefaultTableModel tableModel;
    
    private Object array;

    private JTree tree;
    
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

            int colmun = Array.getLength(array);

            tableModel = new DefaultTableModel(0,colmun);       
            JTable table = new JTable(tableModel);
        
            for (int row = 0; row < colmun; row++) {
                Object[] arr = (Object[]) Array.get(array,row);
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
                Array.set(line, c, ObjectUtility.convertObject(tableModel.getValueAt(r, c).getClass(), (String)tableModel.getValueAt(r, c)));
            }
        }
    }
    
    public Object getArrayObject() {
        return array;
    }

    public void setObjectTree(JTree tree) {
        this.tree = tree;
    }
    
    private void updateTree() {
        if (tree != null) {
            tree.updateUI();
        }
    }
}
