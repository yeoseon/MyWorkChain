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
	
	// 로그인 아이디
	private String id;
	// 직원 이름
	private String name;
	// 부서`
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
	// 근무지명
	private String workPlaceName;
	// Wallet Address
	private String walletAddress;
	
	@Builder
	public Employee(String id, String name, String department, String position, String joinDate, String email, String phoneNumber, String workPlace, String workPlaceName, String walletAddress) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.position = position;
		this.joinDate = joinDate;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.workPlace = workPlace;
		this.workPlaceName = workPlaceName;
		this.walletAddress = walletAddress;
	}
}
