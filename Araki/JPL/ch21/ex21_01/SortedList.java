package ch21.ex21_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import ch20.ex20_04.LineFilterReader;

public class SortedList extends LinkedList<String> {

    private static final long serialVersionUID = -941997573798628644L;

    /**
     * @param file 
     * @throws IOException
     *         If an I/O error occurs
     */
    public void readFile(File file) throws IOException {
        FileReader fin = null;
        LineFilterReader lineReader;

        fin = new FileReader(file);
        lineReader = new LineFilterReader(fin);

        String line;
        while((line = lineReader.readLine()) != null) {
            this.addLine(line);
        }
    }

    public void addLine(String line) {
        String prev = "";
        ListIterator<String> it = this.listIterator();

        while(it.hasNext()) {
            String curr = it.next();
            if(line.compareTo(prev) >= 0 && line.compareTo(curr) < 0) {
                it.previous();
                it.add(line);
                return;
            }
            curr = prev;
        }
        this.addLast(line);
    }
}

