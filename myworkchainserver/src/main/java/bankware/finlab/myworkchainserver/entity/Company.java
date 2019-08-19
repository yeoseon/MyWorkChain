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
@Table(name = "COMPANY")
public class Company {
	
	@Id
	private String compAddress;
	private String mwcAddress;
	private String compName;
	private String location;
}

