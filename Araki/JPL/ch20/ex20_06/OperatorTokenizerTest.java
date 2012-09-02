package ch20.ex20_06;


import static org.junit.Assert.*;

import java.io.FileReader;

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
            
            new OperatorTokenizer().readOperation(fileIn);

        } finally {
            // Close FileReader and LineNumberReader
            if(fileIn != null){
                fileIn.close();
            }
        }
    }
}
