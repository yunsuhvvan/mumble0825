package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;

public interface EmpService {
	public ModelAndView  execute(HttpServletRequest request, HttpServletResponse response); //모든 모델들은 응답할 뷰와 .. 넘빨라..
}
