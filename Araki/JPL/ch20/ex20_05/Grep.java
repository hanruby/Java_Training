package ch20.ex20_05;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Grep {

    /**
     * Example : java ch20.ex20_05.Grep ch20/ex20_05/testfile.txt hoge
     * @param args
     */
    public static void main(String[] args) {

        if (args.length != 2)
            System.err.println("need char and file");
        try {
            findString(args[0], args[1]);
        } catch (FileNotFoundException e) {
            System.err.println("No such file : " );
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void findString(String filename, String serachString) throws FileNotFoundException, IOException {

        LineNumberReader in = null;
        FileReader fileIn = null;

        try {
            fileIn = new FileReader(filename);
            in = new LineNumberReader(fileIn);

            String line;
                        
            while ((line = in.readLine()) != null) {
                if (line.contains(serachString)) { // The "contains" method is described in P.267
                    // Get line number of found line
                    int line_number = in.getLineNumber() ;
                    
                    // Print line number and line
                    printLine(line_number, line);
                }
            }
        } finally {
            // Close FileReader and LineNumberReader
            if(fileIn != null){
                fileIn.close();
            }
            if(in != null){
                in.close();
            }
        }
    }
    
    private static void printLine(int line_number, String line) {
        System.out.printf("%d:%s%n", line_number, line);
    }
}
