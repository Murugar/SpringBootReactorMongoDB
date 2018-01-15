
package com.iqmsoft.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.iqmsoft.model.Stock;


@Repository
public interface StockRepository extends MongoRepository<Stock, String> {

}
