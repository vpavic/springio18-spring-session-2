package demo;

import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import custom.EnableCustomHttpSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
// TODO demo-custom-repo.1 - replace @EnableSpringHttpSession with @EnableCustomHttpSession
@EnableSpringHttpSession
//@EnableCustomHttpSession(maxInactiveIntervalInSeconds = 10)
@RestController
public class DemoCustomRepoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCustomRepoApplication.class, args);
	}

	@GetMapping(path = "/")
	public String home(HttpSession session) {
		return session.getId();
	}

	// TODO demo-custom-repo.1 - remove sessionRepository bean
	@Bean
	public MapSessionRepository sessionRepository() {
		return new MapSessionRepository(new ConcurrentHashMap<>());
	}

}
