package ch06.ex06_03;

public interface Verbose {
    public enum MessageLevel {
        SILENT, 
        TERSE,
        NORMAL, 
        VERBOSE;
    }
    
    void setVorbosity(MessageLevel level);
    MessageLevel getVerbosity();
}

