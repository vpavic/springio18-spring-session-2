package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.context.WebSessionServerSecurityContextRepository;
import org.springframework.session.data.redis.config.annotation.web.server.EnableRedisWebSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.WebSession;
import org.springframework.web.server.session.HeaderWebSessionIdResolver;

@SpringBootApplication
// TODO demo-webflux.2 - remove EnableRedisWebSession
@EnableRedisWebSession
@RestController
public class DemoWebFluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoWebFluxApplication.class, args);
	}

	@GetMapping(path = "/")
	public String home(WebSession session) {
		return session.getId();
	}

	// TODO demo-webflux.1 - remove RedisConnectionFactory bean
	@Bean
	public LettuceConnectionFactory redisConnectionFactory() {
		return new LettuceConnectionFactory();
	}

	// TODO demo-webflux.3 - add HeaderWebSessionIdResolver
//	@Bean
//	public HeaderWebSessionIdResolver webSessionIdResolver() {
//		return new HeaderWebSessionIdResolver();
//	}
//
//	@Bean
//	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
//		return http
//				.authorizeExchange()
//					.anyExchange().authenticated()
//					.and()
//				.httpBasic()
//					.securityContextRepository(new WebSessionServerSecurityContextRepository())
//					.and()
//				.build();
//	}

}
