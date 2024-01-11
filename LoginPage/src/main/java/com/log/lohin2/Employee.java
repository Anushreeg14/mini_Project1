package com.log.lohin2;

public class Employee {
int id;
String name; //Employee e= nww Wmp() e.id()
int salary;
String domain;
String username;
String password;
public Employee(int id,String name, int salary, String domain) {
	this.id=id;
	this.name = name;
	this.salary = salary;
	this.domain = domain;
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
public String getDomain() {
	return domain;
}
public void setDomain(String domain) {
	this.domain = domain;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
