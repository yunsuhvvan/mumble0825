<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
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
	 
	 //quiz3에서 파일을 생성하고 
	 // quiz4에서는 브라우저에 생성한 파일을 읽어서 출력
	 	request.setCharacterEncoding("utf-8");
	 	
	 	String filename = request.getParameter("filename");
	 	String realPath = request.getParameter("realPath");
	 	
	 	File file = new File (realPath, filename);
	 	BufferedReader br = new BufferedReader(new FileReader(file));
		StringBuffer sb = new StringBuffer();
	 	String temp = "";
		// 
		while((temp = br.readLine()) != null){
			sb.append(temp);   //String이 Stringbuffer로 형변환이 안되서 append메서드 사용
		}
		if(br != null){
			br.close();
		}  //왜 안되지
	 		
	 %>
	 
	 <h3>가입되었습니다.</h3>
	 <h5>가입내용</h5>
	 <%=sb%>
	 
	 <br>
	 <br>
	 
	 
	 
	 
	

</body>
</html>