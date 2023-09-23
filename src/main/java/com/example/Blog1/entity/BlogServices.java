package com.example.Blog1.entity;

import java.util.List;

public interface BlogServices {

	//for storing the record in database
	Blog saveBlog(Blog blog);
	
	//to display all the blog_posts in the feed
	List<Blog> getAllBlog();
	
	//to retrieve a specific record
	Blog findBlogById(Long id);

	//to update record in our databases
	Blog updateBlog(Blog blog, long id);
	
	//to delete a record from our database
	Blog deleteBlogById(long id);

	

	
}
