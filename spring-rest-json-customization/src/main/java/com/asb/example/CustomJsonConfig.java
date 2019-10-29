package com.asb.example;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Configuration
@EnableWebMvc
public class CustomJsonConfig implements WebMvcConfigurer {

	@Value("${dateformat.type}")
	private String test;

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

		ObjectMapper mapper = new Jackson2ObjectMapperBuilder()
				.propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
				.simpleDateFormat(test.equalsIgnoreCase("A") ? "MM/dd/yyyy" : "MM-dd-yyyy")
				.serializers(
						new LocalDateSerializer(test.equalsIgnoreCase("A") ? DateTimeFormatter.ofPattern("yyyy/MM/dd")
								: DateTimeFormatter.ofPattern("dd-MM-yyyy")),
						new LocalDateTimeSerializer(
								test.equalsIgnoreCase("A") ? DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")
										: DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")))
				.deserializers(
						new LocalDateDeserializer(test.equalsIgnoreCase("A") ? DateTimeFormatter.ofPattern("yyyy/MM/dd")
								: DateTimeFormatter.ofPattern("dd-MM-yyyy")),
						new LocalDateTimeDeserializer(
								test.equalsIgnoreCase("A") ? DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")
										: DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")))
				.build();

		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(mapper);
		converters.add(converter);
	}
}