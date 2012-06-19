package practice.ch02_Class;

/**
 * 値渡し P.54
 * @author ato
 *
 */
class PassByValue {
    public static void main(String[] args) {
        double one = 1.0;

        System.out.println("before: one = " + one);
        halveIt(one);
        System.out.println("after:  one = " + one);
    }

    public static void halveIt(double arg) {
        arg /= 2.0;     // arg を 2 で割る
        System.out.println("halved: arg = " + arg);
    }
}
