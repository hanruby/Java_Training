package ch20.ex20_08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RandomAccess {

    private static final String SEPATATE_STRING = "^%%";
    
    private List<Long> index;

    private RandomAccessFile fp;
    private Pattern pattern;
    
    private Random rand;
    
    public RandomAccess(File file) throws FileNotFoundException {

        fp = new RandomAccessFile(file, "r");
        index = new ArrayList<Long>();
        pattern = Pattern.compile(SEPATATE_STRING);
        rand = new Random();
    }        
    
    public void findEntryIndex() throws IOException {
                
        String line;
        while (true) {
            long pos = fp.getFilePointer();
            
            // ファイルの最後
            if ((line = fp.readLine()) == null) {
                // ファイルの最後を保持する。
                index.add(fp.getFilePointer());
                break;
            }
            
            Matcher matcher = pattern.matcher(line);
            // パターンが一致したら保持する。
            if (matcher.matches()) {
                index.add(pos);
            }
        }
    }
    
    public void printIndex() {
        for (Long entry : index) {
            System.out.println(entry);
        }
    }
    
    public void randomPrint() {
        try {
            int randomIndex = rand.nextInt(index.size() - 1);
            long start = index.get(randomIndex);
            long end = index.get(randomIndex + 1);

            fp.seek(start);

            // １行読み飛ばす
            fp.readLine();
            start = fp.getFilePointer();	

            int size = (int) (end - start);
            byte[] buffer = new byte[size];
            
            fp.read(buffer);
            System.out.println(new String(buffer, "UTF-8"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
