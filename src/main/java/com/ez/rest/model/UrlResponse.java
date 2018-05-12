package com.ez.rest.model;

public class UrlResponse {

	private String errorCode;
	private String errorMessage;
	private String author;
	private String polarity;
	private String subjectivity;
	private String confidence;

	private String page_title;
	private String description;
	private String message;

	public String getPage_title() {
		return page_title;
	}

	public void setPage_title(String page_title) {
		this.page_title = page_title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPolarity() {
		return polarity;
	}

	public void setPolarity(String polarity) {
		this.polarity = polarity;
	}

	public String getSubjectivity() {
		return subjectivity;
	}

	public void setSubjectivity(String subjectivity) {
		this.subjectivity = subjectivity;
	}

	public String getConfidence() {
		return confidence;
	}

	public void setConfidence(String confidence) {
		this.confidence = confidence;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
