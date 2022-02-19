package com.example.spring.demo;

import com.example.spring.demo.controller.InputController;
import com.example.spring.demo.controller.OutputController;
import com.example.spring.demo.model.Input;
import com.example.spring.demo.model.Output;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner{
	private static final Logger log = LogManager.getLogger(Application.class);

	@Autowired
	InputController inputController;

	@Autowired
	OutputController outputController;
	@Autowired
	TrimString trimString;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {

		for(Input input : inputController.getAllInput()) {
			log.info("input_string: " + input.getInputString());
			Output output = trimString.processData(input.getInputString());

			outputController.save(output);
		}

	}
}
