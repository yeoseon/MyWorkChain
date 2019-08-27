package bankware.finlab.myworkchain.app.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WorkHistoryDto {
	private String userId;
	private Date time;
	private int latitude;
	private int longitude;
	private String workPlaceCode;
}
