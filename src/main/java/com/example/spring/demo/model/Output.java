package com.example.spring.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "abdulqadir_ansari_java_output")
public class Output {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column(name = "count")
	private int count;

	@Column(name = "name")
	private String name;

	@Column(name = "output")
	private String output;

	@Column(name = "published_on")
	private Date publishedOn;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public Date getPublishedOn() {
		return publishedOn;
	}

	public void setPublishedOn(Date publishedOn) {
		this.publishedOn = publishedOn;
	}

	public Output(Integer id, int count, String name, String output, Date publishedOn) {
		this.id = id;
		this.count = count;
		this.name = name;
		this.output = output;
		this.publishedOn = publishedOn;
	}

	public Output() {
	}

	@Override
	public String toString() {
		return "Output{" +
				"id=" + id +
				", count=" + count +
				", name='" + name + '\'' +
				", output='" + output + '\'' +
				", publishedOn=" + publishedOn +
				'}';
	}
}
