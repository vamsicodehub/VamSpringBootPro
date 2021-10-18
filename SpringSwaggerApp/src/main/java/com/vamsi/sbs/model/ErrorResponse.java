package com.vamsi.sbs.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Error Response Model")
public class ErrorResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Error Code", name = "code", value = "401")
	private int code;
	@ApiModelProperty(notes = "Status", name = "status", value = "SUCCESS")
	private String status;
	@ApiModelProperty(notes = "Message", name = "message", value = "Invalid Field")
	private String message;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
