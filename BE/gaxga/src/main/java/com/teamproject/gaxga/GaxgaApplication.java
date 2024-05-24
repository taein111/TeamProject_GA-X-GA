package com.teamproject.gaxga;


import com.teamproject.gaxga.config.MvcConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@Import({MvcConfig.class})
@EnableJpaAuditing
@SpringBootApplication
@EnableScheduling
public class GaxgaApplication {
	public static void main(String[] args) {
		SpringApplication.run(GaxgaApplication.class, args);
	}
}
