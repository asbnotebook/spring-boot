package com.asb.example.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfig {

	private static final String RULES_ORDER_DISCOUNT_XLS = "rules/customer-rules.xlsx";
	private static final KieServices kieServices = KieServices.Factory.get();

	@Bean
	public KieContainer kieContainer() {
		Resource dt = ResourceFactory.newClassPathResource(RULES_ORDER_DISCOUNT_XLS, getClass());
		KieFileSystem kieFileSystem = kieServices.newKieFileSystem().write(dt);
		KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
		kieBuilder.buildAll();
		KieModule kieModule = kieBuilder.getKieModule();
		KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());
		return kieContainer;
	}
}
