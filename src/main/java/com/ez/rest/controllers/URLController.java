package com.ez.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ez.rest.delegate.UrlDelegate;
import com.ez.rest.model.UrlRequest;
import com.ez.rest.model.UrlResponse;
import com.ez.rest.utils.UrlUtilities;

@RestController("restController")
@RequestMapping("/ez/rest")
public class URLController {

	private static final String POST_URL = "/postUrl";
	private static final String GET_URL = "/getUrl";

	@Autowired
	UrlDelegate urlDelegate;
	@Autowired
	UrlUtilities urlUtilities;

	@RequestMapping(value = POST_URL, method = {
			RequestMethod.POST }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UrlResponse postUrl(@RequestBody UrlRequest req) {

		// Form Validation
		UrlResponse errorResponse = urlUtilities.validatePostUrlReq(req);
		if (errorResponse != null) {
			return errorResponse;
		}
		return urlDelegate.postUrl(req);
	}

	@RequestMapping(value = GET_URL, method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	public UrlResponse getUrl(@RequestParam String url) {

		// Form Validation
		UrlResponse errorResponse = urlUtilities.validateGetUrlReq(url);
		if (errorResponse != null) {
			return errorResponse;
		}
		return urlDelegate.getUrl(url);
	}
}
