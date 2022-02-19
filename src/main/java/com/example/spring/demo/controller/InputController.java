package com.example.spring.demo.controller;

import com.example.spring.demo.dao.InputDAO;
import com.example.spring.demo.model.Input;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InputController {
	private static final Logger log = LogManager.getLogger(InputController.class);

	@Autowired
	InputDAO inputDAO;

	@GetMapping("/get_from_input")
	public List<Input> getAllInput(){
		return inputDAO.findAll();
	}


	@PostMapping("/save_in_input")
	public Input save(@RequestBody Input inputObj) {
		return inputDAO.save(inputObj);
	}





}
