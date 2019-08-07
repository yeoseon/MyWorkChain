package bankware.finlab.myworkchainapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "BILLIONAIRES")
public class Billionaires {
	@Id
	private int id;
	private String firstName;
	private String lastName;
	private String career;
}
