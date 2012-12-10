package item29;

import java.util.HashMap;
import java.util.Map;

/** 型安全な異種コンテナーパターン - 実装
 * P.139 
 */
public class Favorites {
    /*
     * ワイルドカードがネストしているため、ワイルドカード型なのはMapのキーではなく、そのキーの型になる。
     * これで、個々のキーが異なるパラメータ化された型を持つことができる。（異種性）
     */
    private Map<Class<?>, Object> favorites = new HashMap<Class<?>, Object>();

    public <T> void putFavorite(Class<T> type, T instance) {
        if (type == null)
            throw new NullPointerException("Type is null");
        favorites.put(type, instance);
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }
}


