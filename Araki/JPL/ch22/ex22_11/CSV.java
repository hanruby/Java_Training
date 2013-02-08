package ch22.ex22_11;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class CSV {
    static final int CELLS = 4;

    public static List<String[]> readCSVTable(Reader source)
            throws IOException {
		StreamTokenizer in = new StreamTokenizer(source);
        List<String[]> vals = new ArrayList<String[]>();

        in.whitespaceChars(',', ','); // ,を区切りにする
		in.eolIsSignificant(true);

		String[] cells = new String[CELLS];
		int i = 0;
		
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
		    switch (in.ttype) {
		    case StreamTokenizer.TT_WORD:
		        if (i >= CELLS)
		            throw new IOException("input format error, val:" + in.sval);

		        cells[i] = in.sval.trim();
		        i++;
		        break;

		    case StreamTokenizer.TT_NUMBER:
		        if (i >= CELLS)
		            throw new IOException("input format error, val:" + in.nval);

		        cells[i] = Double.toString(in.nval);
		        i++;
		        break;

		    case StreamTokenizer.TT_EOL:
		        if ( i != CELLS && i != 0 )
		            throw new IOException("input format error, cell:" + i);
		        vals.add(cells.clone());
                i=0;
                break;
            default:
                break;
            }
        }
        
        return vals;
    }
}
