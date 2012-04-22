import static java.lang.System.out;

public class InitExperiment {
	static String staticVal = "Init on the declaration statement";
	
	private String val = "Init on the declaration statement";
	
	{
		out.println("initialization block : " + val);
		val = "Init on the initialization block";
		out.println("initialization block : " + val);
	}
	
	public InitExperiment() {
		out.println("constructor : " + val);
		val = "Init on the constructor";
		out.println("constructor : " + val);
	}

	public InitExperiment(String str) {
		this();
		out.println("constructor 2 : " + val);
		val = str;
		out.println("constructor 2 : " + val);
	}
	
	public static void main(String[] args) {
		InitExperiment test = new InitExperiment("Init on new");
		System.out.println(test);
	}
}
