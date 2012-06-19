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
        
        search:
        for (String pair : type_value_pairs) {
            
            if( pair.split(" ").length != 2) {
                throw new IllegalArgumentException("Format error. \"" + pair + "\" is incorrect format.");
            }
            
            String type = pair.split(" ")[0];
            String value = pair.split(" ")[1];
            
            for (Type supporttype : Type.values()) {
                if(supporttype.name.equals(type)) {
                    result.add(supporttype.createObject(value));
                    System.out.println(type + " " + value);
                    continue search;
                }
            }
            
            throw new IllegalArgumentException("Format error. \"" + type + "\" is not support.");
        }
        
        return result;
    }
    
    private enum Type {
        BOOLEAN("Boolean") {
            Object createObject(String value) {
                return Boolean.parseBoolean(value);
            }
        },
        
        BYTE("Byte") {
            Object createObject(String value) {
                return Byte.parseByte(value, 10);
            }
        },
        
        CHAR("Character") {
            Object createObject(String value) {
                return value.charAt(0);
            }
        },
        
        SHORT("Short") {
            Object createObject(String value) {
                return Short.parseShort(value, 10);
            }
        },
        
        INTEGER("Integer") {
            Object createObject(String value) {
                return Integer.parseInt(value, 10);
            }
        },
        
        LONG("Long") {
            Object createObject(String value) {
                return Long.parseLong(value, 10);
            }
        },

        FLOAT("Float") {
            Object createObject(String value) {
                return Float.parseFloat(value);
            }
        },

        DOUBLE("Double") {
            Object createObject(String value) {
                return Double.parseDouble(value);
            }
        };
        
        String name;
        
        Type(String name) { this.name = name; }

        public String toString() { return name; }
        
        abstract Object createObject(String value);
    }
}
