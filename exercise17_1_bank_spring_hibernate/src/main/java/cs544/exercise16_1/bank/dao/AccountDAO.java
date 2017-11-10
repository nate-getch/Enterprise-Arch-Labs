package cs544.exercise16_1.bank.dao;

import java.util.*;

import cs544.exercise16_1.bank.domain.Account;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
//@Transactional(propagation = Propagation.MANDATORY)
public class AccountDAO implements IAccountDAO {
	@Autowired
	SessionFactory sf;

	public void saveAccount(Account account) {
		sf.getCurrentSession().persist(account);
	}

	public void updateAccount(Account account) {
		Account accountexist = loadAccount(account.getAccountnumber());
		if (accountexist != null) {
			sf.getCurrentSession().delete(accountexist);
			sf.getCurrentSession().persist(account);
		}
	}

	public Account loadAccount(long accountnumber) {
		Account account = (Account) sf.getCurrentSession().get(Account.class, accountnumber);
		return account;
	}

	public Collection<Account> getAccounts() {
		return sf.getCurrentSession().createQuery("from Account").list();
	}

}
