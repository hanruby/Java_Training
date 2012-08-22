package ch17.ex17_03;


public class ResourceManagerTest {

    public static void main(String[] args) {
        
        int SIZE = 10000;
        ResourceManager manager;
        String key;

        manager = new ResourceManager();
        Resource[] resArr = new Resource[SIZE];

        showFreeMemory();
        
        for(int i = 0; i < SIZE; i++) {
            key = String.valueOf("str:"+i);
            resArr[i] = manager.getResource(key);
            resArr[i].use(key, new Integer(i));
            key = null;
        }

        showFreeMemory();
        
        for(int i = SIZE; i < SIZE / 2; i++){
            resArr[i].release();
        }

        System.out.println("gc!");
        
        Runtime.getRuntime().gc();
        
        showFreeMemory();
        
        manager.shutdown();
        
        showFreeMemory();
    }
    
    private static void showFreeMemory() {
        System.out.printf("Free memory : %d Byte %n", Runtime.getRuntime().freeMemory());
    }

}
