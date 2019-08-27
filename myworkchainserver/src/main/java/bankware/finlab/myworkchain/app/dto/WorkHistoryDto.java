package bankware.finlab.myworkchain.app.dto;

import java.math.BigDecimal;
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
	private BigDecimal latitude;
	private BigDecimal longitude;
	private String workPlaceCode;
}
