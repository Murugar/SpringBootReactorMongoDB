package com.iqmsoft;

import static reactor.bus.selector.Selectors.$;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.iqmsoft.consumer.StockClient;

import reactor.bus.EventBus;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages="com.iqmsoft")
@Import({com.iqmsoft.config.Config.class})
public class MainReactor implements CommandLineRunner {
	
	@Autowired
    private EventBus eventBus;
     
    @Autowired
    private StockClient stockConsumer;
     
    @Override
    public void run(String... args) throws Exception {
        eventBus.on($("stockConsumer"), stockConsumer);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(MainReactor.class, args);
	}
}
