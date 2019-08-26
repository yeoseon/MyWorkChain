package bankware.finlab.myworkchain.server.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Setter;

@Setter
public class RestRequestFrom {

	@JsonProperty(value="userKey")
	private String userKey;
	
	@JsonProperty(value="walletType")
	private String walletType;
	
}
