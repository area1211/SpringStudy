package logic;

import java.util.List;

import org.springframework.dao.DataAccessException;

import bean.DepositionInfo;
import model.Account;

public interface Bank {
	void insertAccount(Account account) throws DataAccessException; 
	List<Account> getAccountList() throws DataAccessException;
	Account getAccount(int id) throws DataAccessException; 
	void updateAccount(Account account) throws DataAccessException;
	boolean depositMoney(DepositionInfo depositionInfo);
	boolean withdrawMoney(DepositionInfo depositionInfo);
}
