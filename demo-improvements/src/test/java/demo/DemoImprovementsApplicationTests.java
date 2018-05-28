package demo;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoImprovementsApplicationTests {

	@Test
	public void contextLoads() {
	}

	@TestConfiguration
	@EnableSpringHttpSession
	static class Config {

		@Bean
		public MapSessionRepository sessionRepository() {
			return new MapSessionRepository(new ConcurrentHashMap<>());
		}

	}

}
