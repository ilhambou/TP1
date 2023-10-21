package com.example.tpjee.service;

import com.example.tpjee.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProdcutService {
    private static List<Product> productRepo = new ArrayList<>();
    static {
        productRepo.add(new Product(1l,"PC PORTABLE HP"));
        productRepo.add(new Product(2l,"TV LG 32p"));
        productRepo.add(new Product(3l,"TV Sony 49p"));
        productRepo.add(new Product(4l,"Camera Sony"));
    }
    @Override
    public Product getById(Long id) {
        if (productRepo == null || productRepo.isEmpty())
            return null;
        for (Product product : productRepo) {
            if (id.equals(product.getId()))
                return product;
        }
        return null;
    }
    @Override
    public List<Product> getAll() {
        return productRepo;
    }

    @Override
    public void create(Product product) {
        productRepo.add(product);

    }

    @Override
    public void update(Long id, Product product) {
        Product productFound = getById(id);
        if (productFound == null)
            return;
        productRepo.remove(productFound);
        product.setId(id);
        productRepo.add(product);
    }
    @Override
    public void delete(Long id) {
        Product productFound = getById(id);
        if (productFound == null)
            return;
        productRepo.remove(productFound);
    }

}
