package demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.SpringSessionRedisConnectionFactory;

// TODO demo-improvements.2 - enable custom Redis config
//@Configuration
public class RedisConfiguration {

	@Bean
	// TODO demo-improvements.3 - define primary RedisConnectionFactory
//	@Primary
	public LettuceConnectionFactory redisConnectionFactoryOne() {
		return new LettuceConnectionFactory(new RedisStandaloneConfiguration("localhost", 6379));
	}

	@Bean
	// TODO demo-improvements.4 - define Spring Session RedisConnectionFactory
//	@SpringSessionRedisConnectionFactory
	public LettuceConnectionFactory redisConnectionFactoryTwo() {
		return new LettuceConnectionFactory(new RedisStandaloneConfiguration("localhost", 6378));
	}

}
