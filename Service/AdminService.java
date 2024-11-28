package com.infosys.jdbc_prepared_statement_crud.Service;

import java.util.List;

import com.infosys.jdbc_prepared_statement_crud.DAO.AdminDao;
import com.infosys.jdbc_prepared_statement_crud.Entity.Admin;
import com.infosys.jdbc_prepared_statement_crud.Entity.User;

public class AdminService {
	AdminDao ad=new AdminDao();
	Admin admin=new Admin();
	User user=new User();
	
	
	
	public int checkForValidationService( String username,String password)
	{
		
	
	
//	System.out.println(check);
	
		return ad.checkForValidationDao(admin,username,password);
	}



	public List<User> userDetailService() {
		
	List<User> userdetail=	ad.userDetailDao(user);
	return userdetail;
		
	}



	
 }
