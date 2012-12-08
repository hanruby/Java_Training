package ch20.ex20_07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import GUI.ObjectUtility;

/**
 * Attr class from P.66 in JPL
 */
public class Attr {
    private final String name;
    private Object value = null;

    public Attr(String name) {
        this.name = name;
    }

    public Attr(String name, Object value) {
        this.name = name;
        this.value = value;
    }
        
    public Attr(DataInputStream in) throws IOException {
        // read name
        this.name = in.readUTF();
        
        // read class name
        String className = in.readUTF();
        Class<?> cls = null;
               
        try {
            cls = (Class<?>)Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        // read value string
        String value = in.readUTF();

        // restore value from a class name and a string value 
        this.value = ObjectUtility.convertObject(cls, value);
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public Object setValue(Object newValue) {
        Object oldVal = value;
        value = newValue;
        return oldVal;
    }

    public String toString() {
        return name + "='" + value + "'";
    }
    
    public void writeStream(DataOutputStream out) throws IOException{
        out.writeUTF(name);
        out.writeUTF(value.getClass().getName());
        out.writeUTF(value.toString());
    }
}

