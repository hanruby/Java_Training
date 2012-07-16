package practice.ch16_02_Annotation_Queries;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AnnotationQueries {

    @BugsFixed({"45678", "43246"})
    class Foo {}

    /**
     * P.342
     */
    @Retention(RetentionPolicy.RUNTIME)
    @interface BugsFixed {
        String[] value();
    }

    /**
     * P.363
     */
    public static void main(String[] args) {

        Class<Foo> cls = Foo.class;
        BugsFixed bugsFixed = (BugsFixed) cls.getAnnotation(BugsFixed.class);
        String[] bugIDs = bugsFixed.value();
        for (String id : bugIDs) {
            System.out.println(id);
        }
    }
}
