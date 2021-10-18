package com.vamsi.sbs.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Topic Model")
public class Topic implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Id of the Topic", name = "id", required = true, value = "1")
	private Long id;
	@ApiModelProperty(notes = "Name of the Topic", name = "name", required = true, value = "Spring Boot")
	private String name;
	@ApiModelProperty(notes = "Description of the Topic", name = "description", required = true, value = "The king of frameworks")
	private String description;

	public Topic() {

	}

	public Topic(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
