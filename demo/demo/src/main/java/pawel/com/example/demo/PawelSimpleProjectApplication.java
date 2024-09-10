package pawel.com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class PawelSimpleProjectApplication {

	public static void main(String[] args) {

		try {
			SpringApplication.run(PawelSimpleProjectApplication.class, args);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	@Bean
	public Validator validator() {
		return new LocalValidatorFactoryBean();
	}
}
