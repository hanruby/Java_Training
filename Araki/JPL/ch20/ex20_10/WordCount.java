package ch20.ex20_10;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map.Entry;

public class WordCount {
    private HashMap<String, Integer> countTable;
    private File file;

    public WordCount(File file) {
        this.countTable = new HashMap<String, Integer>();
        this.file = file;
    }

    public void analyze() throws IOException {

        Reader reader = new FileReader(file);
        StreamTokenizer tokenizer = new StreamTokenizer(reader);

        int tokenKind;

        while ((tokenKind = tokenizer.nextToken()) != StreamTokenizer.TT_EOF) {

            switch (tokenKind) {
            case StreamTokenizer.TT_WORD:

                String value = tokenizer.sval;
                wordIncrement(value);
                break;

            case StreamTokenizer.TT_NUMBER:

                String num = String.valueOf(tokenizer.nval);
                wordIncrement(num);
                break;

            default:
                break;
            }
        }
    }

    /**
     * HashMapにあるキーの数をインクリメントする
     * @param key
     */
    private void wordIncrement(String key) {

        if (countTable.containsKey(key)) {
            Integer count = countTable.get(key) + 1;
            countTable.put(key, count);
        } else {
            countTable.put(key, 1);
        }
    }
    
    public void printResults() {
        for (Entry<String, Integer> element : countTable.entrySet()) {
            System.out.printf("%s:%d%n",element.getKey(), element.getValue());
        }
    }
    
    public Integer getCount(String word) {
        if (countTable.containsKey(word)) {
            return countTable.get(word);
        }
        else {
            return 0;
        }
    }
}
