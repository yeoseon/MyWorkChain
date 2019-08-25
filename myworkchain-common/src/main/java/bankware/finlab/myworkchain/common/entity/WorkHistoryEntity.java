package bankware.finlab.myworkchain.common.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "work_history")
public class WorkHistoryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String userAddress;
	private String workStartYmd;
	private String workEndYmd;
	private String workStartTime;
	private String workEndTime;
	
	@Builder
	public WorkHistoryEntity(int id, String userAddress, String workStartYmd, String workEndYmd, String workStartTime, String workEndTime) {
		this.id = id;
		this.userAddress = userAddress;
		this.workStartYmd = workStartYmd;
		this.workEndYmd = workEndYmd;
		this.workStartTime = workStartTime;
		this.workEndTime = workEndTime;
	}
}
