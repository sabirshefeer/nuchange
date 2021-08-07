package com.nuchange.assessment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;

@Entity
@Table(name="urldata")
public class UrlData {
	
	@Id
	@Column(name ="short_key")
	private String shortkey;
	
	@Column(name="url")
	private String url;
	@Column(name="count")
	private int count;

	
	
	public String getShortkey() {
		return shortkey;
	}
	public void setShortkey(String shortkey) {
		this.shortkey = shortkey;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	

}
