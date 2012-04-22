
interface Lookup {
	Object find(String name);
}

interface LookupEx extends Lookup{
	void add(String name, Object value);
	void remove(String name);
}

class SimpleLookup implements LookupEx {
    private String[] names;
    private Object[] values;

    public Object find(String name) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(name))
                return values[i];
        }
        return null;    // not found
    }
    
    public void add(String name, Object value) {
    	// TODO: Implement
    	System.out.println(name + " " + value);
    }
    
    public void remove(String name) {
    	// TODO: Implement
    }

    public static void main(String[] args) {
    	SimpleLookup table = new SimpleLookup();
    	table.add("hoge",0);
    }

}

