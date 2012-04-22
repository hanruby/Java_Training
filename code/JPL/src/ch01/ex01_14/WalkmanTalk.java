/**
 * ふたりで会話ができるウォークマン（２つの端子と２つのマイクを備えてる）
 * @author ato
 *
 */
public class WalkmanTalk extends WalkmanPair{
	
	protected Object voice1;
	protected Object voice2;
	
	public void in1(Object voice) {
		voice1 = voice;
	}
	
	public void in2(Object voice) {
		voice2 = voice;
	}

	public void out1() {
		System.out.println(this.getMusic() + " " + this.voice2);
	}
	
	public void out2() {
		System.out.println(this.getMusic() + " " + this.voice1);
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
