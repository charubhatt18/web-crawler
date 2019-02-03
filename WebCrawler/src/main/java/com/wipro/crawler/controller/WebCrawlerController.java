package com.wipro.crawler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.wipro.crawler.service.WebCrawlerService;

@RestController
@RequestMapping("/web/crawl")
@CrossOrigin
public class WebCrawlerController {
	
	@Autowired
	WebCrawlerService service;

	/**
	 * End point to trigger web crawler.
	 * @return the result.
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<String> product(@RequestBody String input) {
		Gson gson = new Gson();
		return ResponseEntity.status(HttpStatus.OK).body(gson.toJson(service.crawl(input)));
	}
}
