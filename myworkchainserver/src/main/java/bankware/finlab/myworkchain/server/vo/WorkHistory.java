package bankware.finlab.myworkchain.server.vo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class WorkHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String userAddress;
	private String workStartYmd;
	private String workEndYmd;
	private String workStartTime;
	private String workEndTime;
	
	@Builder
	public WorkHistory(int id, String userAddress, String workStartYmd, String workEndYmd, String workStartTime, String workEndTime) {
		this.id = id;
		this.userAddress = userAddress;
		this.workStartYmd = workStartYmd;
		this.workEndYmd = workEndYmd;
		this.workStartTime = workStartTime;
		this.workEndTime = workEndTime;
	}
}
