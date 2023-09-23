package com.example.Blog1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Blog1.entity.Blog;
import com.example.Blog1.entity.BlogServices;

@Controller
@RequestMapping("/api/bloger")
public class BlogController1 {
	private BlogServices blogServices;
	
	public BlogController1(BlogServices blogServices) {
		this.blogServices = blogServices;
	}

	@PostMapping
	public ResponseEntity<Blog>saveBlog(@RequestBody Blog blog){
		return new ResponseEntity<Blog>(blogServices.saveBlog(blog), HttpStatus.CREATED);
	}
	
	//for retrieving from database
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public List<Blog> getBlogs(){
		return blogServices.getAllBlog();
	}
	
	//@PathVariable is used in this case to catch a value from url
	@GetMapping("{id}")
	public ResponseEntity<Blog> getBlogById(@PathVariable("id") long blogId){
		return new ResponseEntity<Blog>(blogServices.findBlogById(blogId),HttpStatus.OK);
	}
	
	//to update
	@PutMapping("{id}")
	public ResponseEntity<Blog> update(@PathVariable("id") long id, @RequestBody Blog blog){
		return new ResponseEntity<Blog>(blogServices.updateBlog(blog,id),HttpStatus.OK);
	}
	//long id defined after @PathVariable is a local variable
	//@RequestBody converts pojo to json and json to pojo
	
	//to Delete
	@DeleteMapping("{id}")
	public ResponseEntity<Blog> deleteIds(@PathVariable("id") long id){
		return new ResponseEntity<Blog>(blogServices.deleteBlogById (id),HttpStatus.OK);
	}

}
