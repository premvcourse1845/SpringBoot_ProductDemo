package com.Training.Test.demo.Controller;

import com.Training.Test.demo.Model.Product;
import com.Training.Test.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    //localhost:8080/getProduct/101
    @GetMapping("/getProduct/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){

        Product product = service.getProductById(id);
        if(product == null){
           return new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

//    localhost:8080/getAllProducts
    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> listOfProducts = service.getAllProducts();
        if(listOfProducts.size() == 0){
            return new ResponseEntity<>(listOfProducts,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listOfProducts,HttpStatus.OK);
    }

    //localhost:8080/addProduct
    //localhost:8080/addProduct

//    HTTPRequest -> Header,Body(JSON/XML),Response
    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product prod){
        Product product = service.addProduct(prod);
        if(product == null){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }

    // localhost:8080/deleteProduct/1
    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable int id){
        Product product = service.deleteProduct(id);
        if(product != null){
            return new ResponseEntity<>(product,HttpStatus.GONE);
        }
        return new ResponseEntity<>(product,HttpStatus.NOT_FOUND);
    }

    //localhost:8080/updateProduct
    @PutMapping("/updateProduct")
    public void updateProduct(@RequestBody Product prod){
        service.updateProduct(prod);
    }

}


// @Controller, @Service, @Respository => @Component
// @ComponentScan