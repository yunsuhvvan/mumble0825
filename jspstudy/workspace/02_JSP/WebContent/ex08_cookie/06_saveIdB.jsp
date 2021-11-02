<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    
    		<%
    			request.setCharacterEncoding("utf-8");
    			//입력 없으면 빈 문자열 ("")
    			String userId = request.getParameter("userId");
    			String userPw = request.getParameter("userPw");
    			String checkSaveId =request.getParameter("checkSaveId");
    			
    			// 체크 안하면 널(null)
    			out.println("널 ? " + (checkSaveId == null));
    			//out.println("빈 문자열 ? " + checkSaveId.isEmpty());
    			
    			
    			/*
    				체크하면 아이디를 쿠키에 저장한다.
    				체크 안하면 아이디를 쿠키에서 삭제한다.
    			*/
    			
    			
    			if(checkSaveId != null){
    				Cookie cookie = new Cookie("userId", userId); // 저장할 값도 유저 아이디
    				cookie.setMaxAge(15 *24 * 60 * 60);
    				response.addCookie(cookie);
    			} else {
    				Cookie[] cookies = request.getCookies();
    				for(Cookie cookie : cookies){
    					if(cookie.getName().equals("userId")){
    						cookie.setMaxAge(0);
    						response.addCookie(cookie);
    						break;
    					}
    				}
    			}
    			
    			// 로그인 화면으로 되돌아가기
    			response.sendRedirect("06_saveIdA.jsp");
    			
    			
    			
    		
    		%>