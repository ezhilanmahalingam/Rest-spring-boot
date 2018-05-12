package com.ez.rest.delegate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ez.rest.dao.UrlDao;
import com.ez.rest.model.PageParserModel;
import com.ez.rest.model.SentimentAnalysisModel;
import com.ez.rest.model.UrlRequest;
import com.ez.rest.model.UrlResponse;
import com.ez.rest.tasks.PageParserTask;
import com.ez.rest.tasks.SentimentAnalysisTask;

@Component
public class UrlDelegateImpl implements UrlDelegate {

	// @Autowired
	// private UrlUtilities urlUtilities;

	@Autowired
	private UrlDao urlDao;

	@Autowired
	private PageParserTask pageParserTask;

	@Autowired
	private SentimentAnalysisTask sentimentAnalysisTask;

	private final ExecutorService service = Executors.newFixedThreadPool(1000);

	@Override
	public UrlResponse postUrl(UrlRequest req) {

		UrlResponse urlResponse = null;

		// Check if the callBack URL is not empty
		// if(!StringUtils.isEmpty(req.getCallbackUrl())){
		// urlResponse = new UrlResponse();
		// urlResponse.setMessage(" We will process and post you back");
		// }

		// Runnable r = new Runnable(){

		// @Override
		// public void run() {
		PageParserModel pageParserModel = null;
		SentimentAnalysisModel sentimentAnalysisModel = null;
		String url = req.getUrl();

		// 1.Call Page parser.
		pageParserTask.setValue(url);
		Future<PageParserModel> pageParserFuture = service.submit(pageParserTask);

		// 2.Call Sentiment analysis
		sentimentAnalysisTask.setValue(url);
		Future<SentimentAnalysisModel> sentimentAnalysisFuture = service.submit(sentimentAnalysisTask);

		try {
			pageParserModel = pageParserFuture.get();
			sentimentAnalysisModel = sentimentAnalysisFuture.get();
		} catch (Exception e) {
			// return error
		}

		urlResponse = getUrlResponseObj(pageParserModel, sentimentAnalysisModel);

		// 3.Store to DB
		urlDao.persist(url, urlResponse);
		// 4. Return the response to call

		/*
		 * System.out.println(" Delegate IMPL"); String fileName =
		 * "pageData.json"; UrlResponse resp =
		 * urlUtilities.convertJSONFiletoObject(fileName, UrlResponse.class);
		 */

		// }

		// };

		// r.run();

		return urlResponse;
	}

	public UrlResponse postToUserBack() {
		// code to post the user
		return null;
	}

	/**
	 * Function to set the Url Response properties & return the obj
	 * 
	 * @param pageParser
	 * @param sentiment
	 * @return UrlResponse
	 */
	private UrlResponse getUrlResponseObj(PageParserModel pageParser, SentimentAnalysisModel sentiment) {
		UrlResponse urlResponse = new UrlResponse();

		urlResponse.setPage_title(pageParser.getPageTitle());
		urlResponse.setDescription(pageParser.getPageDescription());
		urlResponse.setAuthor(pageParser.getAuthor());
		urlResponse.setPolarity(sentiment.getPolarity());

		urlResponse.setSubjectivity(sentiment.getSubjectivity());
		urlResponse.setConfidence(sentiment.getConfidence());

		return urlResponse;
	}

	@Override
	public UrlResponse getUrl(String url) {
		return urlDao.get(url);
	}

}
