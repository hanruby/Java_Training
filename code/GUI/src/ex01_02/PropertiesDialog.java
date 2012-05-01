package ex01_02;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PropertiesDialog extends Dialog {

    private static final long serialVersionUID = 210549325687453262L;
    
    public PropertiesDialog(Frame owner) {
        super(owner, true);
        
        setTitle("Properties");
        setSize(400, 400);

        Button cancel = new Button("cancel");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(cancel , BorderLayout.CENTER);
        
        addWindowListener(new PropertiesDialogListener());
                
        setVisible(true);
    }
    
    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        super.paint(g);
    }
    
    
    /**
     * Windowがクローズされた場合
     * @author ato
     *
     */
    class PropertiesDialogListener extends WindowAdapter {
        @Override
        public void windowClosing (WindowEvent event) {
            // Dialogを閉じる
            dispose();
        }
    }
}
