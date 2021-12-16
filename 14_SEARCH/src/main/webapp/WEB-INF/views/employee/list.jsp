<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

</head>
<body>

		<!--  
			컬럼의 선택에 따라서 쿼리문이 달라져야한다.(동적쿼리가 필요 = if,foreach,,,)
		
				EMPLOYEE_ID = 1% 숫자는 만능문자 X
				FIRST_NAME  대소문자 텍스트 무시해서 가능하게
				HIRE_DATE    ~이전 ~이후
				SALARY		언제부터 언제까지
		 -->
		
		<table border="1">
			<thead>
				<tr>
					<td>NO</td>
					<td>EMPLOYEE_ID</td>
					<td>FIRST_NAME</td>
					<td>LAST_NAME</td>
					<td>HIRE_DATE</td>
					<td>SALARY</td>
					<td>DEPARTMENT_ID</td>
					<td>DEPARTMENT_NAME</td>
					<td>LOCATION_ID</td>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty list}">
					<tr>
						<td colspan="9">검색 결과 없음</td>
					</tr>
				</c:if>
				<c:if test="${not empty list}">
					<c:forEach var="employee" items="${list}" varStatus="vs">
						<tr>
							<td>${startNum - vs.index}</td>
							<td>${employee.employeeId}</td>
							<td>${employee.firstName}</td>
							<td>${employee.lastName}</td>
							<td>${employee.hireDate}</td>
							<td>${employee.salary}</td>
							<td>${employee.department.departmentId}</td>
							<td>${employee.department.departmentName}</td>
							<td>${employee.department.locationId}</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		<c:if test="${not empty paging}">
			<tfoot>
				<tr>
					<td colspan="9">${paging}</td>
				</tr>
			</tfoot>
		</c:if>
	</table>

</body>
</html>