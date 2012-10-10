package ch23.ex23_01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class Programs {

    public static Process userProg(String cmd)
    throws IOException
    {
        Process proc = Runtime.getRuntime().exec(cmd);
        plugTogether(System.in,  proc.getOutputStream());
        plugTogether(System.out, proc.getInputStream());
        plugTogether(System.err, proc.getErrorStream());
        return proc;
    }

    private static void plugTogether(PrintStream out, InputStream inputStream) {
        // TODO Auto-generated method stub
        
    }

    private static void plugTogether(InputStream in, OutputStream outputStream) {
        // TODO Auto-generated method stub
        
    }
}
