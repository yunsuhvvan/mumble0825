<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%-- 엑셀의 숫자 형식 표현법과 같다. --%>
	<c:set var="n" value="12345.6789"/>
	
	<div><fmt:formatNumber value="${n}" pattern="#,##0"></fmt:formatNumber></div>
	<div><fmt:formatNumber value="${n}" pattern="#,##0.0"></fmt:formatNumber></div>
	<div><fmt:formatNumber value="${n}" pattern="#,##0.00"></fmt:formatNumber></div>

<hr>
	<div><fmt:formatNumber value="${n}" pattern="0"></fmt:formatNumber></div>
	<div><fmt:formatNumber value="${n}" pattern="0.0"></fmt:formatNumber></div>
	<div><fmt:formatNumber value="${n}" pattern="0.00"></fmt:formatNumber></div>
	
	<hr>
	<div><fmt:formatNumber value="${n}" type="currency"/></div>
	<div><fmt:formatNumber value="${n}" type="currency" currencySymbol="$"/></div>
	<div><fmt:formatNumber value="${n}" type="percent"/></div>
	


</body>
</html>