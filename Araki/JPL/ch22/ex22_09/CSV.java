package ch22.ex22_09;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

abstract public class CSV {

    abstract public String createPattern(int cells_num);
        
    public List<String[]> readCSVTable(Readable source, int cells_num)
            throws IOException {
        Scanner in = new Scanner(source);
        List<String[]> vals = new ArrayList<String[]>();
    
        String exp = createPattern(cells_num);
        
        Pattern pat = Pattern.compile(exp, Pattern.MULTILINE);
        while (in.hasNextLine()) {
            String line = in.findInLine(pat);
            if (line != null) {
                
                String[] cells = new String[cells_num];
                MatchResult match = in.match();
                
                // セルの数の指定よりもデータセットが多い場合はエラー
                if (match.group(cells_num + 1) != null) {
                    throw new IOException("input format error : " + line);
                }

                for (int i = 0; i < cells_num; i++)
                    cells[i] = match.group(i + 1);
                vals.add(cells);
                in.nextLine(); // 改行を読み飛ばす
            }

            else {
                in.nextLine(); // 改行を読み飛ばす
            }
        }

        IOException ex = in.ioException();
        if (ex != null)
            throw ex;

        return vals;
    }
}
