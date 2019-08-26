package bankware.finlab.myworkchain.server.vo;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Setter;

@Setter
public class RestRequestInput {

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
	
	@JsonProperty
	private Map<String, Object> _userId;
}
