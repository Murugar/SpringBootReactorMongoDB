package com.iqmsoft.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iqmsoft.model.Stock;
import com.iqmsoft.service.StockService;

import reactor.bus.Event;
import reactor.fn.Consumer;

@Service
public class StockClient implements Consumer<Event<Stock>>{

	@Autowired
	private StockService stockService;
	
	@Override
	public void accept(Event<Stock> stockEvent) {
		Stock stock = stockEvent.getData();
		
		try {
			stockService.processStock(stock);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
