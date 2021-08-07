package com.nuchange.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nuchange.assessment.model.UrlData;
import com.nuchange.assessment.service.UrlService;

@RestController
public class urlController {
	
	@Autowired
	UrlService urlService;
	
	@PostMapping("storeurl")
	public UrlData storeUrlData(@RequestParam ("url") String url) {
		
		
		return urlService.storeUrlData(url);
		
	}
	
	@GetMapping("get")
	public String getShortkey(@RequestParam("url") String url) {
		String shortKey= urlService.getShortKeyAndUpdateCount(url);
		return shortKey;
	}
	
	
	@GetMapping("count")
	public 	String getUrlCount(@RequestParam("url") String url) {
		String count= urlService.getUrlCount(url);
		return count;
	}
		
	
	@GetMapping("list")
	public List<UrlData> getUrlDatas(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size){
		
		return urlService.getUrlDatas(page, size);
	}
	

}
