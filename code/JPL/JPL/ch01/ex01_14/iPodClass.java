package ch01.ex01_14;


public class iPodClass {
	private String name;
	private int volume;
		
	public iPodClass() {
		this.name = "iPod";
		this.setVolume(10);
	}

	public void play() {
		System.out.println(this.name + ": Play music!");
	}
	
	public void stop() {
		System.out.println(this.name + ": Stop");		
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getVolume() {
		return volume;
	}
}
