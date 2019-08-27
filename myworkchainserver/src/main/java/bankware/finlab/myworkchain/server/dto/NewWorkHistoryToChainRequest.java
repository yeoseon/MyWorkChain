package bankware.finlab.myworkchain.server.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NewWorkHistoryToChainRequest {

	//로그인 아이디
	private String userId;
	
	//근무 구분 코드 (01: 출근, 02: 퇴근)
	private String workCode;
	
	//근무지 구분 코드 (01: 서울 본사, 02: 송도)
	private String workPlaceCode;
	
	//위도
	private BigDecimal latitude;
	
	//경도
	private BigDecimal longtitude;
	
	//system Date
	private Date date;
}
