package ex01_03;

import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PropertiesPopupMenu extends PopupMenu{

    private static final long serialVersionUID = 1L;

    public PropertiesPopupMenu() {
        Menu properties_menu = new Menu("Properties");
        Menu fontname = new Menu("Font name");
        MenuItem font1 = new MenuItem("Monaco");
        font1.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // TODO Auto-generated method stub
                            
                        }
        });
        
        fontname.add(font1);
        properties_menu.add(fontname);
        add(properties_menu);
    }
    
}
