package bankware.finlab.myworkchain.app.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WorkHistoryDto {
	private String userId;
	private Timestamp time;
	private int latitude;
	private int longitude;
	private String workPlaceCode;
}
