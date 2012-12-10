package item29;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FavoritesTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test_fav() throws Exception {
        Favorites f = new Favorites();
        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorites.class);
        
        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);
        
        // check
        assertEquals("Java", favoriteString);
        assertSame("Java", favoriteString);
        
        assertEquals(0xcafebabe, favoriteInteger);
        assertSame(0xcafebabe, favoriteInteger);
        
        assertEquals(Favorites.class, favoriteClass);
        assertSame(Favorites.class, favoriteClass);
    }
}
