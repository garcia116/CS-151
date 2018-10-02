package q2;

import java.util.Comparator;

public class bankAccount {
	
	private String name;
	private double balance;

	public bankAccount(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}
	
	public String getName() {
		return name;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public static Comparator<bankAccount> balanceComparator = new Comparator<bankAccount>(){
		@Override
		public int compare(bankAccount a, bankAccount b) {
			return (a.getBalance() < b.getBalance() ? -1 :
					(b.getBalance() == a.getBalance() ? 0 : 1));
		}
	};
	
	@Override
	public String toString() {
		return "Name: " + this.name + ", balance: " + this.balance + "\n";
	}
}
