package com.ez.rest.delegate;

import com.ez.rest.model.UrlRequest;
import com.ez.rest.model.UrlResponse;

public interface UrlDelegate {

	public UrlResponse postUrl(UrlRequest req);
	public UrlResponse getUrl(String url);
}
