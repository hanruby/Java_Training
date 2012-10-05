package ch12.ex12_01;

public class ObjectNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;
    
    public final Object obj;
    
    public ObjectNotFoundException(Object obj) {
        super(obj.toString() + ": Not found");
        this.obj = obj;
    }
    
}
