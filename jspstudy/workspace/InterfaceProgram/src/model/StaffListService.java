package model;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import common.ModelAndView;
import dao.StaffDao;
import dto.Staff;

public class StaffListService implements StaffService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {


		List<Staff> list = StaffDao.getInstance().selectStaffList();


		JSONArray arr = new JSONArray();    

		for(Staff staff :  list) {
			JSONObject obj = new JSONObject();
			obj.put("sNo", staff.getsNo());
			obj.put("name", staff.getName());
			obj.put("dept", staff.getDept());
			obj.put("regDate", staff.getRegDate());
			arr.put(obj);
		}

//		System.out.println(arr.toString());
		
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		out.println(arr);						
		out.close();

		return null;
	}

}
