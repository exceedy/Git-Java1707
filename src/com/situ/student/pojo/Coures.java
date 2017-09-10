package com.situ.student.pojo;

import java.io.Serializable;

public class Coures implements Serializable{
	private String id;
	private String name;
	private Integer grade;
	private String banjiName;
	
	
	
	
	public Coures(String name, Integer grade) {
		super();
		this.name = name;
		this.grade = grade;
	}





	public Coures(String name, String banjiName) {
		super();
		this.name = name;
		this.banjiName = banjiName;
	}


	
	public String getBanjiName() {
		return banjiName;
	}





	public void setBanjiName(String banjiName) {
		this.banjiName = banjiName;
	}





	public Coures(String id, String name, String banjiName) {
		super();
		this.id = id;
		this.name = name;
		this.banjiName = banjiName;
	}





	public Coures(String id, String name, Integer grade, String banjiName) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.banjiName = banjiName;
	}





	public Coures(String id, String name, Integer grade) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
	}





	public String getId() {
		return id;
	}





	public void setId(String id) {
		this.id = id;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public Integer getGrade() {
		return grade;
	}





	public void setGrade(Integer grade) {
		this.grade = grade;
	}





	@Override
	public String toString() {
		return "Coures [id=" + id + ", name=" + name + ", grade=" + grade + ", banjiName=" + banjiName + "]";
	}




	
	
}
