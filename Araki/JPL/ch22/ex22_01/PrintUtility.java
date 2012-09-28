package ch22.ex22_01;

import java.util.Formatter;

public class PrintUtility {

    private static final int CHARACTER_NUMS = 80;

    
    /**
     * 配列の内容を整形する
     * @param array 浮動小数点の配列
     * @param columnNums 使用する列数
     * @return 整形後の文字列
     * @throws IllegalArgumentException 0以下の場合
     */
    public static String FormatDoubleArray(Double[] array, int columnNums) {
        
        if(columnNums <= 0) {
            throw new IllegalArgumentException("The columnNums argument should not be negative number.");
        }
        
        if(array == null) {
            throw new NullPointerException("The array is Null.");
        }

        int showlength = (CHARACTER_NUMS - (8 * columnNums) + (columnNums - 1)) / columnNums;
        
        if (showlength < 1) {
            return "No output.";
        }

        StringBuilder builder = new StringBuilder();
        Formatter formatter = new Formatter(builder);
        //.search("C")
        for (int i = 0; i < array.length; i++) {

            String format = "%+." + showlength + "e";
            
            formatter.format(format, array[i]);

            if ((i+1) % columnNums == 0) {
                builder.append('\n');
            } 
            else {
                builder.append(' ');
            }
        }
        
        return builder.toString();
    }

}
