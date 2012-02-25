
public class Body {
	// フィールド (field) << staticではない
	public long idNum;
	public String name;
	public Body orbits;

	// 初期化子 (initializer)
	double zero = 0.0; // 定数
	double sum = 4.5 + 3.7; // 定数式
	double zeroCopy = zero; // フィールド
	double rootTwo = Math.sqrt(2); // メソッド呼び出し
	double someVal = sum + 2*Math.sqrt(rootTwo); // 組み合わせ

	// staticフィールド (static field) OR クラス変数 (class variable)
	public static long nextID = 987;
	
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
		this.finalId = 111;
	}

	public Body(Body other) {
		this.finalId = 123;
		//this.idNum = other.idNum;
		this.name = other.name;
		this.orbits = other.orbits;
	}

	// 初期化ブロック (initialization block)
	{
		this.idNum++;
	}
	
	static int[] knownPrimes = new int[4];

	// static初期化ブロック (static initialization block)
	static {
		knownPrimes[0] = 2;
		for(int i=1; i<knownPrimes.length; i++) {
			knownPrimes[i] = 0;
		}
	}
	
	public static void main(String[] args) {
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
