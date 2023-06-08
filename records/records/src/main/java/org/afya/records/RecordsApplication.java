package org.afya.records;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
@RequiredArgsConstructor
public class RecordsApplication {
	public static void main(String[] args) {
		SpringApplication.run(RecordsApplication.class, args);
	}

}
