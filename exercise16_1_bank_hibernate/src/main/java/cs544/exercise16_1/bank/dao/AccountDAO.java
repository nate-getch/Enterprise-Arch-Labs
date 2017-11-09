package cs544.exercise16_1.bank.dao;

import java.util.*;

import cs544.exercise16_1.bank.domain.Account;
import org.hibernate.SessionFactory;

public class AccountDAO implements IAccountDAO {
	Collection<Account> accountlist = new ArrayList<Account>();
	private SessionFactory sf= HibernateUtil.getSessionFactory();

	public void saveAccount(Account account) {
		// System.out.println("AccountDAO: saving account with accountnr ="+account.getAccountnumber());
		//accountlist.add(account); // add the new
		sf.getCurrentSession().persist(account);
	}

	public void updateAccount(Account account) {
		// System.out.println("AccountDAO: update account with accountnr ="+account.getAccountnumber());
		Account accountexist = loadAccount(account.getAccountnumber());
		if (accountexist != null) {
			//accountlist.remove(accountexist); // remove the old
			sf.getCurrentSession().delete(accountexist);
			//accountlist.add(account); // add the new
			sf.getCurrentSession().persist(account);
		}

	}

	public Account loadAccount(long accountnumber) {
		// System.out.println("AccountDAO: loading account with accountnr ="+accountnumber);
//		for (Account account : accountlist) {
//			if (account.getAccountnumber() == accountnumber) {
//				return account;
//			}
//		}
		Account account = (Account) sf.getCurrentSession().get(Account.class, accountnumber);
		return account;
	}

	public Collection<Account> getAccounts() {
		return sf.getCurrentSession().createQuery("from Account").list();
		//return accountlist;
	}

}
