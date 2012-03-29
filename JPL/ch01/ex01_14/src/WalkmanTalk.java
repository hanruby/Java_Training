/**
 * ふたりで会話ができるウォークマン（２つの端子と２つのマイクを備えてる）
 * @author ato
 *
 */
public class WalkmanTalk extends WalkmanPair{
	
	protected String voice1;
	protected String voice2;
	
	public void in1(String voice) {
		voice1 = voice;
	}
	
	public void in2(String voice) {
		voice2 = voice;
	}

	public void out1() {
		System.out.println(this.music + " " + this.voice2);
	}
	
	public void out2() {
		System.out.println(this.music + " " + this.voice1);
	}
	
	public static void main(String[] args) {
		WalkmanTalk wm = new WalkmanTalk();
		wm.setMusic("♪♬♫");
		wm.play();
		wm.in1("Hello!");
		wm.in2("こんにちは！");
		wm.out1();
		wm.out2();
		wm.stop();
	}
}
