package com.infosys.jdbc_prepared_statement_crud.Service;

import java.util.List;

import com.infosys.jdbc_prepared_statement_crud.DAO.CartDao;
import com.infosys.jdbc_prepared_statement_crud.Entity.Cart;

public class CartService {
    CartDao cd=new CartDao();
	public List<Cart> cartDetailService() {
	List<Cart> cl=	cd.cartDetailDao();
	if(!cl.equals(null))
		return cl;
	else
		return null;
	}

}
