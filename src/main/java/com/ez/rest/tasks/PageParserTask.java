package com.ez.rest.tasks;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ez.rest.model.PageParserModel;
import com.ez.rest.service.UrlService;

@Component
public class PageParserTask implements Callable<PageParserModel> {

	@Autowired
	UrlService urlService;

	private String url;

	public void setValue(String url) {
		this.url = url;
	}

	@Override
	public PageParserModel call() throws Exception {
		return urlService.parsePage(url);
	}

}