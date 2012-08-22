package ch17.ex17_03;

/**
 * P.403<br>
 * Resourceの実装クラス<br>
 * Resourceオブジェクトが、キーへの強い参照を保持していないことが重要。<br>
 *  
 */
public class ResourceImpl implements Resource {

    int keyHash;
    boolean needsRelease = false;
    
    ResourceImpl(Object key) {
        keyHash = System.identityHashCode(key);
        
        // .. 外部リソースの設定

        needsRelease = true;
    }
    
    @Override
    public void use(Object key, Object... args) {
        if (System.identityHashCode(key) != keyHash)
            throw new IllegalArgumentException("wrong key");

        // ... リソースの使用 ...        
    }

    @Override
    public synchronized void release() {
        if (needsRelease) {
            needsRelease = false;

            // .. リソースの解放 ...
        }        
    }

}
