package com.Training.Test.demo.Repository;

import com.Training.Test.demo.Model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Integer> {
}
