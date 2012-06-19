package ch10.ex10_05;

public class CharTools {

    /**
     * ２つのcharを引数にとり、それらの文字とそれらの文字間の文字を表示する
     * @param first
     * @param second
     * @return
     */
    public static String fill(char first, char second) {
        
        String filledStr = "";
        
        for (char c = (first < second ? first : second); c <= (first < second ? second: first); c++) {
            filledStr += String.valueOf(c);
        }
        
        System.out.println(filledStr);
        
        return filledStr;
    }
}
