package com.asbnotebook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.asbnotebook.dto.Student;

@Configuration
public class RedisProducerConfig {

	@Bean
	RedisTemplate<String, Student> redisTemplate(RedisConnectionFactory connectionFactory,
			Jackson2JsonRedisSerializer<Student> serializer) {
		RedisTemplate<String, Student> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(connectionFactory);
		redisTemplate.setDefaultSerializer(serializer);
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}

	@Bean
	public Jackson2JsonRedisSerializer<Student> jackson2JsonRedisSerializer() {
		return new Jackson2JsonRedisSerializer<>(Student.class);
	}
}
