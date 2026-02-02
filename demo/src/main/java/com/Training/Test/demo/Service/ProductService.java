package com.Training.Test.demo.Service;

import com.Training.Test.demo.Model.Product;
import com.Training.Test.demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class ProductService {
    List<Product> productList =  new ArrayList<>();

    @Autowired
    private ProductRepository prodRepo;
    public Product getProductById(int prodId){
        return prodRepo.findById(prodId).orElse(null);

//        for(Product product : productList){
//            if(product.getId() == prodId){
//                return product;
//            }
//        }
//        return null;
    }

    public List<Product> getAllProducts(){

        Iterable<Product> iterable = prodRepo.findAll();
        Iterator<Product> iterator = iterable.iterator();
        List<Product> list = new ArrayList<>();

        while(iterator.hasNext()){
            list.add(iterator.next());
        }

        return list;
    }

    public Product addProduct(Product prod){
        return prodRepo.save(prod);
//        try{
//            productList.add(prod);
//            return prod;
//        }catch(Exception e){
//            System.out.println("Error encountered while adding product");
//        }
//        return null;
    }

    public Product deleteProduct(int prodid){
        Product product = prodRepo.findById(prodid).orElse(null);
        try{
            prodRepo.deleteById(prodid);
            return product;
        }catch(Exception e){
            return null;
        }

//        for(Product product :productList){
//            if(product.getId() == prodid){
//                productList.remove(product);
//                return product;
//            }
//        }
//
//        return null;
    }

    public void updateProduct(Product prod){

        prodRepo.save(prod);

//        for(Product product : productList){
//            if(product.getId() == prod.getId()){
//                int index = productList.indexOf(product);
//                productList.set(index,prod);
//                return;
//            }
//        }
    }

}
