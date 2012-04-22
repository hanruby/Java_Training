package practice.ch02_Class;

/**
 * 参照渡し P.55
 * パラメータがオブジェクト参照の場合は、オブジェクトではなく、オブジェクト参照が値渡しされる。 
 * オブジェクトが参照渡しされるのではない。
 * @author ato
 *
 */
class PassRef {
    public static void main(String[] args) {
        Body sirius = new Body("Sirius", null);

        System.out.println("before: " + sirius);
        commonName(sirius);
        System.out.println("after:  " + sirius);
    }

    public static void commonName(Body bodyRef) {
//    public static void commonName(final Body bodyRef) { // final宣言すると、nullにするところでコンパイルエラーになる P.56
        //bodyRef.name = "Dog Star";
        bodyRef.setName("Dog Star");
        bodyRef = null;
    }
}
