package com.aartek.repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aartek.model.Product;

@Repository
@Transactional
public class ProductRepository {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void checkProduct(Product product) {
		System.out.println("-----------------------Inside Product Repository----------------------");
		System.out.println("Inside Product Service ");
		System.out.println("Product name : "+product.getProductname());
		System.out.println("Product Price : "+product.getPrice());
		System.out.println("Product Description : "+product.getProductdesc());
		System.out.println("Product Number of Product : "+product.getQuantity());
		hibernateTemplate.save(product);
	}
	public List<Product> getProductDetails(Product prod) {
		List<Product> list = hibernateTemplate.loadAll(Product.class);
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			Product product = (Product)itr.next();
			System.out.println(product.getProductname()+" "+product.getPid()+" "+product.getPrice()+" "+product.getQuantity()+" "+product.getProductdesc());
		}
		return list;
	}

}
