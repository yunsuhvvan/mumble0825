package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import dao.StaffDao;
import dto.Staff;

class Stafftest {
	
	@BeforeEach
	void 입력테스트() {
		Staff staff = new Staff();
		staff.setsNo("99999");
		staff.setName("테스트");
		staff.setDept("테스트부서");
		
		int result= StaffDao.getInstance().insertStaff(staff);
		assertEquals(1, result, "사원 등록에 문제가 있습니다.");
	}
	
	@AfterEach
		void 삭제테스트() {
			int result = StaffDao.getInstance().deleteStaff("99999");
			assertEquals(1, result,"삭제오류");
		}
	
	
	
	
	//@Test
	void 사원조회_테스트(){
		System.out.println("사원조회_테스트");
		assertNotNull(StaffDao.getInstance().selectStaffBysNo("01245") , "사원 검색에 문제가 있습니다.");
	}
	
	

}
