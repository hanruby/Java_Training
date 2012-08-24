package ch20.ex20_01;

import java.io.*;

/**
 * P.443 <br> 
 * 入力を出力へコピーし、その過程で特定のバイト値を別の値へ変換する
 * 
 * 
 */
public class TranslateByte {

    public static void main(String[] args) throws IOException {
        
        translate(args[0],args[1]);
    }

    private static void translate(String in, String out) throws IOException {
        byte from = (byte) in.charAt(0);
        byte to = (byte) out.charAt(0);
        int b;
        
        while ((b = System.in.read()) != -1) {
            System.out.write(b == from ? to : b);
        }
    }
}