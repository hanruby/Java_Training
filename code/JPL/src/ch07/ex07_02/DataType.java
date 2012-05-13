package ch07.ex07_02;

import org.junit.Test;

public class DataType {
    boolean bool = true;
    char c = 'a';
    byte b = 1;
    short s = 2;
    int i = 3;
    long l = 4;
    float f = 5.2f;
    double d = 6.3;
    
    @Test
    public void testBoolean() throws Exception {
        // OK
        bool = true;
        bool = false;
        
        // NG
        //bool = '1'; // char
        //bool = 1; // int

        // ---------------
        bool = bool; // boolean
        //bool = c; // char
        //bool = b; // byte
        //bool = s; // short
        //bool = i; // int
        //bool = l; // long 
        //bool = f; // float
        //bool = d; // double
    }
    
    @Test
    public void testChar() throws Exception {
        // OK
        c = '1';
        c = 1;
        c = 0xFFFF;
        
        // NG
        //c = -1; // int
        //c = 0x10000; // int

        // ---------------
        //c = bool; // boolean
        c = c; // char
        //c = b; // byte
        //c = s; // short
        //c = i; // int
        //c = l; // long 
        //c = f; // float
        //c = d; // double
    }
    
    @Test
    public void testByte() throws Exception {
        // OK
        b = '1';
        b = 1;
        b = 127;
        b = -128;
        
        // NG
        //c = 127;
        //c = -129;

        // ---------------
        //b = bool; // boolean
        //b = c; // char
        b = b; // byte
        //b = s; // short
        //b = i; // int
        //b = l; // long 
        //b = f; // float
        //b = d; // double
    }

    @Test
    public void testShort() throws Exception {
        // OK
        s = 1;
        s = 0x7FFF;
        s = -1;
        s = -0x8000;
        
        // NG
        //s = 0xFFFF;
        //s = 0x8000;
        //s = -0x8001;

        // ---------------
        //s = bool; // boolean
        //s = c; // char
        s = b; // byte
        s = s; // short
        //s = i; // int
        //s = l; // long 
        //s = f; // float
        //s = d; // double
    }
    
    @Test
    public void testInt() throws Exception {
        // OK
        i = 1; // int
        i = '1'; // char
        i = 0x7FFFFFFF;
        System.out.println(i);
        i = 0x80000000;
        System.out.println(i);
        i = 0xFFFFFFFF;
        System.out.println(i);
        
        // NG
        //i = 0x100000000L;
        //i = 2.1; // double
        //i = 2.3f; // float
        //i = 1L; // long

        //i = bool;
        //i = f;
        //i = d;
        //i = l;

        // ---------------
        //i = bool; // boolean
        i = c; // char
        i = b; // byte
        i = s; // short
        i = i; // int
        //i = l; // long 
        //i = f; // float
        //i = d; // double
    }
    
    @Test
    public void testLong() throws Exception {
        // OK
        l = 1;
        l = 1L;
        l = 0x7FFFFFFFFFFFFFFFL;
        System.out.println(l);
        l = 0x8000000000000000L;
        System.out.println(l);        
        l = 0xFFFFFFFFFFFFFFFFL;
        System.out.println(l);
        
        // NG
        //l = 0x10000000000000000L;

        // ---------------
        //l = bool; // boolean
        l = c; // char
        l = b; // byte
        l = s; // short
        l = i; // int
        l = l; // long 
        //l = f; // float
        //l = d; // double
    }
    
    @Test
    public void testFloat() throws Exception {
        // OK
        
        // NG

        // ---------------
        //f = bool; // boolean
        f = c; // char
        f = b; // byte
        f = s; // short
        f = i; // int
        f = l; // long 
        f = f; // float
        //f = d; // double
    }

    @Test
    public void testDouble() throws Exception {
        // OK

        // NG

        // ---------------
        //d = bool; // boolean
        d = c; // char
        d = b; // byte
        d = s; // short
        d = i; // int
        d = l; // long 
        d = f; // float
        d = d; // double
    }
}

