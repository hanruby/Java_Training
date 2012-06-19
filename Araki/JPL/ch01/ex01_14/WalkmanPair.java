package ch01.ex01_14;

/**
 * ふたりで同じテープが聞けるウォークマン（２つ端子を備えてる）
 * @author ato
 *
 */
public class WalkmanPair extends WalkmanBase{

	public void out1() {
		super.output();
	}
	
	public void out2() {
		super.output();		
	}
	
	public static void main(String[] args) {
		WalkmanPair wm = new WalkmanPair();
		wm.setMusic("♪♬♫");
		wm.play();
		wm.out1();
		wm.out2();
		wm.stop();
	}
}
