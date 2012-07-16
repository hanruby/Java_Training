package practice.ch16_02_Annotation_Queries;

public class AnnotationQueries {

    @BugsFixed({"45678", "43246"})
    class Foo {}

    /**
     * P.342
     */
    @interface BugsFixed {
        String[] value();
    }

    /**
     * P.363
     */
    public static void main(String[] args) {

        Class<Foo> cls = Foo.class;
        BugsFixed bugsFixed = (BugsFixed) cls.getAnnotation(BugsFixed.class);
        String[] bugIDs = bugsFixed.value(); // This value of bugsIDs is null. Why?
        for (String id : bugIDs) {
            System.out.println(id);
        }
    }
}
