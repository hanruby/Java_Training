/**
 * 普通のウォークマン（ひとつの端子を備えてる）
 * @author ato
 *
 */
public class WalkmanBase {
	protected int volume = 50;
	protected PlayMode state = PlayMode.STOP;
	protected String music;
	
	public enum PlayMode { PLAY, STOP, }
	
	public WalkmanBase() {
	}
	
	public void play() {
		state = PlayMode.PLAY;
		this.showStatus();
	}
	
	public void stop() {
		state = PlayMode.STOP;
		this.showStatus();
	}
	
	public void showStatus() {
		System.out.println(state);		
	}
	
	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public void setMusic(String music) {
		this.music = music;
	}
	
	public void output() {
		System.out.println(music);
	}

	public static void main(String[] args) {
		WalkmanBase wm = new WalkmanBase();
		wm.setMusic("♪♬♫");
		wm.play();
		wm.output();
		wm.stop();
	}
}
