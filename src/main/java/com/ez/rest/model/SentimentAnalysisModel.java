package com.ez.rest.model;

public class SentimentAnalysisModel {

	private String polarity;
	private String subjectivity;
	private String confidence;

	public SentimentAnalysisModel(String polarity, String subjectivity, String confidence) {
		this.polarity = polarity;
		this.subjectivity = subjectivity;
		this.confidence = confidence;
	}

	public String getPolarity() {
		return polarity;
	}

	public String getSubjectivity() {
		return subjectivity;
	}

	public String getConfidence() {
		return confidence;
	}

}