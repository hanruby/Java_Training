package ch22.ex22_12;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.*;

class AttributedImpl implements Attributed, Iterable<Attr> {
    protected Map<String, Attr> attrTable =
        new HashMap<String, Attr>();

    public void add(Attr newAttr) {
        attrTable.put(newAttr.getName(), newAttr);
    }

    public Attr find(String name) {
        return attrTable.get(name);
    }

    public Attr remove(String name) {
        return attrTable.remove(name);
    }

    public Iterator<Attr> attrs() {
        return attrTable.values().iterator();
    }

    public Iterator<Attr> iterator() {
        return attrs();
    }

    /**
     * ファイルを読み込んで name=value形式の属性を探して、それらの属性をAttributedImplオブジェクトの属性として保存する
     * JPL P.467
     */
    public static Attributed readAttrs(Reader source)
    throws IOException
    {
        StreamTokenizer in = new StreamTokenizer(source);
        AttributedImpl attrs = new AttributedImpl();
        Attr attr = null;
        in.commentChar('#');    // '#' is ignore-to-end comment
        in.ordinaryChar('/');   // was original comment char
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            if (in.ttype == StreamTokenizer.TT_WORD) {
                if (attr != null) {
                    attr.setValue(in.sval);
                    attr = null;        // used this one up
                } else {
                    attr = new Attr(in.sval);
                    attrs.add(attr);
                }
            } else if (in.ttype == '=') {
                if (attr == null)
                    throw new IOException("misplaced '='");
            } else {
                if (attr == null)       // expected a word
                    throw new IOException("bad Attr name");
                attr.setValue(new Double(in.nval));
                attr = null;
            }
        }
        return attrs;
    }
}
