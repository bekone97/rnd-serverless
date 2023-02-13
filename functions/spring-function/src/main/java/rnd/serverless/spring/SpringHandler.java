package rnd.serverless.spring;

import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import rnd.serverless.Handler;

@SpringBootApplication
public class SpringHandler {

	private final static Handler HANDLER = new Handler();
	public static void main(String[] args) {
		SpringApplication.run(SpringHandler.class, args);
	}
	
	@Bean
	public Supplier<String> handle() {
		return HANDLER::handleRequest;
	}
}
