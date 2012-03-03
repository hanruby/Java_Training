/**
 * JPL chapter 2
 * 彗星、小惑星、惑星、星などの宇宙の天体に関するデータを保持するクラス
 * @author ato
 *
 */
public class Body {
	// クラス修飾子：annotation public {abstract,final} strict
	
	// フィールド (field) << staticではない P.37
	private long idNum;
	private String name = "<unnamed>"; // 初期化子 // P.43
	private Body orbits = null;
	public Body[] bodies; 

	// フィールドの初期化
	// 初期化子 (initializer) P.38
	double zero = 0.0; // 定数
	double sum = 4.5 + 3.7; // 定数式
	double zeroCopy = zero; // フィールド
	double rootTwo = Math.sqrt(2); // メソッド呼び出し
	double someVal = sum + 2*Math.sqrt(rootTwo); // 組み合わせ

	// staticフィールド (static field) OR クラス変数 (class variable) P.39
	public static long nextID = 0;
	
	// finalフィールド (final field)
	public static final long bodyID = 11; // blank field
	public final long finalId;
	/**
	 * finalであるべきかを決めるために検討するべき３つこと
	 * そのフィールドは、オブジェクトの不変な属性を現しているか
	 * そのフィールドの値は、オブジェクトが生成されたときに決まっているか
	 * オブジェクトが生成されたときに、そのフィールドの値を設定するのは、常に実用的で適切か
	 * */

	// コンストラクタ
	public Body() {
		nextID++;
		this.idNum = nextID;
		this.finalId = 111;
	}
	
	/**
	 * P.44
	 * @param name
	 * @param orbits
	 */
	public Body(String name, Body orbits) {
		this();
		this.name = name;
		this.orbits = orbits;
	}

	/**
	 * P.45
	 * @param bodyName
	 */
	public Body(String bodyName) {
		this(bodyName, null);
	}
	
	/**
	 * コピーコンストラクタ P.46
	 * @param other
	 */
	public Body(Body other) { 
		this.finalId = 123;
		//this.idNum = other.idNum;
		this.name = other.name;
		this.orbits = other.orbits;
	}

	/**
	 * 初期化ブロック (initialization block) P.47
	 */
	{
		this.idNum++;
	}
	
	static int[] knownPrimes = new int[4];

	/**
	 * static初期化ブロック (static initialization block) P.48
	 */
	static {
		knownPrimes[0] = 2;
		for(int i=1; i<knownPrimes.length; i++) {
			knownPrimes[i] = 0;
		}
	}
	
	/**
	 * 特定のBodyオブジェクトの状態を表す文字列を返すメソッド P.51
	 */
	public String toString() {
		String desc = idNum + "(" + this.name + ")";
		if (this.orbits != null) {
			desc += " orbits " + this.orbits.toString();
		}
		return desc;
	}
	
	/**
	 * 周回している天体群を受け取るメソッド P.52
	 * @param bodies
	 */
	public void setOrbiters(Body... bodies) {
		this.bodies = bodies;
	}
	
	/**
	 * idNumへのアクセッサーメソッド P.57
	 * @return
	 */
	public long getID() {
		return idNum;
	}
	
	public String getName() { 
		return name;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public Body getOrbits() {
		return orbits;
	}
	
	public void setOrbits(Body orbitsAround) {
		orbits = orbitsAround;
	}
	
	/**
	 * 天体が補足されて起動を周回する
	 * @param victim
	 */
	public void capture(Body victim) {
		// クラスのメソッドのコードは、クラスのすべてのオブジェクトのすべてのフィールドにアクセスできる P.58
		victim.orbits = this; 
	}
	
	/**
	 * 現在の天体が指定された天体を周回していればtrueを返す P.60
	 * @param other
	 * @return
	 */
	public boolean orbitsAround(Body other) {
		return (orbits == other);
	}
	
	/**
	 * 指定された識別子の天体を周回していればtrueを返す P.60
	 * @param id
	 * @return
	 */
	public boolean orbitsAround(long id) {
		return (orbits != null && orbits.idNum == id);
	}

	public static void main(String[] args) {
		// オブジェクトの生成 P.42
		Body sun = new Body();
		sun.idNum = Body.nextID++;
		sun.name = "Sol";
		sun.orbits = null;
		
		Body earth = new Body();
		earth.idNum = Body.nextID++;
		earth.name = "Earth";
		earth.orbits = sun;
				
		Body moon = new Body("Moon", earth);
		Body mars = new Body("Mars", sun);
		Body phobos = new Body("Phobos", mars);
		Body deimos = new Body("Deimos", mars);
		
		earth.setOrbiters(moon);
		mars.setOrbiters(phobos, deimos);
		
		// toStringの暗黙の呼び出し P.51
		System.out.println("Body " + sun);
		System.out.println("Body " + earth);
		System.out.println("Body " + mars);
		System.out.println("Body " + phobos);

		// 外部からのstaticフィールドへのアクセス
		System.out.println(Body.nextID);
		
		// オブジェクトのstaticフィールドへのアクセス <<!! この用法は避けるべき
		//Body mercury = new Body();
		//System.out.println(mercury.nextID);

		// 初期化ブロックの効果
		Body a1 = new Body();
		System.out.println(a1.idNum);

		Body a2 = new Body();
		System.out.println(a2.idNum);
	}
}
