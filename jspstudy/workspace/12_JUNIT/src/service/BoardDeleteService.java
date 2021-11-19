package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.exceptions.PersistenceException;
import org.json.JSONObject;

import dao.mybatis.BoardDAO;
import dto.Board;

public class BoardDeleteService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		
			// 'bNo=' + $(this).prev().val()
			String bNo = request.getParameter("bNo");


			//DB에 삽입
			int result = BoardDAO.getInstance().deleteBoard(bNo);

			//성공/실패 여부를 JSON 데이터로 작성
			// {"result" :  true} 또는 {"result" : false}
			JSONObject obj = new JSONObject();
			obj.put("result", result > 0);
			

			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println(obj);
			out.close();
	}

}
