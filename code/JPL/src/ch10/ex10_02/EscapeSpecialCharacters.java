package ch10.ex10_02;

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
        
        for (int i = 0; i < str.length(); i++) {
            escapedStr += escapeChar(str.charAt(i));
        }
        
        return escapedStr;
    }
    
    /**
     * 特殊文字を文字列に置き換えて返す
     * @param c
     * @return
     */
    protected static String escapeChar(char c) {
        if (c == '\n') {
            return "\\n";
        }
        else if (c == '\t') {
            return "\\t";
        } 
        else if (c == '\b') {
            return "\\b";
        } 
        else if (c == '\r') {
            return "\\r";
        } 
        else if (c == '\f') {
            return "\\f";
        } 
        else if (c == '\\') {
            return "\\\\";
        } 
        else if (c == '\'') {
            return "\\'";
        } 
        else if (c == '\"') {
            return "\\\"";
        } 
        else {
            return String.valueOf(c);
        }
        
    }
}
