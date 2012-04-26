package ch05.ex05_01;


/*
 * 結論：
 * どちらもネストすべきではない
 */

class Attr {
    public static interface Attributed {
        void add(Attr newAttr);
        Attr find(String attrName);
        Attr remove(String attrName);
        java.util.Iterator<Attr> attrs();
    }
}
/*
 * Attributedインタフェースで実装する場合、Attrにネストしているのは不自然だとおもう。
 */



interface Attributed {
    void add(Attr newAttr);
    Attr find(String attrName);
    Attr remove(String attrName);
    java.util.Iterator<Attr> attrs();

    public class Attr {}
}
	
/*
 * Attrを拡張する場合も想定され、ネストした型とするべきではないとおもう。
 */
