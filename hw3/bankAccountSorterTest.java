package q2;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;



public class bankAccountSorterTest {

	bankAccountSorter BankAccountSorter;
	
	@Before
	public void setUp() throws Exception{
		
		ArrayList<bankAccount> bankAccounts = new ArrayList<>();
		
		bankAccount bankaccount1 = new bankAccount("Dwayne Johnson", 54678.2);
		bankAccount bankaccount2 = new bankAccount("Emma Watson", 857678.2);
		bankAccount bankaccount3 = new bankAccount("Eva Langoria", 6187.94);
		bankAccount bankaccount4 = new bankAccount("Mark Wahlberg", 481.79);
		bankAccount bankaccount5 = new bankAccount("Emma Stone", 287146.32);
		ArrayList<bankAccount> bankAccountList = new ArrayList<>();
		bankAccountList.add(bankaccount1);
		bankAccountList.add(bankaccount2);
		bankAccountList.add(bankaccount3);
		bankAccountList.add(bankaccount4);
		bankAccountList.add(bankaccount5);
		BankAccountSorter = new bankAccountSorter(bankAccountList);

	}
	
	
	@Test
	public void testGetSortedBankAccountByBalance() throws Exception {
		System.out.println("-- Sorted Bank Accounts by balance: --");
		ArrayList<bankAccount> sortedBankAccounts = bankAccountSorter.getSortedBankAccountByBalance();
		for(bankAccount bankAccount : sortedBankAccounts) {
			System.out.print(bankAccount);
		}
	}

}
