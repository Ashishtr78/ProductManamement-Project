package com.infosys.jdbc_prepared_statement_crud.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.infosys.jdbc_prepared_statement_crud.Cnnection.MainConnection;
import com.infosys.jdbc_prepared_statement_crud.Entity.Product;
import com.infosys.jdbc_prepared_statement_crud.Entity.User;

public class UserDao {
       
	Connection connection=MainConnection.getMainConnection();
	private final String INSERTUSERDATAQUERY="insert into user(id,name,password,email) values(?,?,?,?)";
	private final String GETDATAFORVALIDATION="select email,password from user";
	  private final String DISPLAYPRODUCTFULLDATA="select * from product";
	public int saveUserDataDao(User user)
	{
		try {
			PreparedStatement ps=connection.prepareStatement(INSERTUSERDATAQUERY);
			ps.setInt(1,user.getId());
			ps.setString(2,user.getName());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getEmail());
			int a=ps.executeUpdate();
			if(a>0)
			return a;
			else
				System.out.println("enter the valid data");
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
			
			return 0;
		}
	}

	public int  checkUserValidationDao(User user,String email,String password) {
		String emailfromdatabase=null;
		String passwordfromdatabase=null;
	
		try {
			PreparedStatement ps=connection.prepareStatement(GETDATAFORVALIDATION);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				 emailfromdatabase=rs.getString("email");
				 passwordfromdatabase=rs.getString("password");
				user.setEmail(emailfromdatabase);
				user.setPassword(passwordfromdatabase);
				if(email.equals(user.getEmail()) && password.equals(user.getPassword()))
				{
					return 1;
				}
				
			}
			return 0;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return 0;
		}
	}

	public List<Product> fullProductDetail() {
		

		List<Product> pld=new ArrayList<Product>();
		try {
			PreparedStatement ps=connection.prepareStatement(DISPLAYPRODUCTFULLDATA);
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				int id=res.getInt("id");
				String name=res.getString("name");
				String color=res.getString("color");
				Double price=res.getDouble("price");
				LocalDate mfd=res.getDate("mfd").toLocalDate();
				LocalDate expd=res.getDate("expd").toLocalDate();
				Product pddd=new Product(id, name, color, price, mfd, expd);
				pld.add(pddd);
			}
			
			return pld;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;

	}
	
	
	
}
