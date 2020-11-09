package br.com.gft.staffing;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class StaffingApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaffingApplication.class, args);
	}
	@Bean
	public FixedLocaleResolver localeResolver() {
		
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}
}
