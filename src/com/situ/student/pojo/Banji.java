package com.situ.student.pojo;

import java.io.Serializable;
import java.util.List;

public class Banji implements Serializable {
	private String id;
	private String name;
	private Integer count;
	
	
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}



	public Banji(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Banji(String name, Integer count) {
		super();
		this.name = name;
		this.count = count;
	}

	public Banji(String id, String name, Integer count) {
		super();
		this.id = id;
		this.name = name;
		this.count = count;
	}

	public Banji() {
		super();
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

	@Override
	public String toString() {
		return "Banji [id=" + id + ", name=" + name + ", count=" + count + "]";
	}
	
	
}
