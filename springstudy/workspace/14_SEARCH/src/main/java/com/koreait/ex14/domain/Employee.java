package com.koreait.ex14.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor  		//디폴트 생성자
@AllArgsConstructor 		// 필드를 이용한 생성자
@ToString
@Builder

public class Employee {

	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private int salary;
	private double commissionPct;
	private int managerId;
	private int departmentId;
	
	private Department department;
	
	
	
}
