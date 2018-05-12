package com.ez.rest.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ez.rest.model.UrlResponse;

@Component
public class UrlDaoImpl implements UrlDao {

	private static Map<String, UrlResponse> urlMap = new HashMap<>();

	static {
		UrlResponse resp = new UrlResponse();
		resp.setPage_title("Google Home");
		resp.setDescription(" Googles page for search");
		resp.setAuthor("Author");
		resp.setPolarity("positive");
		resp.setSubjectivity("subjective");
		resp.setConfidence("0.9");
		urlMap.put("https://www.google.com", resp);
	}

	@Override
	public void persist(String url, UrlResponse urlResponse) {
		urlMap.put(url, urlResponse);
	}

	@Override
	public UrlResponse get(String url) {
		return urlMap.get(url);
	}

}
