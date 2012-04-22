package ch01.ex01_14;


public class iPhoneClass extends iPodClass{
	private String name;
		
	public iPhoneClass() {
		super();
		this.name = "iPhone";
	}
	
	public void play() {
		System.out.println(this.name + ": Play music!");
	}
	
	public void setVolume(int volume) {
		super.setVolume(volume);
	}

	public int getVolume() {
		return super.getVolume();
	}
	
	public static void main(String[] args) {
		iPodClass iPod = new iPodClass();
		iPodClass iPhone = new iPhoneClass();
		iPhoneClass iPhone2 = (iPhoneClass) iPhone;
		
		iPod.play();
		iPhone.play();
		iPhone2.play();
	}
}
