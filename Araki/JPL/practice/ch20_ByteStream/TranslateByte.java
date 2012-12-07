package practice.ch20_ByteStream;

import java.io.*;

/**
 * P.443 
 */
class TranslateByte {
    public static void main(String[] args) throws IOException
    {
        byte from = (byte) args[0].charAt(0);
        byte to   = (byte) args[1].charAt(0);
        int b;
        while ((b = System.in.read()) != -1)
            System.out.write(b == from ? to : b); // <- 間違ってる
        /* 解説：
         * b は int 型 で from は byte
         * 比較時に from が int へ拡張されて比較される
         * そのため、符号拡張(Signed Extension)が発生し、成り立たない
         */
    }
}
