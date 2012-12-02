package ch17.ex17_05;

import org.junit.Test;

public class ResourceManagerTest {

    @Test
    public void test_finish() throws Exception {
        int SIZE = 10000;
        ResourceManager manager;
        
        manager = new ResourceManager();
        Resource[] resources = new Resource[SIZE];
        
        {
            for (int i = 0; i < SIZE; i++) {
                String key = String.valueOf("key : " + i);

                // ResourceManagerからリソースを取得
                resources[i] = manager.getResource(key);
                // リソースを利用
                resources[i].use(key, new Integer(i));
            }
        }
        System.out.println("Stored objects");

        for (int i = 0; i < SIZE; i++) {
            String key = String.valueOf("key : " + i);
            // リソースを利用
            resources[i].use(key, new Integer(i));
        }
        
        System.out.println("Shutdown ResourceManager");
        manager.shutdown();
    }

    @Test
    public void test_gc() throws Exception {
        int SIZE = 10000;
        ResourceManager manager;
        
        manager = new ResourceManager();
        Resource[] resources = new Resource[SIZE];
        String[] keys = new String[SIZE]; 
        
        for (int i = 0; i < SIZE; i++) {
            // keyを保持
            keys[i] = String.valueOf("key : " + i);

            // ResourceManagerからリソースを取得
            resources[i] = manager.getResource(keys[i]);
            // リソースを利用
            resources[i].use(keys[i], new Integer(i));
        }
        System.out.println("Stored objects");

        // gcしてみる
        System.gc();
        
        for (int i = 0; i < SIZE; i++) {
            // リソースを利用できるはず
            resources[i].use(keys[i], new Integer(i));
        }
        for (int i = 0; i < SIZE; i++) {
            // keyを無効化
            keys[i] = null;
        }
        
        System.out.println("Shutdown ResourceManager");
        manager.shutdown();
    }

    @Test
    public void test_() throws Exception {
        
        int SIZE = 10000;
        ResourceManager manager;
        
        manager = new ResourceManager();
        Resource[] resources = new Resource[SIZE];

        System.out.println("gc!");
        Runtime.getRuntime().gc();
        
        System.out.println("Initialize");
        showFreeMemory();
        
        {
            for (int i = 0; i < SIZE; i++) {
                String key = String.valueOf("key : " + i);

                resources[i] = manager.getResource(key);
                resources[i].use(key, new Integer(i));
            }
        }

        System.out.println("Stored objects");
        showFreeMemory();
        
        System.out.println("Shutdown ResourceManager");
        manager.shutdown();
        
        showFreeMemory();
    }

    
    private static void showFreeMemory() {
        System.out.printf("Free memory : %d Byte %n", Runtime.getRuntime().freeMemory());
    }

}
