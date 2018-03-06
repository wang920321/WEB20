package com.itheima.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.domain.Product;
import com.itheima.service.AdminProductService;

public class AdminProductListServlet extends HttpServlet {
	

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		AdminProductService service=new AdminProductService();
		List<Product> productList=service.findAllProduct();
		HttpSession session = req.getSession();
		session.setAttribute("productList", productList);
		req.getRequestDispatcher("/admin/product/list.jsp").forward(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}