package bankware.finlab.myworkchain.server.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Setter;

@Setter
public class RestRequest {

	@JsonProperty
	RestRequestFrom from;
	
	@JsonProperty
	RestRequestInput inputs;
	
}
