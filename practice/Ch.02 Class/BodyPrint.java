
class BodyPrint {
	
	// mainメソッド P.49
	public static void main(String[] args) { // method header
		// method body
		
		Body sun = new Body("Sol", null);
		Body earth = new Body("Earth", sun);
		System.out.println("Body " + earth.getName() + 
						   " orbits " + earth.getOrbits().getName() +
						   " and has ID " + earth.getID());
	}

}
