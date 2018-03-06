package com.itheima.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.domain.Category;
import com.itheima.domain.Product;
import com.itheima.service.AdminProductService;

public class AdminUpdateProductUIServlet extends HttpServlet {
	

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String pid = req.getParameter("pid");
		System.out.println(pid);
		
		AdminProductService service=new AdminProductService();
		Product product=null;
		try {
			product=service.findProductById(pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(product.toString());
		List<Category> categoryList=null;
		try {
			categoryList=service.findAllCategory();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("categoryList", categoryList);
		req.setAttribute("product", product);
		req.getRequestDispatcher("/admin/product/edit.jsp").forward(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}