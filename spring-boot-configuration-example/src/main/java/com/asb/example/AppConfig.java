package com.asb.example;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Configuration
@ConfigurationProperties("app")
@Validated
public class AppConfig {

	private List<String> props;
	private Map<String, String> prop;
	private MyConfig myConfig;
	
	@Getter
	@Setter
	@ToString
	public static class MyConfig {
		
		@NotNull
		String id;
		String description;
	}
	
	public List<String> getProps() {
		return props;
	}
	public void setProps(List<String> props) {
		this.props = props;
	}
	public Map<String, String> getProp() {
		return prop;
	}
	public void setProp(Map<String, String> prop) {
		this.prop = prop;
	}
	
	@Override
	public String toString() {
		return "AppConfig [props=" + props + ", prop=" + prop + ", myConfig=" + myConfig + "]";
	}
	public MyConfig getMyConfig() {
		return myConfig;
	}
	public void setMyConfig(MyConfig myConfig) {
		this.myConfig = myConfig;
	}
}
