package ch16.Interpret;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Interpret for Java 
 * @author ato
 */
public class Interpret {
    public static void main(String[] args) {
        Interpret interpreter = new Interpret();
        interpreter.createInterpreter();        
    }
    
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    
    void setReader(BufferedReader reader) {
        input = reader;
    }
    
    public void createInterpreter() {
        System.out.println("Welcome to java interpreter console.");
        
        String line = null;
        Object obj = null;
        
        for(;;) {
            System.out.printf("> ");
            try {
                line = input.readLine( );
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] args = line.split(" ");

            switch (args.length) {
            case 0:
                break;
                
            case 1:
                if (args[0].equals("ls")) {
                    if (obj == null) {
                        System.out.println("none");
                        break;
                    }
                    ObjectUtility.printObjectFields(obj);
                }
                else if (args[0].equals("exit")) {
                    System.out.println("bye!");
                    return;
                }
                break;

            case 2:
                if (args[0].equals("new")) {
                    obj = ObjectUtility.createObject(args[1]);
                }    
                break;

            case 3:
                if (args[0].equals("set")) {
                    ObjectUtility.setField(obj, args[1].toString(), args[2]);
                }    
                break;

            default:
                System.out.println(line);
                break;
            }
        }
    }
}
