package bankware.finlab.myworkchain.server.dto.restapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Setter;

@Setter
public class RestRequestInput {

	@JsonProperty
	private String _userId;
	
	@JsonProperty
	private String _companyId;
	
	@JsonProperty
	private String _name;
	
	@JsonProperty
	private String _location;
	
	@JsonProperty
	private String _latitude;
	
	@JsonProperty
	private String _longitude;
	
	
}
