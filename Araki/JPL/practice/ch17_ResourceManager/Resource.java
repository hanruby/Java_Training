package practice.ch17_ResourceManager;

public interface Resource {
    
    void use(Object key, Object... args);
    void release();
}
