package design.boilerplate.springboot;

import design.boilerplate.springboot.model.User;
import design.boilerplate.springboot.model.UserRole;
import design.boilerplate.springboot.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableMongoRepositories
//@EnableAspectJAutoProxy
public class SpringBootBoilerplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBoilerplateApplication.class, args);
    }




    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
/*
@EnableAspectJAutoProxy
public class SpringBootBoilerplateApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootBoilerplateApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
*/

