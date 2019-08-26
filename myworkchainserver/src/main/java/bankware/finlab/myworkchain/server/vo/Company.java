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
public class Company {

	//기업의 Wallet Address
	private String compAddress;
	
	//기업명
	private String name;
	
	//기업의 주소(위치)
	private String address;
	
	//기업의 사용 여부
	private Boolean useYn;
	
	@Builder
	public Company(String compAddress, String name, String address, Boolean useYn) {
		this.compAddress = compAddress;
		this.name = name;
		this.address = address;
		this.useYn = useYn;
	}
}
