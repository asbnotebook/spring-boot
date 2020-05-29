package com.asbnotebook;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCustomBannerExampleApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringBootCustomBannerExampleApplication.class);
//		application.setBanner((env, source, out) -> {
//			out.println("=============================");
//			out.print("ASB Notebook\n");
//			out.println("=============================");
//		});
		//application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}
}