package bankware.finlab.myworkchain.common.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "work_place")
public class WorkPlaceEntity {
	
	@Id
	private String workCode;
	private String compAddress;
	private String workName;
	private String workAddress;
	private float longitude;
	private float latitude;
	private Boolean workUseYn;
	
	@Builder
	public WorkPlaceEntity(String workCode, String compAddress, String workName, String workAddress, float longitude, float latitude, Boolean workUseYn) {
		this.workCode = workCode;
		this.compAddress = compAddress;
		this.workName = workName;
		this.workAddress = workAddress;
		this.longitude = longitude;
		this.latitude = latitude;
		this.workUseYn = workUseYn;
	}
	
} 
