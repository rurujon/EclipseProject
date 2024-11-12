package com.util.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;




//database연결하는 dao
@Repository("dao") //spring이 dao로 객체생성함, db관련된 애임을 앎
public class CommonDAOImpl implements CommonDAO {
	
	//의존성 주입
	@Autowired //spring이 밑에 주석 적지 않아도 이름이 같으면 알아서 의존성 주입한다 
	private SqlMapClientTemplate sqlMapClientTemplate; 
	
	
	/*
	 * //메소드로 받아야함. 생성자로 받으면 안됨 public void
	 * setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
	 * //sqlMapClientTemplate자동으로 넘어옴 this.sqlMapClientTemplate =
	 * sqlMapClientTemplate; }
	 */
	
	
	

	@Override
	public void insertData(String id, Object value) throws SQLException {
		
		try {
			
					
			sqlMapClientTemplate.insert(id,value);
			
						
		} catch (Exception e) {
			System.out.println(e.toString());
		} 
		
	}

	@Override
	public int updateData(String id, Object value) throws SQLException {
		
		int result = 0;
		
		try {

			
			result = sqlMapClientTemplate.update(id,value); //반환값이 있기 때문에 앞에 result를 적어줌

			
		} catch (Exception e) {
			System.out.println(e.toString());
		} 
		
		return result;
		
	}

	@Override
	public int updateData(String id, Map<String, Object> map) throws SQLException {
		
		int result = 0;

		try {

			
			result = sqlMapClientTemplate.update(id,map); //반환값이 있기 때문에 앞에 result를 적어줌

			
		} catch (Exception e) {
			System.out.println(e.toString());
		} 

		return result;
		
	}

	@Override
	public int deleteData(String id) throws SQLException {
		
		int result = 0;

		try {
			

			result = sqlMapClientTemplate.delete(id); //반환값이 있기 때문에 앞에 result를 적어줌

			
		} catch (Exception e) {
			System.out.println(e.toString());
		} 

		return result;
		
	}

	@Override
	public int deleteData(String id, Object value) throws SQLException {
		
		int result = 0;

		try {

		
			result = sqlMapClientTemplate.delete(id,value); //반환값이 있기 때문에 앞에 result를 적어줌

			
		} catch (Exception e) {
			System.out.println(e.toString());
		} 

		return result;
		
	}

	@Override
	public int deleteData(String id, Map<String, Object> map) throws SQLException {
		
		int result = 0;

		try {

			
			result = sqlMapClientTemplate.delete(id,map); //반환값이 있기 때문에 앞에 result를 적어줌

			
		} catch (Exception e) {
			System.out.println(e.toString());
		} 

		return result;
		
	}

	@Override
	public Object getReadData(String id) {
		
		try {
			
			return sqlMapClientTemplate.queryForObject(id); //select는 트랜잭션이 없음
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return null;
		
	}

	@Override
	public Object getReadData(String id, Object value) {
		
		try {

			return sqlMapClientTemplate.queryForObject(id,value); //select는 트랜잭션이 없음

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return null;
		
	}

	@Override
	public Object getReadData(String id, Map<String, Object> map) {
		
		try {

			return sqlMapClientTemplate.queryForObject(id,map); //select는 트랜잭션이 없음

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return null;
		
	}

	@Override
	public int getIntValue(String id) {
		
		try {
			
			return ((Integer)sqlMapClientTemplate.queryForObject(id)).intValue(); //select는 트랜잭션이 없음
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return 0;
		
	}

	@Override
	public int getIntValue(String id, Object value) {
		
		try {

			return ((Integer)sqlMapClientTemplate.queryForObject(id,value)).intValue(); //select는 트랜잭션이 없음

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return 0;
		
	}

	@Override
	public int getIntValue(String id, Map<String, Object> map) {
		
		try {

			return ((Integer)sqlMapClientTemplate.queryForObject(id,map)).intValue(); //select는 트랜잭션이 없음

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return 0;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getListData(String id) {
		
		try {

			return (List<Object>)sqlMapClientTemplate.queryForList(id); //select는 트랜잭션이 없음

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return null;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getListData(String id, Object value) {
		
		try {

			return (List<Object>)sqlMapClientTemplate.queryForList(id,value); //select는 트랜잭션이 없음

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return null;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getListData(String id, Map<String, Object> map) {
		
		try {

			return (List<Object>)sqlMapClientTemplate.queryForList(id,map); //select는 트랜잭션이 없음

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return null;
		
	}

}
