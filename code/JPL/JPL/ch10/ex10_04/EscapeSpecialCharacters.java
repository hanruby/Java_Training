package ch10.ex10_04;

/* P.201 */


/* special characters 
\n
\t
\b
\r
\f
\\
\'
\"
\ddd
*/

public class EscapeSpecialCharacters {
    
    /**
     * 文字列のすべての特殊文字を対応する文字列に置き換えて返す
     * @param str
     * @return
     */
    public static String escape(String str) {
        String escapedStr = "";
        
        /* do-whileでは書きなおすことができない。
         * 理由：
         * ループ本体が一度も実行されないケースも存在するため、do-whileは不適切。
         */
        int i = 0;
        while(i < str.length()) {
            escapedStr += escapeChar(str.charAt(i));
            i++;
        }
        
        return escapedStr;
    }
    
    /**
     * 特殊文字を文字列に置き換えて返す
     * @param c
     * @return
     */
    protected static String escapeChar(char c) {
        switch (c) {
        case '\n':
            return "\\n";
        case '\t':
            return "\\t";
        case '\b':
            return "\\b";
        case '\r':
            return "\\r";
        case '\f':
            return "\\f";
        case '\\':
            return "\\\\";
        case '\'':
            return "\\'";
        case '\"':
            return "\\\"";
        default:
            return String.valueOf(c);
        }
    }
}
