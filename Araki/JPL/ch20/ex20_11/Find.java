package ch20.ex20_11;

import java.io.File;
import java.io.FilenameFilter;

public class Find implements FilenameFilter{

    @Override
    public boolean accept(File dir, String name) {
        // prefix で終われば true
        return name.endsWith(prefix);
    }

    private File dir;
    private String prefix;
    
    public Find(File dir, String prefix) {
        this.dir = dir;
        this.prefix = prefix;
    }
    
    public String[] getList() {
        return dir.list(this);
    }
}
