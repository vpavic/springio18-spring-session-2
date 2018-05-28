package demo;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.session.ReactiveMapSessionRepository;
import org.springframework.session.config.annotation.web.server.EnableSpringWebSession;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoWebFluxApplicationTests {

	@Test
	public void contextLoads() {
	}

	@TestConfiguration
	@EnableSpringWebSession
	static class Config {

		@Bean
		public ReactiveMapSessionRepository sessionRepository() {
			return new ReactiveMapSessionRepository(new ConcurrentHashMap<>());
		}

	}

}
