package ch17.ex17_05;

import java.lang.ref.*;
import java.util.HashMap;
import java.util.Map;

public final class ResourceManager {

    final ReferenceQueue<Object> queue;

    // ・すべてのファントム参照オブジェクトを到達可能に維持する
    // ・個々のファントム参照に関連付けられた実際のリソースオブジェクトを到達可能に維持する
    final Map<Reference<?>, Resource> refs; 
    
    boolean shutdown = false;

    public ResourceManager() {
        queue = new ReferenceQueue<Object>();
        refs = new HashMap<Reference<?>, Resource>();

        // ... リソースの初期化 ...
    }

    /**
     * シャットダウン時にResourceを解放する
     */
    public synchronized void shutdown() {
        if (!shutdown) {
            shutdown = true;
            
            while (true) {
                Reference<?> ref =  queue.poll();
                if ( refs.size() == 0 ) {
                    System.out.println("All resources was released.");
                    break;
                }
                Resource res = null;
                synchronized(ResourceManager.this) {
                    res = refs.get(ref);
                    refs.remove(ref);
                }
                res.release();
                ref.clear();
            }
        }
    }

    /**
     * 
     * @param key : 任意のオブジェクト
     * @return
     */
    public synchronized Resource getResource(Object key) {
        if (shutdown)
            throw new IllegalStateException();

        // 提供されたキーを渡して、新たなResourceImplオブジェクトが生成される 
        Resource res = new ResourceImpl(key);
        // ファントム参照を生成
        Reference<?> ref =
            new PhantomReference<Object>(key, queue);
        // ファントム参照とResourceオブジェクトをMapに保存する
        refs.put(ref, res);
        return res;
    }
}

