package com.tomato.sales.domain;

import java.util.Date;
import java.util.UUID;

public class Tomato {

	private UUID id;
	private int tomatoes;
	private String provider;
	private Date timestamp;

	public Tomato(){}

	public Tomato(UUID id, int tomatoes, String provider, Date timestamp) {
		this.id = id;
		this.tomatoes = tomatoes;
		this.provider = provider;
		this.timestamp = timestamp;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public int getTomatoes() {
		return tomatoes;
	}

	public void setTomatoes(int tomatoes) {
		this.tomatoes = tomatoes;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
