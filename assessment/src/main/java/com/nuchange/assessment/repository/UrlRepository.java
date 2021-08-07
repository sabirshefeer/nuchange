package com.nuchange.assessment.repository;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nuchange.assessment.model.UrlData;

public interface UrlRepository  extends JpaRepository<UrlData, String>{

	
	Optional<UrlData> findByUrl(String url);

	

}
