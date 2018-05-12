package com.ez.rest.utils;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.ez.rest.model.UrlRequest;
import com.ez.rest.model.UrlResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class UrlUtilities {

	private static final ObjectMapper objectMapper = new ObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(UrlUtilities.class);

	public UrlResponse validatePostUrlReq(UrlRequest req) {
		return StringUtils.isEmpty(req.getUrl()) ? getURLMissingError() : null;
	}

	public UrlResponse validateGetUrlReq(String url) {
		return StringUtils.isEmpty(url) ? getURLMissingError() : null;
	}

	private UrlResponse getURLMissingError() {
		UrlResponse errorResp = new UrlResponse();
		errorResp.setErrorCode("URL_Missing");
		errorResp.setErrorMessage("URL is mandatory to process your request");
		return errorResp;
	}

	/**
	 * FileName - file should be in JSON format, placed in src/main/resources
	 * 
	 * @param fileName
	 * @param toClassName
	 * @return Object of Class T
	 */
	public <T> T convertJSONFiletoObject(String fileName, Class<T> toClassName) {

		String inputStreamString = null;
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
		try {
			inputStreamString = IOUtils.toString(inputStream);
		} catch (Exception e1) {
			LOG.error("Error reading file {} with error {}", fileName, e1.getMessage());
		}

		T t = null;
		try {
			t = toClassName.cast(objectMapper.readValue(inputStreamString, toClassName));
		} catch (Exception e) {
			LOG.error("Error parsing JSON file with error {}", e.getMessage());
		}

		return t;
	}
}
