package ch20.ex20_06;


import static org.junit.Assert.*;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class OperatorTokenizerTest {

    @Before
    public void setUp() throws Exception {
    }

    
    @Test
    public void test_ExpressionState() throws Exception {
        OperatorTokenizer.ExpressionState state = OperatorTokenizer.ExpressionState.NAME;
        state = state.next();
        assertEquals(OperatorTokenizer.ExpressionState.OPERATION, state);
        
        state = state.next();
        assertEquals(OperatorTokenizer.ExpressionState.VALUE, state);
        
        state = state.next();
        assertEquals(OperatorTokenizer.ExpressionState.NAME, state);
    }
    
    @Test
    public void test_Tokenizer() throws Exception {
        String filename = "JPL/ch20/ex20_06/calclist.txt";

        FileReader fileIn = null;

        try {
            fileIn = new FileReader(filename);
            
            OperatorTokenizer ot = new OperatorTokenizer();
            ot.readOperation(fileIn);
            ot.printOperations();
            
            assertEquals(130.0, ot.operations.get("x"), 0);
            assertEquals(130.0, ot.operations.get("y"), 0);
            assertEquals(-100.0, ot.operations.get("z"), 0);
            assertEquals(20.0, ot.operations.get("i"), 0);

        } finally {
            // Close FileReader and LineNumberReader
            if(fileIn != null){
                fileIn.close();
            }
        }
    }
}
