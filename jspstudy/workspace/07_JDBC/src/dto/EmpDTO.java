package dto;

import java.sql.Date;

public class EmpDTO {
	
	private Long num;   // 사원번호 : emp_seq가 생성한다.
	private String name;// 사원이름
	private Date hire;  // 입사일자: SYSDATE  생성	
	
	public EmpDTO() {
		
	}
//	또한 DB에서 꺼낸 값을 DTO에서 임의로 조작할 필요가 없기 때문에 
//	DTO에는 Setter를 만들 필요가 없고 생성자에서 값을 할당한다.

	public EmpDTO(String name) {
		super();
		this.name = name;
	}


	public Long getNum() {
		return num;
	}


	public void setNum(Long num) {
		this.num = num;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getHire() {
		return hire; 
	}


	public void setHire(Date hire) {
		this.hire = hire;
	}
	
	
}
