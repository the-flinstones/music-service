package com.flinstone.musicservice;

import com.datastax.oss.driver.api.core.config.DefaultDriverOption;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.DriverConfigLoaderBuilderCustomizer;
import org.springframework.context.annotation.Bean;

import java.time.Duration;


@SpringBootApplication
public class MusicServiceApplication {
//	@Bean
//	DriverConfigLoaderBuilderCustomizer cassandraDriverCustomizer() {
//		return (builder) -> builder.withDuration(
//				DefaultDriverOption.CONTROL_CONNECTION_TIMEOUT, Duration.ofSeconds(10));
//	}

	public static void main(String[] args) {
		SpringApplication.run(MusicServiceApplication.class, args);
	}

}
