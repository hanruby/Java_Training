package ch20.ex20_04;

import java.io.FilterReader;
import java.io.Reader;

public class LineFilterReader extends FilterReader{

    protected LineFilterReader(Reader reader) {
        super(reader);
    }
}
