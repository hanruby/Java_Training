import java.util.Date;
import java.util.Locale;


public class PrintTest {
	public static void main(String[] args) {
		int x = 10;
		int y = 23;
		int sum = x+y;
		
		System.out.printf("%d+%d=%d %n", x,y,sum);

		System.out.printf(Locale.JAPANESE,"The date is %tc %n",new Date());
		System.out.printf(Locale.ENGLISH,"The date is %tc %n",new Date());
	}
}
