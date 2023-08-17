package com.pg;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PGserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PGserviceApplication.class, args);
	}

	// Configure ModelMapper bean in Spring boot application class(since this class
		// is
		// implicitly annotated with @Configuration)
		// Meaning -You can add @Bean methods ONLY in such config classes
		@Bean
		public ModelMapper modelMapper() {
			ModelMapper mapper = new ModelMapper();
			//Strict mode => While mapping ,src prop names n data types MUST with dest type must match with dest types
			mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			return mapper;
		}

}
