package com.ez.rest.service;

import org.springframework.stereotype.Component;

import com.ez.rest.model.PageParserModel;
import com.ez.rest.model.SentimentAnalysisModel;

@Component
public class UrlServiceImpl implements UrlService {

	@Override
	public PageParserModel parsePage(String url) {
		return new PageParserModel("Page Title", "Page_Description", "Author");
	}

	@Override
	public SentimentAnalysisModel getSentiment(String url) {
		return new SentimentAnalysisModel("positive", "subjective", "0.999");
	}

}
