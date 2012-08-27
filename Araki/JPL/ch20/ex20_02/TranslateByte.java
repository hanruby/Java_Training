package ch20.ex20_02;

import java.io.*;

/**
 * P.443 <br> 
 * 入力を出力へコピーし、その過程で特定のバイト値を別の値へ変換する
 */
public class TranslateByte extends FilterInputStream {

    private byte from;
    private byte to;

    protected TranslateByte(InputStream in, byte from, byte to) {
        super(in);
        
        this.from = from;
        this.to = to;
    }

    /**
     * from から to へ文字を置換するフィルタ
     */
    @Override
    public int read() throws IOException {
        int b;
        
        if ((b = super.read()) != -1) {
            return (b == from ? to : b);
        }

        return -1;
    }

    /**
     * sample program <br>
     * Usage : java path.to.classfile.TranslateByte b B <br>
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        TranslateByte tb = new TranslateByte(System.in, (byte)args[0].charAt(0),(byte)args[1].charAt(0));
        
        int c;
        while( (c = tb.read()) != -1 ) {
            System.out.print((char)c);
        }
        System.out.println();
    }
}