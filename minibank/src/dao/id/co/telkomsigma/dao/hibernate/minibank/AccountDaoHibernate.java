package id.co.telkomsigma.dao.hibernate.minibank;

import java.util.List;

import id.co.telkomsigma.dao.hibernate.BaseDaoHibernate;
import id.co.telkomsigma.dao.minibank.AccountDao;
import id.co.telkomsigma.model.minibank.Account;
import id.co.telkomsigma.model.minibank.CIF;

public class AccountDaoHibernate extends BaseDaoHibernate implements AccountDao{

	@Override
	public Account actionGetAccount(Long id) {
		return (Account) getHibernateTemplate().get(Account.class, id);
	}

	@Override
	public List<Account> actionGetAllAccount() {
		return getHibernateTemplate().loadAll(Account.class);
	}

	@Override
	public List<Account> actionGetAllAccountByCif(CIF cif) {
		return getHibernateTemplate().find("from Account where fk_cif_id = ?",cif.getId());
	}

	@Override
	public void actionSaveAccount(Account account) {
		if(account!=null){
			getHibernateTemplate().saveOrUpdate(account);
			getHibernateTemplate().flush();
		}
	}
}
