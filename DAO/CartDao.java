package com.infosys.jdbc_prepared_statement_crud.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.infosys.jdbc_prepared_statement_crud.Cnnection.MainConnection;
import com.infosys.jdbc_prepared_statement_crud.Entity.Cart;
import com.mysql.cj.xdevapi.PreparableStatement;

public class CartDao {
	Connection connection=MainConnection.getMainConnection();
	  private final String CARTDETAILDATA="select * from cart";
	  List<Cart> carts=new ArrayList<Cart>();
	public List<Cart> cartDetailDao(){
		try {
			PreparedStatement ps=connection.prepareStatement(CARTDETAILDATA);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				int pid = res.getInt("pid");
				String pname = res.getString("pname");
				String pcolor = res.getString("pcolor");
				Double pprice = res.getDouble("pprice");
				LocalDate pmfd = res.getDate("pmfd").toLocalDate();
				LocalDate pexpd = res.getDate("pexpd").toLocalDate();
				int UserId=res.getInt("UserId");
				Cart cd = new Cart(pid, pname, pcolor, pprice, pmfd, pexpd,UserId);
				carts.add(cd);
			}

			return carts;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
		
	} 
		
	}

