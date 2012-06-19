package ch01.ex01_02;


//class HelloJava { /// Exception in thread "main" java.lang.NoClassDefFoundError: HelloWorld
class HelloWorld {
	//public static int main(String[] args) { /// Error: This method must return a result of type int
	//public void main(String[] args) { /// Exception in thread "main" java.lang.NoSuchMethodError: main
	//private static void main(String[] args) { /// Main method not public.
	public static void main(String[] args) {
		//int tmp; /// Warning: The local variable tmp is never read
		//int tmp; System.out.println(tmp); /// Error: The local variable tmp may not have been initialized

		//int tmp = "hoge"; /// Error: Type mismatch: cannot convert from String to int
		//int int; /// Error: Syntax error on token "int", invalid VariableDeclarator
		//int tmp = (int)"hoge"; /// Error: Cannot cast from String to int
		//int tmp = (float)1; /// Error: Type mismatch: cannot convert from float to int
		//int tmp = 1; tmp.toString(); /// Error: Cannot invoke toString() on the primitive type int
		//void tmp; /// Error: void is an invalid type for the variable tmp
		//String str = 1; /// Error: Type mismatch: cannot convert from int to String
		//string str; /// Error: string cannot be resolved to a type
		//String str = "hoge"; str.toString(1); /// Error: The method toString() in the type String is not applicable for the arguments (int)

		//public static int tmp; /// Error: Illegal modifier for parameter tmp; only final is permitted
		//static int tmp; /// Error: Illegal modifier for parameter tmp; only final is permitted

		//main(args); // Exception in thread "main" java.lang.StackOverflowError
		
		System.out.println("Hello, World");
		//System.out.println("Hello, World"+1+2-1); /// Error: The operator - is undefined for the argument type(s) String, int
		//System.out.println(,"Hello, World"); /// Error: Syntax error on token ",", delete this token
		
		//return 1; /// Error: Void methods cannot return a value
		//Return 1;  /// Error: Syntax error on token "Return", return expected

	}
	//public static void main(String[] args) {} /// Error: Duplicate method main(String[]) in type HelloWorld
	//return 1; /// 2 Errors: Syntax error on token "}", { expected after this token // Syntax error, insert "}" to complete ClassBody
}

//int tmp; /// 2 Errors: Syntax error on token "}", delete this token // Syntax error, insert "}" to complete ClassBody

//} /// Error: Syntax error on token "}", delete this token
//{ /// Error: Syntax error on token "{", delete this token

