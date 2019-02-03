package com.wipro.crawler.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class WebCrawlerServiceImpl implements WebCrawlerService {

	List<String> links = new ArrayList<>();

	@Override
	public List<String> crawl(String url) {		
		if (!links.contains(url)) {
			try {
				URI uri = new URI(url);
				String domain = uri.getHost();
				links.add(url);
				Document document = Jsoup.connect(url).get();
				/* Parse the HTML to extract links to other URLs */
				Elements linksOnPage = document.select("a[href]");
				/* Parse the HTML to extract images */
				Elements images = document.select("img");
				/* For each extracted URL... */
				for (Element page : linksOnPage) {
					/* if link is within the domain, go back to Step 4. */
					if(page.attr("href").contains(domain.startsWith("www.") ? domain.substring(4) : domain)) {
						crawl(page.attr("abs:href"));
					}						
				}
				for (Element image : images) {
					links.add(image.attr("abs:src"));
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
		return links;
	}	
}
