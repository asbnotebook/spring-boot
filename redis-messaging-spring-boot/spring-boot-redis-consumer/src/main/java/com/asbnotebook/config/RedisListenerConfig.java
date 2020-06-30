package com.asbnotebook.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.asbnotebook.apiagent.StudentConsumer;
import com.asbnotebook.dto.Student;

@Configuration
public class RedisListenerConfig {

	@Value("${redis.student.topic}")
	private String studentTopic;

	@Bean
	public RedisMessageListenerContainer listenerContainer(MessageListenerAdapter listenerAdapter,
			RedisConnectionFactory connectionFactory) {
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.addMessageListener(listenerAdapter, new PatternTopic(studentTopic));
		return container;
	}

	@Bean
	public MessageListenerAdapter listenerAdapter(StudentConsumer consumer) {
		MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(consumer);
		messageListenerAdapter.setSerializer(new Jackson2JsonRedisSerializer<>(Student.class));
		return messageListenerAdapter;
	}

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
