package com.epam.mentoring.engteacher.persistence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entity Student.
 * 
 * @author Igor_Ariskin
 */
@Entity
@Table(name = "STUDENT")
public class Student {

	@SequenceGenerator(name = "student_id_seq", sequenceName = "student_id_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_seq")
	@Id
	@Column(name = "STUDENT_ID")
	private Long id;

	@Column(name = "FIRST_NAME", length = 200)
	private String firstName;

	@Column(name = "LAST_NAME", length = 200)
	private String lastName;

	@Column(name = "PATRONYMIC", length = 200)
	private String patronymic;

	@Column(name = "BIRTHDAY")
	private Date birthday;

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

}