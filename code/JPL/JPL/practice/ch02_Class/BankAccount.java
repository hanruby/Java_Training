package practice.ch02_Class;

public class BankAccount {
	public class Person {

	}

	@SuppressWarnings("unused")
	private long number; //!< 口座番号
	@SuppressWarnings("unused")
	private long balance; //!< 現在の残高（単位はセント）
	
	/**
	 * 複数の値を返すために、各フィールドを設定するメソッド P.53
	 * @param who
	 * @return
	 */
	public Permissions permissionsFor (Person who) {
		Permissions perm = new Permissions();
		perm.canDeposit = canDeposit(who);
		perm.canWithdraw = canWithdraw(who);
		perm.canClose = canClose(who);
		return perm;
	}

	private boolean canClose(Person who) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean canWithdraw(Person who) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean canDeposit(Person who) {
		// TODO Auto-generated method stub
		return false;
	}

}
