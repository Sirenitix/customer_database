package com.suleevn.springboot.web;

import com.suleevn.springboot.web.database.database;
import com.suleevn.springboot.web.service.TodoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootFirstWebApplication {

		static {
			database.main(null);
		}


	public static void main(String[] args) {
		SpringApplication.run(SpringBootFirstWebApplication.class, args);
	}

	static {
		TodoService.main(null);
	}
}

