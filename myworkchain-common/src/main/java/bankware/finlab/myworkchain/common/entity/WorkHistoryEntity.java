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
@Table(name = "work_history")
public class WorkHistoryEntity {
	
	@Id
	private int id;
	private String userAddress;
	private String workStartYmd;
	private String workendYmd;
	private String workStartTime;
	private String workEndTime;
}
