package com.ez.rest.service;

import com.ez.rest.model.PageParserModel;
import com.ez.rest.model.SentimentAnalysisModel;

public interface UrlService {

	public PageParserModel parsePage(String url);

	public SentimentAnalysisModel getSentiment(String url);

}
