package logic;

import java.util.List;

import org.springframework.dao.DataAccessException;

import bean.DepositionInfo;
import dao.AccountDao;
import model.Account;

public class BankImpl implements Bank {
	private AccountDao accountDao;
	
	

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void insertAccount(Account account) throws DataAccessException {
		// TODO Auto-generated method stub
		accountDao.insertAccount(account);

	}

	@Override
	public List<Account> getAccountList() throws DataAccessException {
		// TODO Auto-generated method stub
		return accountDao.getAccountList();
	}

	@Override
	public Account getAccount(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return accountDao.getAccount(id);
	}

	@Override
	public void updateAccount(Account account) throws DataAccessException {
		// TODO Auto-generated method stub
		accountDao.updateAccount(account);
		
	}

	@Override
	public boolean depositMoney(DepositionInfo depositionInfo) {
		// TODO Auto-generated method stub
		Account account=null;
		try {
			account = accountDao.getAccount(Integer.parseInt(depositionInfo.getId())); // NumberFormateException?
			if(account == null) {
				return false;
			}
			
			int money = Integer.parseInt(depositionInfo.getMoney());
			if(money <= 0) {
				return false;
			}
			synchronized (account) {
				account.setBalance(account.getBalance()+money);
				accountDao.updateAccount(account);
			}
		}catch(NumberFormatException e) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean withdrawMoney(DepositionInfo depositionInfo) {
		// TODO Auto-generated method stub
		Account account=null;
		try {
			account = accountDao.getAccount(Integer.parseInt(depositionInfo.getId())); // NumberFormateException?
			if(account == null) {
				return false;
			}
			
			int money = Integer.parseInt(depositionInfo.getMoney());
			if(money > account.getBalance()) {
				return false;
			}
			synchronized (account) {
				account.setBalance(account.getBalance()-money);
				accountDao.updateAccount(account);
			}
		}catch(NumberFormatException e) {
			return false;
		}
		
		return true;
	}

}
