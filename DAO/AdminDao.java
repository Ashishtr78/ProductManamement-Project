package com.infosys.jdbc_prepared_statement_crud.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.infosys.jdbc_prepared_statement_crud.Cnnection.MainConnection;
import com.infosys.jdbc_prepared_statement_crud.Entity.Admin;
import com.infosys.jdbc_prepared_statement_crud.Entity.User;

public class AdminDao {

	Connection connection = MainConnection.getMainConnection();
	Admin admin=new Admin();
	private final String INSERTADMINQUERY = "insert into admin(id,username,password) values(?,?,?)";
	private final String GETDATAFORVALIDATION="select username,password from admin";
	private final String GETUSERDETAILQUERY="select * from User";

	public int saveAdminDao(Admin admin)
	{
		try {
			PreparedStatement ps=connection.prepareStatement(INSERTADMINQUERY);
			ps.setInt(1,admin.getId());
			ps.setString(2,admin.getUsername());
			ps.setString(3, admin.getPassword());
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

	

	public int checkForValidationDao(Admin admin,String username,String password)
	{
		//List<String> adminDetail=new ArrayList<>();
		String usernamefromdatabase=null;
		String passwordfromdatabase=null;
		try {
			PreparedStatement ps=connection.prepareStatement(GETDATAFORVALIDATION);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
			 usernamefromdatabase=rs.getString("username");
			 passwordfromdatabase=rs.getString("password");
			 admin.setUsername(usernamefromdatabase);
				admin.setPassword(passwordfromdatabase);
			    if(username.equals(admin.getUsername()) && password.equals(admin.getPassword())){
			    	return 1;
			    }
			}
			    return 0;
			
			//new Admin(usernamefromdatabase, passwordfromdatabase);
			
			// System.out.println(username);
//			System.out.println(check);
//			if(username.equals(usernamefromdatabase) && password.equals(passwordfromdatabase) )
//			{
//				
//				return 1;
//			}
//			else
//			{
//				System.out.println("====================");
//				return 0;
//			}
//				
				
//			adminDetail.add(admin.getUsername());
//			adminDetail.add(admin.getPassword());
//			return adminDetail;
		
					
		} catch (SQLException e) {
			System.out.println("==============");
			
			return 0;
		}
	}



	public List<User> userDetailDao(User user) {
		List<User> ul=new ArrayList<User>();
		try {
			PreparedStatement ps=connection.prepareStatement(GETUSERDETAILQUERY);
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				int id=res.getInt("id");
				String name=res.getString("name");
				String password=res.getString("password");
				String email=res.getString("email");
				 user=new User(id, name, password, email);
				ul.add(user);
				
			}
			return ul;
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		
		return null;
	}



	
	
}
