package com.itheima.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.domain.Product;
import com.itheima.service.AdminProductService;

public class AdminUpdateProductServlet extends HttpServlet {
	

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Map<String, String[]> parameterMap = req.getParameterMap();
		System.out.println(parameterMap+"-------------");
		Product product=new Product();
		AdminProductService service=new AdminProductService();
		try {
			BeanUtils.populate(product, parameterMap);
			product.setPimage("products/1/c_0001.jpg");
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			String pdate = format.format(new Date());
			product.setPdate(pdate);
			product.setPflag(0);
			try {
				boolean flag=service.updateProduct(product);
				if(flag){
					res.sendRedirect(req.getContextPath()+"/adminProductList");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}