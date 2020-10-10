package com.challenge.common;

public interface CommonIService<E> {
	
	public E[] getAll(Class<E[]> classEx, String url) throws Exception;
	
	public E getOne(long id, Class<E> classEx, String url) throws Exception;
	
}
