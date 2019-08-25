package bankware.finlab.myworkchainserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "bankware.finlab.myworkchain.common")
public class MyworkchainserverApplication extends SpringBootServletInitializer {

//	@Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(MyworkchainserverApplication.class);
//    }
	public static void main(String[] args) {
		SpringApplication.run(MyworkchainserverApplication.class, args);
	}

}
