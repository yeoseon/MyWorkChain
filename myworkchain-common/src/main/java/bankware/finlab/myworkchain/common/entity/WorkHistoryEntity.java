package bankware.finlab.myworkchain.common.entity;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

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
	private String userId;
	@CreationTimestamp
	private LocalDate time;
	private String workCode;
	private int latitude;
	private int longitude;
	private String workPlaceCode;
	private int reward;
	
	@Builder
	public WorkHistoryEntity(int id, String userId, LocalDate time, String workCode, int latitude, int longitude, String workPlaceCode, int reward) {
		this.id = id;
		this.userId = userId;
		this.time = time;
		this.workCode = workCode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.workPlaceCode = workPlaceCode;
		this.reward = reward;
	}
}
