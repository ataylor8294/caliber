package com.revature.caliber.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.Category;
import com.revature.caliber.services.CategoryService;

@RestController
public class CategoryController {

	private final static Logger log = Logger.getLogger(CategoryController.class);
	private CategoryService categoryService;

	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@RequestMapping(value="/category/all", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Category>> findAllCategories(){
		log.debug("Getting categories");
		List<Category> categories = categoryService.findAllCategories();
		return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
	}
	
	@RequestMapping(value="/category/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> findCategoryById(@PathVariable int id){
		log.debug("Getting category: " + id);
		Category category = categoryService.findCategory(id);
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}
	
}
