package com.infosys.jdbc_prepared_statement_crud.SortingLogic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.infosys.jdbc_prepared_statement_crud.Entity.Product;

public class ProductExpireDateCalculator{
	
	  public List<Product> compare(List<Product> products) {
		   LocalDate currentDate = LocalDate.now();
	        LocalDate oneMonthafter = currentDate.plusMonths(1);
	        List<Product> expiredWithinOneMonth = new ArrayList<>();
	        for (Product product : products) {
	            if (product.getExpd().isBefore(oneMonthafter)) {
	                expiredWithinOneMonth.add(product);
	            }
	        }

	        return expiredWithinOneMonth;
	    
	}

}
