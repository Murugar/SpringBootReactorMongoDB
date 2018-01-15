package com.iqmsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.iqmsoft.model.Stock;

import reactor.bus.Event;
import reactor.bus.EventBus;


@Controller
public class FundController {
	
	@Autowired
    private EventBus eventBus;
 
    @GetMapping("/launchStock/{param}")
    public void launchStock(@PathVariable Integer param) {
        for (int i = 0; i < param; i++) {
            Stock stock = new Stock();
            stock.setId(Long.valueOf(i));
            stock.setName("Name"+i);
 
            eventBus.notify("stockConsumer", Event.wrap(stock));
 
            System.out.println("Stock " + i + ": send correctly");
        }
        
        
       
    }

}
