package com.ez.rest.model;

public class PageParserModel {

	private String pageTitle;
	private String pageDescription;
	private String author;

	public PageParserModel(String title, String desc, String auth) {
		pageTitle = title;
		pageDescription = desc;
		author = auth;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public String getPageDescription() {
		return pageDescription;
	}

	public String getAuthor() {
		return author;
	}

}
