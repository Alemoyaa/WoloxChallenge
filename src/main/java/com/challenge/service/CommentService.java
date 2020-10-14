package com.challenge.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import com.challenge.common.CommonService;
import com.challenge.dtos.Comment;
import com.challenge.dtos.Post; 

@Service
public class CommentService extends CommonService<Comment> {
	
	public CommentService(RestTemplateBuilder restTemplateBuilder) {
		super(restTemplateBuilder);
	}

	public Comment[] getAllComments() throws Exception{
		return getAll(Comment[].class, get_url() + "comments");
	}
	
	public Comment getComment(long id) throws Exception{
		return getOne(id, Comment.class, get_url() + "comments/{id}");
	}
	
	public Comment[] findCommentsForName(String _name) throws Exception{
		return getAll(Comment[].class, get_url() + "comments?name="+_name+"");
	}
	
	public List<Comment> findCommentsForUser(long idUser) throws Exception {
		
		String url = get_url() + "posts?userId="+idUser+"";
		
		Post[] postUser = this.restTemplate.getForObject(url, Post[].class);
		
		Comment[] comments;
		
		List<Comment> commentsUser = new ArrayList<Comment>();
		
		for (Post post: postUser) {

			url = get_url() + "posts/"+post.getId()+"/comments";
			
			comments = getAll(Comment[].class, url);
			
			commentsUser.addAll(Arrays.asList(comments));
			
		}
		
		return commentsUser;
		
	}
	
}
