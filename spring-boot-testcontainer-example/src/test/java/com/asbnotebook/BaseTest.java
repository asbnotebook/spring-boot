package com.asbnotebook;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
abstract class BaseTest {

	private static final Integer PORT = 5432;
	private static final String DB_USER = "test";
	private static final String DB_PASSWORD = "test";

	@Container
	private static final PostgreSQLContainer<?> postgresContainer =
			new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"))
					.withExposedPorts(PORT)
					.withUsername(DB_USER)
					.withPassword(DB_PASSWORD)
					.withClasspathResourceMapping("init.sql",
							"/docker-entrypoint-initdb.d/init.sql",
							BindMode.READ_ONLY);

	@DynamicPropertySource
	static void postgresProperties(DynamicPropertyRegistry registry){
		postgresContainer.start();
		registry.add("spring.datasource.url", BaseTest::getFormattedConnectionString);
		registry.add("spring.datasource.username", ()-> DB_USER);
		registry.add("spring.datasource.password", ()-> DB_PASSWORD);
	}

	private static String getFormattedConnectionString() {
		return String.format("jdbc:postgresql://%s:%s/employeedb",
				postgresContainer.getHost(),
				postgresContainer.getFirstMappedPort());
	}
}
