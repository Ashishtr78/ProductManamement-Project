package com.infosys.jdbc_prepared_statement_crud.SortingLogic;

import java.util.Comparator;

import com.infosys.jdbc_prepared_statement_crud.Entity.Product;

public class ProductPriceLowToHigh implements Comparator<Product>{
	
	public  int compare(Product p1,Product p2) {
	    return (int)(p1.getPrice()-p2.getPrice());
	}

}
