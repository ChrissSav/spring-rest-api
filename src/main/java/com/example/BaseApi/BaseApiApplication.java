package com.example.BaseApi;

import com.example.BaseApi.config.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Import(SwaggerConfiguration.class)
public class BaseApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseApiApplication.class, args);
	}

}
