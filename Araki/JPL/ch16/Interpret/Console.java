package ch16.Interpret;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.*;

public class Console extends JTextArea {

    private static final long serialVersionUID = 1L;
    
    public Console() {
        
        setEditable(false);
        setLineWrap(true);
        
        PrintConsole stream = new PrintConsole(this);
        //System.setOut(new PrintStream(stream, true));    // true は AutoFlush の設定
        System.setErr(new PrintStream(stream, true));    // true は AutoFlush の設定
    }
    
    public void writeString(String str) {
        this.append(str+"\n");
    }

    class PrintConsole extends OutputStream {

        private JTextArea textArea;
        private ByteArrayOutputStream out;

        public PrintConsole(JTextArea area) {
            textArea = area;
            out = new ByteArrayOutputStream();
        }

        @Override
        public void write(int buf) throws IOException {
            out.write(buf);
        }

        @Override
        public void flush() throws IOException {

            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    textArea.append(out.toString());
                    out.reset();
                }
            });
        }
    }
}
