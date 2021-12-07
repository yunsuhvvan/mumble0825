package com.koreait.ex08.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.koreait.ex08.domain.Contact;

public class ContactRepository {
	
	//Spring JDBC 이용을 위해 JdbcTemplate 클래스 사용
	// JdbcTemplate 내부에서 Connection, PreparedStatement, ResultSet을 사용(직접 꺼낼 필요가 없다.)
	@Autowired
	private JdbcTemplate template;
	private String sql;
	
	
	public List<Contact> selectContactList(){
		sql ="SELECT NO, NAME, TEL, ADDRESS, BIRTHDAY FROM CONTACT";
		return template.query(sql, new BeanPropertyRowMapper<Contact>(Contact.class)); // 데이터베이스 행 하나하나 마다 Contact에 넣어서 반환해라.
		
	}
	
	public int insertContact (Contact contact) {
		return template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				// 매개변수 Connection con을 이용해서 PreparedStatement ps 만들어서 반환함.
				sql = "INSERT INTO CONTACT VALUES(CONTACT_SEQ.NEXTVAL, ?, ?, ?, ?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, contact.getName());
				ps.setString(2, contact.getTel());
				ps.setString(3, contact.getAddress());
				ps.setString(4, contact.getBirthday());
				return ps;
			}
		});
	}
	
	public Contact selectContactByNo(Contact contact) {
		sql = "SELECT NO, NAME, TEL, ADDRESS, BIRTHDAY FROM CONTACT WHERE no= ?";
		return template.queryForObject(sql, new BeanPropertyRowMapper<Contact>(Contact.class), contact.getNo());
	}
	
	public int updateContact(Contact contact) {
		sql ="UPDATE CONTACT SET TEL=?, ADDRESS=?, BIRTHDAY=? WHERE NO=?";
		return template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// 매개변수  PreparedStatement ps에 ? 채우기
				ps.setString(1, contact.getTel());
				ps.setString(2, contact.getAddress());
				ps.setString(3, contact.getBirthday());
				ps.setInt(4, contact.getNo());
				
			}
		});
	}
	public int deleteContact(Contact contact) {
		sql ="DELETE FROM CONTACT WHERE NO= ?";
		return template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, contact.getNo());
				
			}
		});
	}
	
}
