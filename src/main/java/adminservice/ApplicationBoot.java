package adminservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ApplicationBoot {
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationBoot.class, args);
	}
}
