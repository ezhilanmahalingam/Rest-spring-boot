package com.ez.rest.tasks;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ez.rest.model.SentimentAnalysisModel;
import com.ez.rest.service.UrlService;

@Component
public class SentimentAnalysisTask implements Callable<SentimentAnalysisModel> {

	@Autowired
	UrlService urlService;

	private String url;

	public void setValue(String url) {
		this.url = url;
	}

	@Override
	public SentimentAnalysisModel call() throws Exception {
		return urlService.getSentiment(url);
	}

}