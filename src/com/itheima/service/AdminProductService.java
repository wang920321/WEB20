package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.dao.AdminProductDao;
import com.itheima.domain.Category;
import com.itheima.domain.Product;

public class AdminProductService {
	AdminProductDao dao=new AdminProductDao();
	public List<Product> findAllProduct() {
		List<Product> products=null;
		try {
			products = dao.findAllProduct();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	public boolean addProduct(Product product) throws SQLException {
		int row=dao.addProduct(product);
		if(row>0){
			return true;
		}
		return false;
	}

	public List<Category> findAllCategory() throws SQLException {
		List<Category> categoryList=dao.findAllCategory();
		return categoryList;
	}

	public void deleteProductById(String pid) throws SQLException {
		dao.deleteProductById(pid);
		
	}

	public Product findProductById(String pid) throws SQLException {
		Product product=dao.findProductById(pid);
		return product;
	}

	public boolean updateProduct(Product product) throws SQLException {
		int row=dao.updateProduct(product);
		if(row>0){
			return true;
		}
		return false;
	}

}
