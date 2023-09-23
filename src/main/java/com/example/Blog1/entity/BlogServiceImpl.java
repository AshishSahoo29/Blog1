package com.example.Blog1.entity;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class BlogServiceImpl implements BlogServices {
	
	private BlogRepository blogRepository;
	
	@Autowired
	public BlogServiceImpl(BlogRepository blogRepository) {
		this.blogRepository = blogRepository;
	}

	
	@Override
	public Blog saveBlog(Blog blog) {
		// TODO Auto-generated method stub
		return blogRepository.save(blog);
	}

	@Override
	public List<Blog> getAllBlog() {
		// TODO Auto-generated method stub
		return blogRepository.findAll();
	}

	@Override
	public Blog findBlogById(Long id) {
		// TODO Auto-generated method stub
		Optional<Blog> blog = blogRepository.findById(id);
		if(blog.isPresent()) {
			return blog.get();
		}else {
			throw new ResourceNotFoundException("Blog","id",id);
		}
	}

	@Override
	public Blog updateBlog(Blog blog, long id) {
		//to check if the required record exists in database
		Blog existingBlog = 
				blogRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Blog", "id", id));
		
		//to make update
		existingBlog.setBlogName(blog.getBlogName());
		existingBlog.setDescription(blog.getDescription());
		existingBlog.setDate(blog.getDate());
		
		//save the changes after update
		blogRepository.save(existingBlog);
		
		return existingBlog;
	}

	@Override
	public Blog deleteBlogById(long id) {
		 blogRepository.deleteById(id);
		 return null;
	}
}





