package com.example.spring.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "input_details")
public class Input {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column(name = "input_string")
	private String inputString;

	public Input(Integer id, String inputString) {
		this.id = id;
		this.inputString = inputString;
	}

	public Input() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInputString() {
		return inputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", inputString='" + inputString + '\'' +
				'}';
	}
}
