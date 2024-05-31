
package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Product;

public class ProductServiceImpl implements ProductService {
	
	static List<Product>  plist = new ArrayList<>();

	@Override
	public void addProduct(Product p) {
		
		//plist.add(p);
		//System.out.println("----added success ----- size = "+plist.size());
		
		 try {
			 
				Class.forName("com.mysql.cj.jdbc.Driver");
				 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/interndatabase","root","MYSQL!@#");
				 String sql="Insert into Product(name,company,price) values('"+p.getName()+"','"+p.getCompany()+"','"+p.getPrice()+"')";
				 Statement st=con.createStatement();
				 st.execute(sql);
				 


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduct(int index) {
		
		plist.remove(index);
	}

	@Override
	public List<Product> getAllProducts() {
		
		return plist;
	}

	
}
