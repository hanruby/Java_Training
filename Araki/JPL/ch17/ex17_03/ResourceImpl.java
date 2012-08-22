package ch17.ex17_03;

import java.lang.ref.SoftReference;

/**
 * P.403<br>
 * Resourceの実装クラス<br>
 * Resourceオブジェクトが、キーへの強い参照を保持していないことが重要。<br>
 *  
 */
public class ResourceImpl implements Resource {

    SoftReference<Object> keyObject; // ソフト参照でキーオブジェクトを保持する
    boolean needsRelease = false;
    
    ResourceImpl(Object key) {
        keyObject = new SoftReference<Object>(key);
        
        // .. 外部リソースの設定

        needsRelease = true;
    }
    
    @Override
    public void use(Object key, Object... args) {
        if ( keyObject != null && !keyObject.get().equals(key) )
            throw new IllegalArgumentException("wrong key");
        
        // ... リソースの使用 ...        
    }

    @Override
    public synchronized void release() {
        if (needsRelease) {
            needsRelease = false;

            // .. リソースの解放 ...
            keyObject.clear();
        }        
    }

}
