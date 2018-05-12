package com.ez.rest.dao;

import com.ez.rest.model.UrlResponse;

public interface UrlDao {

	public void persist(String url, UrlResponse urlResponse);

	public UrlResponse get(String url);

}
