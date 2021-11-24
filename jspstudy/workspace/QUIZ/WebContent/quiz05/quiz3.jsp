<%@page import="java.io.FileWriter"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
	 request.setCharacterEncoding("utf-8");
	String agree =request.getParameter("agree");
	
	if(agree.equals("yes")){ 
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		String filename = id +".txt";
		//String realPath = request.getServletContext().getRealPath("storage");
		String realPath = request.getServletContext().getRealPath("storage"); //흠..
		File dir = new File(realPath);
		if(dir.exists() == false){
			dir.mkdirs();
		}
		
		File file = new File(dir, filename);
		BufferedWriter bw = new BufferedWriter(new FileWriter(file)); //io 부분은 쓰고 또 쓰고 반복해보자..!
		bw.write("가입 아이디 : " +id);
		bw.write("가입 비밀번호 : " +password);
		bw.write("가입 이름 : " +name);
		
		bw.flush();
		if(bw!=null){
			bw.close();
		}
		
		response.sendRedirect("quiz4.jsp?filename=" + filename);
	}else{
		
		
		
		
		
		
		
		
		
	}
	
	%>

</body>
</html>