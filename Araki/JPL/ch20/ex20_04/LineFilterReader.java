package ch20.ex20_04;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class LineFilterReader extends FilterReader{

    public LineFilterReader(Reader in) {
        super(in);
    }

    private boolean carriageReturn = false;
    
    /**
     * Read a line of text.  
     * 
     * @author  atotto
     * 
     * @return  A String containing the contents of the line, not including
     *          any <a href="#lt">line termination characters</a>, or 
     *          <tt>null</tt> if the end of the stream has been reached
     * 
     * @throws  IOException
     *          If an I/O error occurs
     */
    public String readLine() throws IOException {
        
        StringBuilder builder = new StringBuilder();
        int b;

        while ((b = super.read()) != -1) {
            
            switch ((byte) b) {

            case '\n':
                if (carriageReturn == true) {
                    carriageReturn = false;
                    break;
                }
                carriageReturn = false;
                return builder.toString();

            case '\r':
                carriageReturn = true;
                return builder.toString();

            default:
                carriageReturn = false;
                builder.append((char) b);
                break;
            }
        }

        return null;
    }
}
