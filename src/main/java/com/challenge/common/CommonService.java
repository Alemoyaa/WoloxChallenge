package com.challenge.common;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

public abstract class CommonService <E> {

	private String _url = "https://jsonplaceholder.typicode.com/";

	protected RestTemplate restTemplate;
	
	public CommonService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	public E[] getAll(Class<E[]> classEx, String url){
		return this.restTemplate.getForObject(url, classEx);
	}
	
	public E getOne(long id, Class<E> classEx, String url){
		return this.restTemplate.getForObject(url, classEx, id);
	}

	public String get_url() {
		return _url;
	}
	
}
