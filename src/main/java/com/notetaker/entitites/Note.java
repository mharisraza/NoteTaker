package com.notetaker.entitites;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="notes")
public class Note {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int user_id;
	private String title;
	@Column(length=500000000)
	private String content;
	@Temporal(TemporalType.DATE)
	private Date addedDate;
    
	
	
	 // Constructors
	
	

	

	public Note(int user_id, String title, String content, Date addedDate) {
		super();
		this.user_id = user_id;
		this.title = title;
		this.content = content;
		this.addedDate = addedDate;
	}


	public Note(String title, String content, Date addedDate) {
		super();
		this.title = title;
		this.content = content;
		this.addedDate = addedDate;
	}


	public Note(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}


	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}

    // Getters and Setters
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getAddedDate() {
		return addedDate;
	}


	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}





	public int getUser_id() {
		return user_id;
	}





	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	
}
