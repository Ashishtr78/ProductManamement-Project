package com.infosys.jdbc_prepared_statement_crud.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//import java.util.Objects;

import com.infosys.jdbc_prepared_statement_crud.Cnnection.MainConnection;
import com.infosys.jdbc_prepared_statement_crud.Entity.Product;

public class ProductDao {
      Connection connection=MainConnection.getMainConnection();
	  private final String INSERTPRODUCTDATAQUERY="insert into product(id,name,color,price,mfd,expd) values(?,?,?,?,?,?)";
	  private final String DELETEPRODUCTDATAQUERY="delete from product where id=?";
	  private final String UPDATEPRODUCTNAMEQUERY="update product set name=? where id=?";
	  private final String UPDATEPRODUCTCOLORQUERY="update product set color=? where id=?";
	  private final String UPDATEPRODUCTPRICEQUERY="update product set price=? where id=?";
	  private final String DISPLAYPRODUCTDATAWITHID="select * from product where id=?";
	  private final String DISPLAYPRODUCTFULLDATA="select * from product";
public int	saveProductDataDao(Product product) {
	
	try {
		PreparedStatement ps=connection.prepareStatement(INSERTPRODUCTDATAQUERY);
		ps.setInt(1,product.getId());
		ps.setString(2,product.getName());
		ps.setString(3,product.getColor());
		ps.setDouble(4,product.getPrice());
		ps.setObject(5,product.getMfd());
		ps.setObject(6,product.getExpd());
	int a=ps.executeUpdate();
	System.out.println(a);
		return  a;
	} catch (SQLException e) {
	
		e.printStackTrace();
		return 0;
	}
	
}

public int deleteProductDataDao(int id) {
	try {
		PreparedStatement ps=connection.prepareStatement(DELETEPRODUCTDATAQUERY);
		ps.setInt(1, id);
		return ps.executeUpdate();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
		return 0;
	}
	
	
}



public int updateProductNameDao(int id, String name) {
	try {
		PreparedStatement ps=connection.prepareStatement(UPDATEPRODUCTNAMEQUERY);
		ps.setString(1, name);
		ps.setInt(2, id);
	return	ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return 0;
	}
	
}
public int updateProductColorDao(int id, String color) {
	try {
		PreparedStatement ps=connection.prepareStatement(UPDATEPRODUCTCOLORQUERY);
		ps.setString(1, color);
		ps.setInt(2, id);
	return	ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return 0;
	}
}
public int updateProductColorDao(int id, Double price) {
	try {
		PreparedStatement ps=connection.prepareStatement(UPDATEPRODUCTPRICEQUERY);
		ps.setDouble(1, price);
		ps.setInt(2, id);
	return	ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return 0;
	}
}


public Product productDataDisplayWithIdDao(int id) {
	
	try {
		PreparedStatement ps=connection.prepareStatement(DISPLAYPRODUCTDATAWITHID);
		ps.setInt(1, id);
	ResultSet res=	ps.executeQuery();
	while(res.next())
	{
		String name=res.getString("name");
		String color=res.getString("color");
		Double price=res.getDouble("price");
		LocalDate mfd=res.getDate("mfd").toLocalDate();
		LocalDate expd=res.getDate("expd").toLocalDate();
		Product pddd=new Product(id, name, color, price, mfd, expd);
		return pddd;
		
	}
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return null;
}

public List<Product> displayProductFullData() {
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

public int[] saveMultipleProductDataDao(List<Product> products) {
	
	PreparedStatement ps=null;
	try {
		
		 ps=connection.prepareStatement(INSERTPRODUCTDATAQUERY);
		for(Product product:products) {
		ps.setInt(1,product.getId());
		ps.setString(2,product.getName());
		ps.setString(3,product.getColor());
		ps.setDouble(4,product.getPrice());
		ps.setObject(5,product.getMfd());
		ps.setObject(6,product.getExpd());
		ps.addBatch();
		}
		int[] a=ps.executeBatch();
		return a;
		}
		
	 catch (SQLException e) {
	
		e.printStackTrace();
		return null;
	}
	
	
	}


}
