package com.iqmsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iqmsoft.model.Stock;
import com.iqmsoft.repository.StockRepository;


@Service
public class StockImpl implements StockService {
	
	@Autowired
	StockRepository stockRepository;
	
	@Override
	public void processStock(Stock stock) throws InterruptedException {
		System.out.println("Stock processing started for Stock id:" + stock.getId() + ". Name: "+ stock.getName());
		
		stockRepository.save(stock);
		
		System.out.println("Stock id:" + stock.getId() + ". Name: "+ stock.getName()+" persisted into MongoDB");
		System.out.println("Stock processing ended for Stock id:" + stock.getId() + ". Name: "+ stock.getName());
		
	}

}
