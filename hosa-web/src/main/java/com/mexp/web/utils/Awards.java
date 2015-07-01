package com.mexp.web.utils;

public class Awards {

	Long id;
	String name;
	Double probability;
	Boolean auto;
	
	public Awards() {
		this.id =-1L;
		this.name = "未中奖";
		this.probability = 1.0;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getProbability() {
		return probability;
	}
	public void setProbability(Double probability) {
		this.probability = probability;
	}

	public Boolean getAuto() {
		return auto;
	}

	public void setAuto(Boolean auto) {
		this.auto = auto;
	}
	
	
}
