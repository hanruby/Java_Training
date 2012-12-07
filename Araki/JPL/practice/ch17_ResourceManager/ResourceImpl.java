package practice.ch17_ResourceManager;

import java.lang.ref.WeakReference;

/**
 * P.403<br>
 * Resourceの実装クラス<br>
 * Resourceオブジェクトが、キーへの強い参照を保持していないことが重要。<br>
 *  
 */
public class ResourceImpl implements Resource {

    WeakReference<Object> keyObject; // キーオブジェクトを保持する
    boolean needsRelease = false;
    
    ResourceImpl(Object key) {
        keyObject = new WeakReference<Object>(key);
        
        // .. 外部リソースの設定

        needsRelease = true;
    }
    
    @Override
    public void use(Object key, Object... args) {
        // keyObjectが既に解放されている
        if ( keyObject.get() == null )
            throw new IllegalStateException("already released");
        
        // keyが違う
        if ( !keyObject.get().equals(key) )
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
