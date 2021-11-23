package model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.exceptions.PersistenceException;
import org.json.JSONObject;

import common.ModelAndView;
import dao.StaffDao;
import dto.Staff;

public class StaffInsertService implements StaffService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			String sNo =  request.getParameter("sNo");
			String name = request.getParameter("name");
			String dept = request.getParameter("dept");
			
			Staff staff = new Staff();
			staff.setsNo(sNo);
			staff.setName(name);
			staff.setDept(dept);
			
			int result = StaffDao.getInstance().insertStaff(staff);
			
			JSONObject obj = new JSONObject();
			obj.put("result", result);
			
			
			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println(obj); 
			out.close();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			response.setContentType("text/plain; charset=utf-8");
			
			PrintWriter out = response.getWriter();
			out.println("저장할 수 없는 값이 전달 되었습니다.");
			response.setStatus(1001);
		}

		return null;
	}

}
