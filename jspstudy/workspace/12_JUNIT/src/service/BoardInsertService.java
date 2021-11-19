package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.exceptions.PersistenceException;
import org.json.JSONObject;

import dao.mybatis.BoardDAO;
import dto.Board;

public class BoardInsertService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		try {
			// $('#f').serialize() 로 받은 파라미터들
			String bNo = request.getParameter("bNo");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");

			//db로 보낼 데이터
			Board board = new Board();
			board.setbNo(bNo);
			board.setWriter(writer);
			board.setContent(content);

			//DB에 삽입
			int result = BoardDAO.getInstance().insertBoard(board);

			//성공/실패 여부를 JSON 데이터로 작성
			// {"result" :  true} 또는 {"result" : false}
			JSONObject obj = new JSONObject();
			obj.put("result", result > 0);

			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println(obj);

			//catch 블록의 response는 ajax의 error로 응답을 보냄.
		} catch (PersistenceException e) { // Mybatis에서 DB오류 나면 발생된다.
			// 텍스트의 타입 : text/plain
			response.setContentType("text/plain; charset=utf-8");
			
			// 에러 메시지 전달
			PrintWriter out = response.getWriter();
			out.println("DB 오류 발생");
			
			// 에러 코드 전달
			response.setStatus(1111); //에러 코드 1111 발생(1111은 맘대로 정했음)
		}




	}

}
