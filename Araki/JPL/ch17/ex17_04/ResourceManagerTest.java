package ch17.ex17_04;


public class ResourceManagerTest {

    public static void main(String[] args) {
        
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

        System.out.println("gc!");
        Runtime.getRuntime().gc();
        
        showFreeMemory();
        
        System.out.println("Release half objects");
        for (int i = 0; i < SIZE; i++) {
            resources[i].release();
        }
        showFreeMemory();

        System.out.println("gc!");
        Runtime.getRuntime().gc();
        
        showFreeMemory();
        
        System.out.println("Shutdown ResourceManager");
        manager.shutdown();
        
        showFreeMemory();

        System.out.println("gc!");
        Runtime.getRuntime().gc();
        
        showFreeMemory();
    }
    
    private static void showFreeMemory() {
        System.out.printf("Free memory : %d Byte %n", Runtime.getRuntime().freeMemory());
    }

}
