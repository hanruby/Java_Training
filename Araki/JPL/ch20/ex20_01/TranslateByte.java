package ch20.ex20_01;

import java.io.*;

/**
 * P.443 <br> 
 * 入力を出力へコピーし、その過程で特定のバイト値を別の値へ変換する
 */
public class TranslateByte {

    /**
     * sample program <br>
     * Usage : java path.to.classfile.TranslateByte b B <br>
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        translate(System.in, System.out, (byte)args[0].charAt(0),(byte)args[1].charAt(0));
    }

    public static void translate(InputStream in, OutputStream out, byte from, byte to) throws IOException {

        int b;
        
        while ((b = in.read()) != -1) {
            out.write(b == from ? to : b);
        }
        
        out.flush();
    }
}