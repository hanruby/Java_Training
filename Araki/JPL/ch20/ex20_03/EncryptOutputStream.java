package ch20.ex20_03;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * XORを用いて出力を復号化するストリーム 
 * @author ato
 */
public class EncryptOutputStream extends FilterOutputStream {
    
    private byte key = (byte)0xAB;

    protected EncryptOutputStream(OutputStream out) {
        super(out);
    }

    @Override
    public void write(int b) throws IOException {
        b ^= key;
        super.write(b);
    }
}
