package bankware.finlab.myworkchain.app.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WorkHistoryDto {
	private String userId;
	private LocalDateTime time;
	private int latitude;
	private int longitude;
	private String workPlaceCode;
}
