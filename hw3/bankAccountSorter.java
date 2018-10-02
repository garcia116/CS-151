package q2;

import java.util.ArrayList;
import java.util.Collections;

public class bankAccountSorter {

	static ArrayList<bankAccount> BankAccount = new ArrayList<>();
	
	public bankAccountSorter(ArrayList<bankAccount> BankAccount) {
		this.BankAccount = BankAccount;
	}
	
	public static ArrayList<bankAccount> getSortedBankAccountByBalance(){
		Collections.sort(BankAccount, bankAccount.balanceComparator);
		return BankAccount;
	}
}
