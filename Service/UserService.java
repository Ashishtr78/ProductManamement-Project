package com.infosys.jdbc_prepared_statement_crud.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.infosys.jdbc_prepared_statement_crud.DAO.UserDao;
import com.infosys.jdbc_prepared_statement_crud.Entity.Product;
import com.infosys.jdbc_prepared_statement_crud.Entity.User;

public class UserService {
	UserDao ud=new UserDao();
	User user=new User();
	Product product=new Product();
	public int  checkUserValidationService(String email, String password) {
		
		
      int uv=ud.checkUserValidationDao(user,email,password); 
		if(uv==1)
			return 1;
		else
			return 0;
		
	}
	public Product searchProductByNameService(String name) {
	
		 List<Product> product=  ud.fullProductDetail();
		 for(Product x:product) {
		if(name.equals(x.getName())){
			Product finalproduct=x;
			return finalproduct;
		}
		 }            
		 return null;
		
	 }
	public List<Product> fullProductDetail() {
		List<Product> productetail=ud.fullProductDetail();
		return productetail;
	}

	
	
	
}
