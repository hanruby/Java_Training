package ch22.ex22_10;


import static org.junit.Assert.*;

import java.io.StringReader;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CommentTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testReadTokens() throws Exception {
        StringReader in = new StringReader(
                "hello world!!\n" +
                "#this is comment.\n" +
                "#こんにちは世界!\n" +
                "hello!!\n"
        );
        
        String[] expected = {"hello", "world!!", "hello!!"};

        List<String> results = Comment.readTokens(in);

        assertEquals(expected.length, results.size());
        
        for (int i = 0; i < results.size(); i++) {
            assertEquals(expected[i], results.get(i));
        }
    }
}
