package br.com.gft.staffing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class StaffingApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaffingApplication.class, args);
	}

}
