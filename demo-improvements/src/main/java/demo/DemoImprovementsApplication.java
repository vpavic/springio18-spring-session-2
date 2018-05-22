package demo;

import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.session.data.redis.config.annotation.SpringSessionRedisOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoImprovementsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoImprovementsApplication.class, args);
	}

	@GetMapping(path = "/")
	public String home(HttpSession session) {
		return session.getId();
	}

	// TODO 5 - use Spring Session RedisConnectionFactory
//	@SpringSessionRedisOperations
//	private RedisOperations<Object, Object> springSessionRedisOperations;
//
//	@GetMapping(path = "/keys")
//	public String keys() {
//		return this.springSessionRedisOperations.keys("*").stream()
//				.map(Object::toString).collect(Collectors.joining("\n"));
//	}

}
