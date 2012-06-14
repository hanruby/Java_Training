package ch13.ex13_03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringUtilityTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testDelimitedString() {
        // 開始文字が見つからない
        assertEquals(null, StringUtility.delimitedString("Il a dit Bonjour!»", '«', '»'));
        // 終了文字が見つからない
        assertEquals("«Bonjour!!!!!", StringUtility.delimitedString("Il a dit «Bonjour!!!!!", '«', '»'));
        // 開始文字が終了文字の後にある
        assertEquals(null, StringUtility.delimitedString("Il a dit »Bonjour!«", '«', '»'));
        // 開始文字と終了文字が見つかった
        assertEquals("«Bonjour!»", StringUtility.delimitedString("Il a dit «Bonjour!»", '«', '»'));
    }

    @Test
    public void testDelimitedStrings() {
        String[] result;
        
        // 開始文字が見つからない
        result = StringUtility.delimitedStrings("Il a dit Bonjour!»", '«', '»');
        assertEquals(null, result[0]);

        result = StringUtility.delimitedStrings("Il a dit «Bonjour!» hoge!»", '«', '»');
        assertEquals("«Bonjour!»", result[0]);
        assertEquals(null, result[1]);

        // 終了文字が見つからない
        result = StringUtility.delimitedStrings("Il a dit «Bonjour!!!!!", '«', '»');
        assertEquals(null, result[0]);

        result = StringUtility.delimitedStrings("Il a dit «Bonjour!» «hoge!", '«', '»');
        assertEquals("«Bonjour!»", result[0]);
        assertEquals(null, result[1]);

        // 開始文字が終了文字の後にある
        result = StringUtility.delimitedStrings("Il a dit »Bonjour!«", '«', '»');
        assertEquals(null, result[0]);

        // 開始文字と終了文字が見つかった
        result = StringUtility.delimitedStrings("Il a dit «Bonjour!» «hoge!»", '«', '»');
        assertEquals("«Bonjour!»", result[0]);
        assertEquals("«hoge!»", result[1]);
    }

}
