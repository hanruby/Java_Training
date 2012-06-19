package practice.ch04_Interfaces;

interface X {
    int val = 1;
}

interface Y extends X {
    int val = 2;
    int sum = val + X.val;
}

class Z implements Y {}

class XYZ {
    @SuppressWarnings("static-access")
    public static void main(String[] args) {

        // P.106
        // X.valを使用してXのvalにアクセスできる 
        System.out.println("X.val = " + X.val);
        
        // P.107 
        // Zを通してX.valを参照する方法はない
        System.out.println("Z.val = " + Z.val + ", Z.sum = " + Z.sum);
    
        // Zのインスタンスがあれば、X.val
        Z z = new Z();
        System.out.println("z.val=" + z.val +
                           ", ((Y)z).val=" + ((Y)z).val +
                           ", ((X)z).val=" + ((X)z).val);
        
        // これらは、拡張したクラスのstaticフィールドに適用される規則と同じ
    }
}


// P.107
interface C {
    String val = "Interface C";
}

interface D extends X, C {}
// この場合、 D.valは曖昧になる。