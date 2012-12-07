package ch20.ex20_11;

import java.io.File;
import java.io.FilenameFilter;

public class Find implements FilenameFilter{

    @Override
    public boolean accept(File dir, String name) {
        // suffix で終われば true
        return name.endsWith(suffix);
    }

    private File dir;
    private String suffix;
    
    public Find(File dir, String suffix) {
        this.dir = dir;
        this.suffix = suffix;
    }
    
    public String[] getList() {
        return dir.list(this);
    }
}
