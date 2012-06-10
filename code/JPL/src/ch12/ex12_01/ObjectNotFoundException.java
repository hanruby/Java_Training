package ch12.ex12_01;

public class ObjectNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;
    
    public final String name;
    
    public ObjectNotFoundException(String name) {
        super(name + ": Not found");
        this.name = name;
    }
    
}
