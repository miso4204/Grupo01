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
	
	public List<Object[]> reportBySales(){
		return reportRepository.reportBySales();
	}
        
    public List<Object[]> reportByPeriod(){
    	return reportRepository.reportByPeriod();
    }
}
