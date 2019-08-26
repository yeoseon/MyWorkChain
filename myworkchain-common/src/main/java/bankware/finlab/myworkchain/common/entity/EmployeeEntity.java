package bankware.finlab.myworkchain.common.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "employee")
public class EmployeeEntity {
	private String id;
	@Id
	private String emplAddress; //직원 Wallet 주소
	private String compAddress; //기업 Wallet 주소
	private String emplName;
	private int currentWorkCode; // 현재 근무지 코드
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
}
