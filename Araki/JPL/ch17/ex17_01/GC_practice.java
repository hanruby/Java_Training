package ch17.ex17_01;

public class GC_practice {
    
    public static void main(String[] args) {

        Runtime.getRuntime().gc(); // System.gc(); と同じ

        showFreeMemory();
        
        System.out.println("Now, creating objects.");

        {
            for(int i = 0; i < 10000; i++){
                @SuppressWarnings("unused")
                Byte[] array = new Byte[1000];
            }
        }
        System.out.println("Done.");
        
        showFreeMemory();
        
        System.out.println("Free.");
        Runtime.getRuntime().gc(); // System.gc(); と同じ
        
        System.out.println("Done.");
        showFreeMemory();
    }

    
    
    private static void showFreeMemory() {
        System.out.printf("Free memory : %d Byte %n", Runtime.getRuntime().freeMemory());
    }



    /**
     * P.397 できるだけメモリを解放するメソッド <br>
     * 注意： <br>
     * gcを繰り返し呼び出すため、非生産的な処理。
     */
    public static void fullGC() {
        Runtime rt = Runtime.getRuntime();
        long isFree = rt.freeMemory();
        long wasFree;
        do {
            wasFree = isFree;
            rt.runFinalization();
            rt.gc();
            isFree = rt.freeMemory();
        } while (isFree > wasFree);
    }
}


