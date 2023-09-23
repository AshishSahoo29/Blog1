package com.example.Blog1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "blog")
public class Blog {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "blogName",nullable= false)
	private String blogName;
	
	@Column(name = "description",nullable= false)
	private String description;
	
	@Column(name = "date",nullable= false)
	private String date;
	
	//generate getter and setter methods for fields
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", blogName=" + blogName + ", description=" + description + ", date=" + date + "]";
	}
	
	
	
	
	

}
