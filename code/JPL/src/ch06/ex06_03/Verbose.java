package ch06.ex06_03;

interface Verbose {
    int SILENT = 0;
    int TERSE = 1;
    int NORMAL = 2;
    int VERBOSE = 3;
    
    void setVorbosity(int level);
    int getVerbosity();
}
