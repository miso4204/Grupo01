package com.uniandes.stampidia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniandes.stampidia.repos.ReportRepository;

@Service
@Transactional
public class ReportService {

	@Autowired
    private ReportRepository reportRepository;
	
    public List<Object[]> reportSalesByPeriod(String username){
    	return reportRepository.reportSalesByPeriod(username);
    }
    
    public List<Object[]> reportSalesByArtist(String username){
    	return reportRepository.reportSalesByArtist(username);
    }
    
    
	public List<Object[]> reportRatingDesigns(){
		return reportRepository.reportRatingDesigns();
	}
	
	public List<Object[]> reportRatingDesignsByArtist(String username){
		return reportRepository.reportRatingDesignsByArtist(username);
	}
}
