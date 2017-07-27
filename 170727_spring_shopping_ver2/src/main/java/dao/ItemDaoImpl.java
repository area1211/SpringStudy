package dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import logic.Item;

public class ItemDaoImpl implements ItemDao {
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public List<Item> findAll() {
//		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
//		return this.template.query(ItemDaoImpl.SELECT_ALL, mapper);
		return sqlSession.selectList("getItemList");
	}
	@Override
	public Item find(int itemId) {
//		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
//		// TODO Auto-generated method stub
//		return this.template.queryForObject(SELECT_BY_PRIMARY_KEY, mapper, itemId);
		return sqlSession.selectOne("getItem", itemId);
	}

}
