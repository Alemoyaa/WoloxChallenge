package com.challenge.common;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

public class CommonService <E> implements CommonIService<E> {

	private String _url = "https://jsonplaceholder.typicode.com/";

	protected RestTemplate restTemplate;
	
	public CommonService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	public E[] getAll(Class<E[]> classEx, String url) throws Exception{
		try {
			return this.restTemplate.getForObject(url, classEx);
		}catch (Exception e) {
			throw new Exception("Error. Please try again later. Error: "+ e.getMessage()) ;
		}
	}
	
	public E getOne(long id, Class<E> classEx, String url) throws Exception{
		try {
			return this.restTemplate.getForObject(url, classEx, id);
		}catch(Exception e) {
			throw new Exception("Error. Please try again later. Error: "+ e.getMessage()) ;
		}
	}

	public String get_url() {
		return _url;
	}
}
