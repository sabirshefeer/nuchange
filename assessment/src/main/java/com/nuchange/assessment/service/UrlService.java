package com.nuchange.assessment.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nuchange.assessment.model.UrlData;
import com.nuchange.assessment.repository.UrlRepository;

@Service
public class UrlService {
	
	@Autowired
	UrlRepository urlRepository;
	
	

	public UrlData storeUrlData(String url) {
		UrlData urlData = new UrlData();
		urlData.setUrl(url);
		urlData.setCount(0);
		
		urlData.setShortkey(UUID.randomUUID().toString());
		return urlRepository.save(urlData);
	}
	
	public String getShortKeyAndUpdateCount(String url) {
		
		Optional<UrlData> optional = urlRepository.findByUrl(url);
		UrlData urlData;
		if(optional.isPresent()) {
			urlData=optional.get();
			urlData.setCount(urlData.getCount()+1);
			urlRepository.save(urlData);
			return urlData.getShortkey();
			
		}else {
			
			return "url_not_found";
		}
		
		
		
		
		
	}

	public String getUrlCount(String url) {
		Optional<UrlData> optional = urlRepository.findByUrl(url);
		UrlData urlData;
		if(optional.isPresent()) {
			urlData=optional.get();
			
			return urlData.getCount()+"";
			
		}else {
			
			return "url_not_found";
		}
	}
	public List<UrlData> getUrlDatas(Integer page, Integer size){
		
		Pageable pageable =PageRequest.of(page, size );
		Page<UrlData> pages= urlRepository.findAll(pageable);
		if(pages.hasContent()) {
			return pages.getContent();
		}
		return new ArrayList<UrlData>();
		
	}

}
