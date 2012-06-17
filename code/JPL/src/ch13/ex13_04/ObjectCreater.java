package ch13.ex13_04;

import java.util.ArrayList;
import java.util.List;


public class ObjectCreater {
    
    public static List<Object> parse(String str) {
        if(str == null) {
            throw new NullPointerException();
        }
        
        ArrayList<Object> result = new ArrayList<Object>();
        
        String[] type_value_pairs = str.split("\n");
        
        for (String pair : type_value_pairs) {
            
            String type = pair.split(" ")[0];
            String value = pair.split(" ")[1];

            if(type == null || value == null) {
                throw new IllegalArgumentException("Format error. Please check the input format.");
            }
            
            for (Type supporttype : Type.values()) {
                if(supporttype.name.equals(type)) {
                    result.add(supporttype.createObject(value));
                    System.out.println(type + " " + value);
                    break;
                }
            }
        }
        
        return result;
    }
    
    private enum Type {
        BOOLEAN("Boolean") {
            Object createObject(String value) {
                return null;
            }
        },
        
        BYTE("Byte") {
            Object createObject(String value) {
                return null;
            }
        },
        
        CHAR("Char") {
            Object createObject(String value) {
                return null;
            }
        },
        
        SHORT("Short") {
            Object createObject(String value) {
                return null;
            }
        },
        
        INTEGER("Integer") {
            Object createObject(String value) {
                return null;
            }
        },
        
        LONG("Long") {
            Object createObject(String value) {
                return null;
            }
        },

        FLOAT("Float") {
            Object createObject(String value) {
                return null;
            }
        },

        DOUBLE("Double") {
            Object createObject(String value) {
                return null;
            }
        };
        
        String name;
        
        Type(String name) { this.name = name; }

        public String toString() { return name; }
        
        abstract Object createObject(String value);
    }
}
