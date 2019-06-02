package ua.lv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lv.dao.ProductDAO;
import ua.lv.entity.Product;
import ua.lv.service.ProductService;

import java.util.List;

/**
 * Created by User on 18.05.2019.
 */
@Transactional
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO productDAO;

    @Override
    public void saveProduct(Product product) {
        productDAO.save(product);
    }

    @Override
    public void DeleteProduct(int id) {
        productDAO.delete(id);
    }

    @Override
    public Product findOne(int id) {
        return productDAO.findOne(id);
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }
}
