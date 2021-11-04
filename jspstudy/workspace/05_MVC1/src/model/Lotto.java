package model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Lotto {

	public void execute(HttpServletRequest request) {
		
		
		int lotto = (int)(Math.random()*45)+1;
		
		request.setAttribute("lotto", lotto);
		
	}
	
}
