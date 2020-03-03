package com.model;
// Generated 27 f�vr. 2020 16:19:52 by Hibernate Tools 3.5.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dao.PersonDao;

/**
 * Person generated by hbm2java
 */
@ManagedBean
@Entity
@Table(name = "person", catalog = "user")
public class Person implements java.io.Serializable {

	private Integer id;
	private String name;
	private String country;

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public Person(String name, String country) {
		this.name = name;
		this.country = country;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "country", length = 20)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	public void save()
	{
	    PersonDao prDao=new PersonDao();
	    prDao.addPerson(this);
	}
	public void delete()
	{    
	   PersonDao prDao = new PersonDao();
	   prDao.deletePerson(id);
	}
	public List<Person> getbyid()
	{ 
	   PersonDao prDao = new PersonDao();
	    List<Person> pr=prDao.getbyID(id);
	    name=pr.get(0).name;
	    country=pr.get(0).country;
	    return pr;
	}
	public void update()
	{
	    PersonDao prDao=new PersonDao();
	    prDao.updatePerson(this);
	    
	}
	public List<Person> getallrecords()
	{
	  PersonDao prDao = new PersonDao();
	    List<Person> pr=prDao.retrievePerson();
	    return pr;
	}
	 
	 
	
	

}