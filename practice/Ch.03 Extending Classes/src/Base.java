
class Base {
    /** return the class name */
    protected String name() {
        return "Base";
    }
}

class More extends Base {
    protected String name() {
        return "More";
    }

    protected void printName() {
        Base sref = (Base) this;

        System.out.println("this.name()  = " + this.name());
        System.out.println("sref.name()  = " + sref.name());
        System.out.println("super.name() = " + super.name());
    }
    
    public static void main(String[] args) {
		More m = new More();
		m.printName();
		
		Base b = new More(); // 広くする変換(widening conversion)
		b.name();
		
		More mb = (More)new Base(); // 狭くする変換(narrowing conversion) ※ castが必要
		mb.name();
	}
}
