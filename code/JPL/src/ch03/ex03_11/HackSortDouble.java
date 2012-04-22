package ch03.ex03_11;

public class HackSortDouble extends SortDouble implements Cloneable{
    
    @Override
    protected SortDouble clone(){
        System.out.println("clone!!");
        try {
            return (SortDouble)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    protected void doSort() {
        // cloneしても問題ない。。
        SortDouble c = this.clone();
        HackSortDouble n = (HackSortDouble)this.clone();
        
        // オーバーフローさせるしかない？？
        // for (long j = 0; j < 0x7FFFFFFF; j++) {
        //     compare(0,0); //...... さらに繰り返す必要がある。
        // }
        
        for (int i = 0; i < getDataLength(); i++) {
            for (int j = i + 1; j < getDataLength(); j++) {
                if (c.compare(i, j) > 0) {
                    n.swap(i, j);
                }
            }
        }
        
        // 結論、セキュリティホールはない・・・
        
        
    }

            
    public static void main(String[] args) {
        double[] testData = {
            0.3, 1.3e-2, 7.9, 3.17
        };
        
        System.out.println(HackSortDouble.class.getName());
        
        SortDouble bsort = new HackSortDouble();
        SortMetrics metrics = bsort.sort(testData);
        System.out.println("Metrics: " + metrics);
        for (int i = 0; i < testData.length; i++)
            System.out.println("\t" + testData[i]);
    }
}
