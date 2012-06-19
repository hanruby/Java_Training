package ch01.ex01_14;

/**
 * 普通のウォークマン（ひとつの端子を備えてる）
 * @author ato
 *
 */
public class WalkmanBase {
	private int volume = 50;
	private PlayMode state = PlayMode.STOP;
	private Object music;
	
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
	
	public Object getMusic() {
		return this.music;
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
