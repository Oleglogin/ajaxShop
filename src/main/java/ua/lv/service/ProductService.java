package ua.lv.service;

import ua.lv.entity.Product;

import java.util.List;

/**
 * Created by User on 18.05.2019.
 */
public interface ProductService {
    void saveProduct(Product product);
    void DeleteProduct(int id);
    Product findOne(int id);
    List<Product> findAll();
}
