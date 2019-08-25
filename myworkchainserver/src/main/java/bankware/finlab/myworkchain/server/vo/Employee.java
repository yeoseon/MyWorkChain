package bankware.finlab.myworkchain.server.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee {
	// 직원 이름
	private String name;
	// 부서
	private String department;
	// 직책
	private String position;
	// 입사일
	private String joinDate;
	// 이메일
	private String email;
	// 휴대전화
	private String phoneNumber;
	// 근무지 
	private String workPlace;
	// Wallet Address
	private String walletAddress;
	
	@Builder
	public Employee(String name, String department, String position, String joinDate, String email, String phoneNumber, String workPlace, String walletAddress) {
		this.name = name;
		this.department = department;
		this.position = position;
		this.joinDate = joinDate;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.workPlace = workPlace;
		this.walletAddress = walletAddress;
	}
}
