package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import model.Account;

public interface AccountDao {
	void insertAccount(Account account) throws DataAccessException; 
	List<Account> getAccountList() throws DataAccessException;
	Account getAccount(int id) throws DataAccessException; 
	void updateAccount(Account account) throws DataAccessException;
}
