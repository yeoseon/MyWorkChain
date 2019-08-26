package bankware.finlab.myworkchain.server.dto.restapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Setter;

@Setter
public class CheckStampInput {
	
	@JsonProperty
	private String _userId;
	
	@JsonProperty
	private String _yearMon;
	
	@JsonProperty
	private String _day;
	
	@JsonProperty
	private String _workCode;
	
	@JsonProperty
	private Integer _latitude;
	
	@JsonProperty
	private Integer _longitude;
	
	@JsonProperty
	private String _workPlace;
}
