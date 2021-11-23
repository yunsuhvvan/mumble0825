package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Staff;
import mybatis.config.DBService;

public class StaffDao {

	private SqlSessionFactory factory;
	private static StaffDao instance;
	
	private StaffDao() {
		factory = DBService.getInstance().getFactory();

	}
	public static StaffDao getInstance() {
		if(instance == null) {
			instance = new StaffDao();
		}
		return instance;
	}
	
	
		//1. 사원 목록 
		public List<Staff> selectStaffList(){
			SqlSession ss= factory.openSession();
			List<Staff> list = ss.selectList("dao.staff.selectStaffList");
			ss.close();
			return list;
		}
		
		// 2. 사원 등록 
		public int insertStaff(Staff staff) {
			SqlSession ss = factory.openSession(false);
			int result = ss.insert("dao.staff.insertStaff", staff);
			if(result>0) ss.commit(); 
			ss.close();
			return result;
		}
	
		public Staff selectStaffBysNo(String sNo) {
			SqlSession ss = factory.openSession();
			Staff staff = ss.selectOne("dao.staff.selectStaffBysNo", sNo);
			ss.close();
			return staff;
		}
	
	

		public int deleteStaff(String sNo) {
			SqlSession ss = factory.openSession(false);
			int result = ss.delete("dao.staff.deleteStaff", sNo);
			if(result>0)ss.commit();
			ss.close();
			return result;
		}
	
	
}
