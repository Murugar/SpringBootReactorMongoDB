
package com.iqmsoft.service;

import com.iqmsoft.model.Stock;


public interface StockService {
	
	void processStock(Stock stock) throws InterruptedException;

}
