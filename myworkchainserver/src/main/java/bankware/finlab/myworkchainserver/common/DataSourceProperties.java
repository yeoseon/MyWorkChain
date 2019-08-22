package bankware.finlab.myworkchainserver.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties
@PropertySource("classpath:datasource.properties")
public class DataSourceProperties {
}


//@Data
//@Configuration
//@ConfigurationProperties
//@PropertySource({
//	"classpath:application-entertainment.properties"
//	, "classpath:application-entertainment-${spring.profiles.active:test}.properties"
//})
//public class EntertainmentProperties {
//	private Youtube youtube;
//	private Dj dj;
//	private Slack slack;
//	
//	@Data
//	public static class Youtube {
//		private String apiKey;
//	}
//	
//	@Data
//	public static class Dj{
//		private String amHour;
//		private String amMinute;
//		private String amSecond;
//		private String pmHour;
//		private String pmMinute;
//		private String pmSecond;
//	}
//	
//	@Data
//	public static class Slack {
//		private String url;
//		private String channel;
//		private String barColorMain;
//		private String barColorSub;
//		private String username;
//		private String iconEmoji;
//	}
//}
