
public class Point {
	public double x, y;
	public static Point origin = new Point(); // class variable
	
	public void clear() {
		this.x = 0.0;
		this.y = 0.0;
	}
	
	public double distance(Point that) {
	    double xdiff = x - that.x;
	    double ydiff = y - that.y;
	    return Math.sqrt(xdiff * xdiff + ydiff * ydiff);
	}
	
	public void move(double x, double y) {
	     this.x = x;
	     this.y = y;
	}

	public void show() {
		System.out.println("(" + this.x + ", " + this.y + ")");		
	}
	
	public void pass(Point that) {
		this.x = that.x;
		this.y = that.y;
	}
	
	public static void main (String[] args) {
		Point lowerLeft = new Point();
		Point upperRight = new Point();
		Point middlePoint = new Point();

		lowerLeft.x = 0.0;
		lowerLeft.y = 0.0;

		upperRight.x = 1280.0;
		upperRight.y = 1024.0;

		middlePoint.x = 640.0;
		middlePoint.y = 512.0;
		
		lowerLeft.show();
		upperRight.show();
		middlePoint.show();
		
		double d = lowerLeft.distance(upperRight);
		
		System.out.println(d);
		
	}
}


