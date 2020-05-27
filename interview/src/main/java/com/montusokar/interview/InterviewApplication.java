package com.montusokar.interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.montusokar.interview.templates.RestTemplateConfig;

@SpringBootApplication
@Import({ RestTemplateConfig.class })
public class InterviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewApplication.class, args);
	}

}
