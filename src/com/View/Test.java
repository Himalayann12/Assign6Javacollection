
package com.View;

import java.util.List;
import java.util.Scanner;

import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

public class Test {
	
	public static void main(String[] args) {
		
		add();
		getAll();
		//delete();
		//get all product after deleted
		//getAll();
	}
	
	//add
	static void add() {
		
		ProductService  service = new ProductServiceImpl();
		char flag =  'y';
	   Scanner  sc = new Scanner(System.in);
	   
		do {
			Product  pd = new Product();
			
			System.out.println("enter id ");
			pd.setId(sc.nextInt());
			
			System.out.println("enter Name ");
			pd.setName(sc.next());
			 
			System.out.println("enter company");
			pd.setCompany(sc.next());
			
			System.out.println("enter price");
			pd.setPrice(sc.nextInt());
		
			
			service.addProduct(pd);
			
			System.out.println("do you want to add more[y/n]");
			flag = sc.next().charAt(0);
			
		}while(flag == 'y');
	}
	
	//get all
	static void getAll() {
		
		ProductService  service = new ProductServiceImpl();
		List<Product> plist = service.getAllProducts();
		System.out.println(plist);
	}
	
	//delete
	static void  delete() {
		ProductService  service = new ProductServiceImpl();
		service.deleteProduct(0);
	}

}
