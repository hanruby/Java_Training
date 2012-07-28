package ch16.Interpret;

import javax.swing.*;

public class Console extends JTextArea {

    private static final long serialVersionUID = 1L;
    
    public Console() {
        
        setEditable(false);
        setLineWrap(true);
        
    }
    
    public void writeString(String str) {
        this.append(str+"\n");
    }
}
