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
@Table(name = "work_place")
public class WorkPlaceEntity {
	
	@Id
	private int workCode;
	private String compAddress;
	private String workName;
	private String workAddress;
	private double workGeoLocation;
	private double workGeoLongitude;
	private double workGeoAltitude;
	private double workGeoAccuracy;
	private Boolean workUseYn;
}