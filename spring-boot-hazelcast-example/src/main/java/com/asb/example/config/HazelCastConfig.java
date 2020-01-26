package com.asb.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.config.MaxSizeConfig.MaxSizePolicy;

@Configuration
public class HazelCastConfig {

	@Bean
	public Config config() {
		return new Config()
				.setInstanceName("hazelcast-instance")
				.addMapConfig(new MapConfig()
						.setName("employeeCache")
						.setMaxSizeConfig(new MaxSizeConfig()
								.setSize(200)
								.setMaxSizePolicy(MaxSizePolicy.FREE_HEAP_SIZE))
						.setEvictionPolicy(EvictionPolicy.LRU)
						.setTimeToLiveSeconds(300));
	}
}
