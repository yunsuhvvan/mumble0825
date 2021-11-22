package service.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.jdbc.BoardDAO;
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
			
		//예외코드 정리
	    // 2001: 동일한 게시글번호 재등록 , 필수 칼럼 누락
		// 2002: 잘못된 데이터 전달(DB 오류)
		// 2003: 알 수 없는 예외
			
		} catch (SQLIntegrityConstraintViolationException e) { //
			e.printStackTrace();
			// 텍스트의 타입 : text/plain
			response.setContentType("text/plain; charset=utf-8");
			
			// 에러 메시지 전달
			PrintWriter out = response.getWriter();
			out.println("동일한 게시글 번호가 있거나 필수 정보가 누락되었습니다.");
			
			// 에러 코드 전달
			response.setStatus(2001); // 에러코드 2001 발생
		} catch (SQLException e) {
			PrintWriter out = response.getWriter();
			out.println("잘못된 데이터가 전달 되었습니다.");
			response.setStatus(2002);
			
		} catch (Exception e) {
			response.setContentType("text/plain; charset=utf-8");
			
			PrintWriter out = response.getWriter();
			out.println("알 수 없는 예외가 발생했습니다.");
			
			response.setStatus(2003);

		}




	}

}
