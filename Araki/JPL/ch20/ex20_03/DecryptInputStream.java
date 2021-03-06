package ch20.ex20_03;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * XORを用いて入力を暗号化するストリーム 
 * @author ato
 */
public class DecryptInputStream extends FilterInputStream {

    private byte key = (byte)0xAB;

    protected DecryptInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int b = super.read();
        if(b != -1){
            return b ^ key;
        }
        return b;
    }
}
