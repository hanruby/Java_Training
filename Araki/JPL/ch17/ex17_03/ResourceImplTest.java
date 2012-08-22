package ch17.ex17_03;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

public class ResourceImplTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testResourceImpl() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        String key = "This is key";
        Resource resource = new ResourceImpl(key);

        Field field = resource.getClass().getDeclaredField("needsRelease");
        field.setAccessible(true);
        boolean value = (Boolean) field.get(resource);
        
        assertEquals(true, value);
    }

    @Test
    public void testUse_correct_key() {
        String key = "This is key";
        Resource resource = new ResourceImpl(key);

        // use correct key
        resource.use(key, "any objects");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testUse_wrong_key() {
        String key = "This is key";
        Resource resource = new ResourceImpl(key);

        String wrong_key = "This is wrong key";
        resource.use(wrong_key, "any objects");
    }

    @Test
    public void testRelease() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        String key = "This is key";
        Resource resource = new ResourceImpl(key);
        
        resource.release();
        
        Field field = resource.getClass().getDeclaredField("needsRelease");
        field.setAccessible(true);
        boolean value = (Boolean) field.get(resource);
        
        assertEquals(false, value);
    }
}
