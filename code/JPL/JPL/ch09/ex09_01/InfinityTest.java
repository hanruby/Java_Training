package ch09.ex09_01;

public class InfinityTest {
    
    public static void main(String[] args) {
        calc(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        calc(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
        calc(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        calc(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }
    
    public static void calc(double x, double y) {
        
        System.out.println("==============================");
        System.out.printf("x = %f, y = %f %n", x, y);
        System.out.println("------------------------------");
        System.out.printf("x + y = %f%n", x + y);
        System.out.printf("x - y = %f%n", x - y);
        System.out.printf("x * y = %f%n", x * y);
        System.out.printf("x / y = %f%n", x / y);
    }

    
}
