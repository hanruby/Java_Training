package ch22.ex22_07;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class CSV {
    static final int CELLS = 4;

    public static List<String[]> readCSVTable(Readable source)
            throws IOException {
        return readCSVTable(source, CELLS);
    }

    public static List<String[]> readCSVTable(Readable source, int cells_num)
            throws IOException {
        Scanner in = new Scanner(source);
        List<String[]> vals = new ArrayList<String[]>();
        String exp = "^(.*),(.*),(.*),(.*)";
        Pattern pat = Pattern.compile(exp, Pattern.MULTILINE);
        while (in.hasNextLine()) {
            String line = in.findInLine(pat);
            if (line != null) {
                String[] cells = new String[cells_num];
                MatchResult match = in.match();
                for (int i = 0; i < cells_num; i++)
                    cells[i] = match.group(i + 1);
                vals.add(cells);
                in.nextLine(); // skip newline
            }

            else {
                throw new IOException("input format error");
            }
        }

        IOException ex = in.ioException();
        if (ex != null)
            throw ex;

        return vals;
    }
}
