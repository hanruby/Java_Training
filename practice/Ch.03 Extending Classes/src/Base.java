
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
}
