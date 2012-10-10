package ch23.ex23_01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamPlug extends Thread {
    
    private InputStream in;
    private OutputStream out;
    
    public StreamPlug(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    /**
     * 親のプロセスの標準ストリームを子プロセスの標準ストリームに結びつける
     * @param cmd
     * @return
     * @throws IOException
     */
    public static Process userProg(String cmd)
    throws IOException
    {
        Process proc = Runtime.getRuntime().exec(cmd);
        plugTogether(System.in,  proc.getOutputStream());
        plugTogether(System.out, proc.getInputStream());
        plugTogether(System.err, proc.getErrorStream());
        return proc;
    }

    /**
     * 1つのストリームからバイトを読みだして、そのバイトをもう1つのストリームに書きこむことにより、2つのストリームを結合するためのメソッド 
     */
    public static void plugTogether(InputStream in, OutputStream out) {
        new StreamPlug(in, out);
    }
    public static void plugTogether(OutputStream out, InputStream in) {
        new StreamPlug(in, out);
    }
    
    @Override
    public void run() {
        // TODO Auto-generated method stub
        super.run();
    }

}
