package id.co.telkomsigma.dao.minibank;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import id.co.telkomsigma.dao.BaseDaoTestCase;
import id.co.telkomsigma.dao.minibank.TransactionsDao;
import id.co.telkomsigma.model.minibank.Account;
import id.co.telkomsigma.model.minibank.Transactions;

public class TransactionDaoTest extends BaseDaoTestCase{
	
	private TransactionsDao transactionDao;
	private AccountDao accountDao;
	
	
	/**
	 * @return the transactionDao
	 */
	public TransactionsDao getTransactionDao() {
		return transactionDao;
	}

	/**
	 * @param transactionDao the transactionDao to set
	 */
	public void setTransactionDao(TransactionsDao transactionDao) {
		this.transactionDao = transactionDao;
		
	}
	
	/**
	 * @return the accountDao
	 */
	public AccountDao getAccountDao() {
		return accountDao;
	}

	/**
	 * @param accountDao the accountDao to set
	 */
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	/*public void testActionGetTransaction(){
		Account account1 = new Account("12345", 5000.00, true);
		Account account2 = new Account("67890", 6000.00, true);
		Transactions transaction1 = new Transactions();
		Transactions transaction2 = new Transactions();
		Set<Transactions> transactions1 = new HashSet<Transactions>();
		Set<Transactions> transactions2 = new HashSet<Transactions>();

		transaction1.setDate(new Date());
		transaction1.setAmount(account1.getBalance());
		transaction1.setStatus(true);
		transaction1.setAccountSource(account1);
		transactions1.add(transaction1);
		account1.setTransactionsources(transactions1);
		account1.setTransactiondestination(transaction1);
		this.getAccountDao().actionSaveAccount(account1);

		transaction2.setDate(new Date());
		transaction2.setAmount(account2.getBalance());
		transaction2.setStatus(true);
		transaction2.setAccountSource(account2);
		transactions2.add(transaction2);
		account2.setTransactionsources(transactions2);
		account2.setTransactiondestination(transaction2);
		this.getAccountDao().actionSaveAccount(account2);

		List<Transactions> transactionGetAll = this.getTransactionDao().actionGetAllTransaction();
//		assertEquals(2, transactionGetAll.size());
		System.out.println("=====All=====");
		for (Transactions transaction : transactionGetAll) {
			System.out.println(transaction.toString());
		}

		List<Transactions> transactionGetByAccountSource = this.getTransactionDao().actionGetTransactionByAccountSource(account1);
//		assertEquals(1, transactionGetByAccountSource.size());
		System.out.println("=====By Account=====");
		for (Transactions transaction : transactionGetByAccountSource) {
			System.out.println(transaction.toString());
		}		

		List<Transactions> transactionGetByDate = this.getTransactionDao().actionGetTransactionByDate(new Date());
//		assertEquals(2, transactionGetByDate.size());
		System.out.println("=====By Date=====");
		for (Transactions transaction : transactionGetByDate) {
			System.out.println(transaction.toString());
		}		
	}*/
}
