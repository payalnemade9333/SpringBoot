package com.aartek.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.Product;
import com.aartek.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public Product getProduct(Product product)
	{
		System.out.println("Inside Product Service ");
		System.out.println("Product name : "+product.getProductname());
		System.out.println("Product Price : "+product.getPrice());
		System.out.println("Product Description : "+product.getProductdesc());
		System.out.println("Product Number of Product : "+product.getQuantity());
		productRepository.checkProduct(product);
		return product;
	}
	public List getProductDetails(Product prodlist) {
		List list =productRepository.getProductDetails(prodlist);
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			Product product = (Product)itr.next();
			System.out.println(product.getProductname()+" "+product.getPid()+" "+product.getPrice()+" "+product.getQuantity()+" "+product.getProductdesc());
		}
		return list;
	}
}
