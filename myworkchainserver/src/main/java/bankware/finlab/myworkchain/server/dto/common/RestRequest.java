package bankware.finlab.myworkchain.server.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Setter;

@Setter
public class RestRequest {

	@JsonProperty
	RestRequestFrom from;
	
	@JsonProperty
	RestRequestInput inputs;
	
}
