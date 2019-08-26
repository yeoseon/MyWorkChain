package bankware.finlab.myworkchain.server.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class RestResponse {

	@JsonProperty(value="result")
	Boolean result;
	
	@JsonProperty(value="data")
	RestResponseData data;
}
