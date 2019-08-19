package bankware.finlab.myworkchainserver.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	@Id
	private String emplAddress; //직원 Wallet 주소
	private String compAddress; //기업 Wallet 주소
	private String emplName;
	private int currentWorkCode; // 현재 근무지 코드
}
