package GUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Interpret for Java 
 * @author ato
 */
public class Interpret {
    public static void main(String[] args) {
        System.out.println("Welcome to java interpreter console.");

        Interpret interpreter = new Interpret();
        interpreter.createInterpreter();        

        System.out.println("bye!");

        return;
    }
    
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    
    void setReader(BufferedReader reader) {
        input = reader;
    }
    
    
    public void createInterpreter() {
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

            if (args.length == 0) {
                continue;
            }
            
            if (args[0].equals("exit")) {
                return;
            }
            else if (args[0].equals("show")) {
                if (obj == null || args.length != 2) {
                    usage();
                    continue;
                }
                if (args[1].equals("field")) {
                    FieldUtility.printObjectFields(obj);
                }
                else if (args[1].equals("method")) {
                    MethodUtility.printObjectMethods(obj);
                }
                else if (args[1].equals("constructor")) {
                    MethodUtility.printObjectMethods(obj);
                }
                else {
                    usage();
                    continue;
                }
            }
            else if (args[0].equals("new")) {
                if (args.length == 2) {
                    obj = ObjectUtility.createObject(args[1]);
                }
                else if (args.length == 4) {
                    obj = ObjectUtility.createObject(args[1], Integer.parseInt(args[2]), args[3]);
                }
                else{
                    usage();
                }
            }
            else if (args[0].equals("set")) {
                if (obj == null || args.length != 3) {
                    usage();
                    continue;
                }
                FieldUtility.setField(obj, args[1].toString(), args[2]);
            }
            else if (args[0].equals("exec")) {
                if (obj == null || args.length != 3) {
                    usage();
                    continue;
                }
                try {
                    Object ret = MethodUtility.execMethod(obj, Integer.parseInt(args[1]), args[2]);
                    System.out.println("result : " + ret);
                } catch (Exception e) {
                    System.out.println("format error");
                }
            }
            else {
                System.out.println(line);
            }
        }
    }
    
    static void usage() {
        System.out.printf(
                "Usage: [command] [option] %n" +
                "  command : show, new, set, exec, exit %n" +
                "%n" +
                "  show field   : Display of field list. %n" +
                "  show method  : Display of method list. %n" +
                "  exec [medhod number] [args(delimiter is \',\')]"
                );
    }
}
