package bankware.finlab.myworkchain.server.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkPlace {

	private String workCode;
	private String compAddress;
	private String workName;
	private String workAddress;
	private float longitude;
	private float latitude;
	private Boolean workUseYn;
	
	@Builder
	public WorkPlace(String workCode, String compAddress, String workName, String workAddress, float longitude, float latitude, Boolean workUseYn) {
		this.workCode = workCode;
		this.compAddress = compAddress;
		this.workName = workName;
		this.workAddress = workAddress;
		this.longitude = longitude;
		this.latitude = latitude;
		this.workUseYn = workUseYn;
	}
	
}
