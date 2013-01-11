package ch22.ex22_09;

public class CSV_pattern3 extends CSV{
    
    @Override
    public String createPattern(int cells_num) {
     
        // パターン生成
        StringBuilder exp = new StringBuilder("^([^,]*)");
        for (int cell = 1; cell < cells_num; cell++) {
            exp.append(",([^,]*)");
        }
        exp.append(",([^,]*)");
        
        return exp.toString();
    }
}
