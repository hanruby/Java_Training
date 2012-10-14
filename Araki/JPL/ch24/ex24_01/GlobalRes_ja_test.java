package ch24.ex24_01;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class GlobalRes_ja_test extends ResourceBundle {
        
    public static final String HELLO = "hello";
    public static final String GOODBYE = "goodbye";
    
    @Override
    protected Object handleGetObject(String key) {
        if (HELLO.equals(key)) {
           return "こんちわ"; 
        }
        else if (GOODBYE.equals(key)) {
            return "ばいばい";
        }

        return null;
    }

    @Override
    public Enumeration<String> getKeys() {
        // TODO Auto-generated method stub
        return null;
    }
}
