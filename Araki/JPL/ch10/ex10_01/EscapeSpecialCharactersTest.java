package ch10.ex10_01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EscapeSpecialCharactersTest {

    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testEscapeChar() throws Exception {
        assertEquals("\\n", EscapeSpecialCharacters.escapeChar('\n'));
        assertEquals("\\t", EscapeSpecialCharacters.escapeChar('\t'));
        assertEquals("\\b", EscapeSpecialCharacters.escapeChar('\b'));
        assertEquals("\\r", EscapeSpecialCharacters.escapeChar('\r'));
        assertEquals("\\f", EscapeSpecialCharacters.escapeChar('\f'));
        assertEquals("\\\\", EscapeSpecialCharacters.escapeChar('\\'));
        assertEquals("\\\'", EscapeSpecialCharacters.escapeChar('\''));
        assertEquals("\\\"", EscapeSpecialCharacters.escapeChar('\"'));
        assertEquals("a", EscapeSpecialCharacters.escapeChar('a'));
        assertEquals("1", EscapeSpecialCharacters.escapeChar('1'));
        assertEquals("あ", EscapeSpecialCharacters.escapeChar('あ'));
    }

    @Test
    public void testEscape() {
        assertEquals("abc123\\n", EscapeSpecialCharacters.escape("abc123\n"));
    }

}
