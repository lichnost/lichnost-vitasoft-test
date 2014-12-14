package com.semenov.test.vitasoft.model;

import java.util.Date;

public class Driver {

	private int id;
	private String firstName;
	private String secondName;
	private String middleName;
	private Date birthday;
	private Gender gender;
	private DriverClass driverClass;

	public Driver() {
	}

	public Driver(int id, String secondName, String firstName,
			String middleName, Date birthday, Gender gender,
			DriverClass driverClass) {
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.middleName = middleName;
		this.birthday = birthday;
		this.gender = gender;
		this.driverClass = driverClass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public DriverClass getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(DriverClass driverClass) {
		this.driverClass = driverClass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Driver other = (Driver) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
