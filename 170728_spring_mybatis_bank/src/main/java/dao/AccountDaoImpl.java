package dao;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

import model.Account;

public class AccountDaoImpl implements AccountDao {
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void insertAccount(Account account) throws DataAccessException {
		// TODO Auto-generated method stub
		sqlSession.insert("makeAccount", account);
		
	}

	@Override
	public List<Account> getAccountList() throws DataAccessException {
		// TODO Auto-generated method stub
		
		return sqlSession.selectList("getAccounts");
	}

	@Override
	public Account getAccount(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("getAccount", Integer.toString(id));
	}

	@Override
	public void updateAccount(Account account) throws DataAccessException {
		// TODO Auto-generated method stub
		sqlSession.update("updateAccount", account);
	}

	
//	@Override
//	public void insertAccount(Account account) throws DataAccessException {
//		Map<String, Object> parameters = new HashMap<String, Object>();
//		parameters.put("acc_id", account.getId());
//		parameters.put("name", account.getName());
//		parameters.put("balance", account.getBalance());
//		insertAccount.execute(parameters);
//		
//	}
//
//	@Override
//	public List<Account> getAccountList() throws DataAccessException {
//		//RowMapper<Account> rowMapper = new AccountRowMapper();
//		RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
//		
//		List<Account> accountList = getJdbcTemplate().query("select acc_id, name, balance from account", rowMapper);
//		
//		//System.out.println("**������:"+accountList.size());
//		if(accountList.size()==0)
//			System.out.println("*** ���°� ���������ʽ��ϴ�. ***");
//		
//		return accountList;
//	}
//
//	@Override
//	public Account getAccount(int id) throws DataAccessException {
//		// TODO Auto-generated method stub
//		return accountQuery.findObject(id);
//	}
//	class AccountQuery extends MappingSqlQuery<Account> {
//		private final static String sql_account_query = "select acc_id, name, balance from account where acc_id=?";
//		public AccountQuery(DataSource ds){
//			super(ds, sql_account_query);
//			super.declareParameter(new SqlParameter("acc_id", Types.INTEGER));
//			compile();
//		}
//		@Override
//		protected Account mapRow(ResultSet rs, int arg1) throws SQLException {
//			Account account = new Account(rs.getInt("acc_id"), rs.getString("name"), rs.getInt("balance"));
//			return account;
//		}
//		
//	}
//	
//	@Override
//	public void updateAccount(Account account) throws DataAccessException {
//		// TODO Auto-generated method stub
//		updateAccount.update(account.getBalance(), account.getId());
//	}
//	
//	class UpdateAccount extends SqlUpdate{
//		private static final String sql_update = "update account set balance=? where acc_id=?";
//		public UpdateAccount(DataSource ds){
//			super(ds, sql_update);
//			super.declareParameter(new SqlParameter("acc_id", Types.INTEGER));
//			//super.declareParameter(new SqlParameter("name", Types.VARCHAR));
//			super.declareParameter(new SqlParameter("balance", Types.INTEGER));
//			compile();
//		}
//	}
	
//	protected class AccountRowMapper implements RowMapper<Account>{
//		private List<Account> accountList = new ArrayList<Account>();
//		public List<Account> getAccountList() {
//			return accountList;
//		}
//		public void setAccountList(List<Account> accountList) {
//			this.accountList = accountList;
//		}
//
//		//���ڵ� ������ŭ mapRow�� ȣ��ȴ�.
//		public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
//			Account account = new Account();
//			account.setId(rs.getInt("acc_id"));
//			account.setName(rs.getString("name"));
//			account.setBalance(rs.getInt("balance"));
//			return account;
//		}
//	}
}
