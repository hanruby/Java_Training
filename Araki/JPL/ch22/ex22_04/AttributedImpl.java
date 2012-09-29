package ch22.ex22_04;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;

public class AttributedImpl extends Observable implements Attributed {

    LinkedList<Attr> list = new LinkedList<Attr>();

    @Override
    public void add(Attr newAttr) {
        Attr attr = this.find(newAttr.getName());

        // NotFound
        if (attr == null) {
            list.remove(attr);
        }
        list.add(newAttr);

        // Notify observers
        setChanged();
        notifyObservers("Add attr object : " + newAttr.getName());
    }

    @Override
    public Attr find(String attrName) {
        for (Attr attr : list) {
            if (attr.getName().equals(attrName)) {
                return attr;
            }
        }
        return null;
    }

    @Override
    public Attr remove(String attrName) {
        Attr attr = find(attrName);

        if (attr == null) {
            return null;
        }
        list.remove(attr);

        // Notify observers
        setChanged();
        notifyObservers("Remove attr object : " + attr.getName());

        return attr;
    }

    @Override
    public Iterator<Attr> attrs() {
        return list.iterator();
    }

}
