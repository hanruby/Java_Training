package ch16.ex16_04;


import static org.junit.Assert.*;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.junit.Before;
import org.junit.Test;

public class AnnotationInfoTest {

    @Before
    public void setUp() throws Exception {
    }
    
    
    @Test
    public void testAnnotation() throws Exception {
        //Class<?> cls = Class.forName("ch16.ex16_04.Foo");
        Class<Foo> cls = Foo.class;
        BugsFixed bugsFixed = (BugsFixed) cls.getAnnotation(BugsFixed.class);
        String[] bugsIDs = bugsFixed.value();
        for (String id : bugsIDs) {
            System.out.println(id);
        }
    }
    
    @Test
    public void testMain() throws Exception {
        AnnotationInfo.main(new String[]{"ch16.ex16_04.Foo"});
    }
}

@BugsFixed({"45678", "43246"})
class Foo {}


/**
 * P.342
 */
@Retention(RetentionPolicy.RUNTIME)
@interface BugsFixed {
    String[] value();
}


