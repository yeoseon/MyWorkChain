package bankware.finlab.myworkchain.server.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Setter;

@Setter
public class RestRequestFrom {

	@JsonProperty(value="userKey")
	private String userKey;
	
	@JsonProperty(value="walletType")
	private String walletType;
	
}
