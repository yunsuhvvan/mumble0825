<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%
    
    	request.setCharacterEncoding("utf-8");
    	
    	String filename = request.getParameter("filename");
    	String realPath = application.getRealPath("storage");
    	// 서버에 저장 된 파일 (업로드 된 파일)
    	File file = new File(realPath, filename);
    	
    	
    	// 다운로드용 응답헤더를 작성한다.
    	response.setHeader("Content-Disposition", "attachment; filename="+filename);
    	response.setHeader("Content-Length", file.length()+"");    //바이트면 숫자인데 문자로 바꿔서 넣어야한다.
    	response.setHeader("Content-Type", "application/x-msdownload");
    	
    	// JSP 내장 출력 스트림 :  out 처리
    	
    	out.clear();
    	out = pageContext.pushBody();
    	
    	// 서버에 저장된 파일 입력 스트림으로 읽은 뒤
    	
    	BufferedInputStream bis = new BufferedInputStream(new FileInputStream("file"));
    	
    	//응답으로 보낼 파일 출력 스트림
    	BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream()); // 응답이니깐 response로 부터 받아야한다..?
    			
    	// 파일 크기만큼 메모리 확보하기
    	int filesize =  (int)file.length();
    	byte[] b = new byte[filesize];
    	
    	
    	// 서버에 저장된 파일 전체 읽기
    	
    	bis.read(b, 0, filesize);
    	
    	
    	// 배열 b의 내용을  bos로 보내기
    	bos.write(b, 0, filesize);
    	
    	if(bos != null){
    		bos.close();
    	}
    	if(bis != null){
    		bis.close();
    	}
    	
    	
    	
    	
    	
    	
    	
    
    %>