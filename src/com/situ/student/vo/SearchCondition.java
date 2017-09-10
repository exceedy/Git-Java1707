package com.situ.student.vo;

import java.io.Serializable;

public class SearchCondition implements Serializable {
	private Integer pageIndex;
	private Integer pageSize;
	private String name;
	private String age;
	private String gender;
	private String birthday;
	private String address;
	private String banjiId;
	
	
	public SearchCondition(Integer pageIndex, Integer pageSize, String name, String age, String gender, String birthday,
			String address, String banjiId) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.banjiId = banjiId;
	}


	public SearchCondition(String name, String age, String gender, String birthday, String address) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
	}


	public String getBirthday() {
		return birthday;
	}


	public String getBanjiId() {
		return banjiId;
	}


	public void setBanjiId(String banjiId) {
		this.banjiId = banjiId;
	}


	public SearchCondition(Integer pageIndex, Integer pageSize, String name, String age, String gender, String birthday,
			String address) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
	}


	public Integer getPageIndex() {
		return pageIndex;
	}


	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}


	public Integer getPageSize() {
		return pageSize;
	}


	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public SearchCondition() {
		super();
	}


	public SearchCondition(String name, String age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "SearchCondition [pageIndex=" + pageIndex + ", pageSize=" + pageSize + ", name=" + name + ", age=" + age
				+ ", gender=" + gender + ", birthday=" + birthday + ", address=" + address + ", banjiId=" + banjiId
				+ "]";
	}
	

}
