package cs544.exercise16_1.bank.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.exercise16_1.bank.domain.Account;

@Repository
public class AccountDAOHibernate { // implements IAccountDAO {
	
	@Autowired
	//@Qualifier("sessionFactory")
	private SessionFactory sf ;
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public void saveAccount(Account account) {
		
		sf.getCurrentSession().persist(account);
		
	}
	@Transactional(propagation=Propagation.SUPPORTS)
	public void updateAccount(Account account) {
	
		sf.getCurrentSession().saveOrUpdate(account);

	}
	@Transactional(propagation=Propagation.SUPPORTS)
	public Account loadAccount(long accountnumber) {
	
		
		return (Account)sf.getCurrentSession().get(Account.class, accountnumber);
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public Collection<Account> getAccounts() {		
		Query query = sf.getCurrentSession().createQuery("From Account");
		return query.list();
		
	}
}
