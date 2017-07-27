package dao;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import logic.User;

public class UserDaoImpl implements UserDao {
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
//	private SimpleJdbcTemplate template;
////	public void setTemplate(SimpleJdbcTemplate template) {
////		this.template = template;
////	}
//	public void setDataSource(DataSource ds) {
//		template = new SimpleJdbcTemplate(ds);
//	}
//
//	private static final String SELECT_BU_USERID_PASSWORD = "select user_id, user_name, password "
//			+ "from user_account where user_id=? and password=?";

	@Override
	public User findByUserIdAndPassword(String userId, String password) {
//		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
//		// TODO Auto-generated method stub
//		return template.queryForObject(SELECT_BU_USERID_PASSWORD, mapper, userId, password);
		User user = sqlSession.selectOne("getUser", new User(userId, "", password));
		System.out.println(user);
		return user;
	}

}
