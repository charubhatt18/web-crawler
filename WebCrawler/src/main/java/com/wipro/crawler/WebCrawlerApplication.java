package com.wipro.crawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebCrawlerApplication {
	
	/**
	 * The start of the application.
	 * @param args The command line arguments.
	 * @throws Exception an exception on start up failure.
	 */
	public static void main(String[] args) throws Exception {
        SpringApplication.run(WebCrawlerApplication.class, args);
    }

}
