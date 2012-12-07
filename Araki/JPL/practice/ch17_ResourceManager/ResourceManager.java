package practice.ch17_ResourceManager;

import java.lang.ref.*;
import java.util.HashMap;
import java.util.Map;

public final class ResourceManager {

    final ReferenceQueue<Object> queue;

    // ・すべてのファントム参照オブジェクトを到達可能に維持する
    // ・個々のファントム参照に関連付けられた実際のリソースオブジェクトを到達可能に維持する
    final Map<Reference<?>, Resource> refs; 
    
    final Thread reaper;
    boolean shutdown = false;

    public ResourceManager() {
        queue = new ReferenceQueue<Object>();
        refs = new HashMap<Reference<?>, Resource>();
        reaper = new ReaperThread();
        reaper.start();

        // ... リソースの初期化 ...
    }

    /**
     * 割り込みに応答してReaperスレッドが終了することを可能にすることで、
     * ResourceManagerを止め、getResource呼び出しが行われるとIllegalStateException
     * がスローされるようにする
     */
    public synchronized void shutdown() {
        if (!shutdown) {
            shutdown = true;
            reaper.interrupt();
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

    /**
     * Reaper(刈り取り)スレッド P.405 <br>
     * キーが到達不可能になった時点でリソースを処理するために使用するスレッド
     * 
     * 関連付けされているResourceManagerがshutdownするまで実行する
     */
    class ReaperThread extends Thread {
        public void run() {
            // 割り込まれるまで実行
            while (true) {
                try {
                    Reference<?> ref =  queue.remove(); // ReferenceQueueのremoveは空っぽの場合は停止してる。 interrupt対象。
                    Resource res = null;
                    synchronized(ResourceManager.this) { 
                        // sync していないと 他のThreadでrefsを書き換えてしまう可能性がある。
                        // たとえば、getで取得したのに別の操作が発生し、NullPointerが発生する可能性がある。
                        res = refs.get(ref);
                        refs.remove(ref);
                    }
                    // refsに格納されていたResourceをリリース
                    res.release();
                    // ReferenceQueueに入っていたReferenceをクリア
                    ref.clear();
                }
                catch (InterruptedException ex) {
                    break; // すべて終了
                }
            }
        }
    }
}

