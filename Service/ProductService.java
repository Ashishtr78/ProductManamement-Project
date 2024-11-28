package com.infosys.jdbc_prepared_statement_crud.Service;

import java.util.List;

import com.infosys.jdbc_prepared_statement_crud.DAO.ProductDao;
import com.infosys.jdbc_prepared_statement_crud.Entity.Product;

public class ProductService {
	ProductDao pd = new ProductDao();

	public int saveProductDataService(Product product) {

			int p1 = pd.saveProductDataDao(product);
			return p1;
	}
	
	public int deleteProductDataService(int id) {
		
	int delete=	pd.deleteProductDataDao( id);
	return delete;
	}

	

	public int updateProductNameService(int id, String name) {
		int uns=pd.updateProductNameDao(id,name);
		return uns;
		
	}
	public int updateProductColorService(int id, String color) {
		int ucs=pd.updateProductColorDao(id,color);
		return ucs;
		
	}

	public int updateProductColorService(int id, Double price) {
		int ups=pd.updateProductColorDao(id,price);
		return ups;
	}

	public Product productDataDisplayWithIdService(int id) {
	           
		Product psdd=pd.productDataDisplayWithIdDao(id);
		
		return psdd;
	}

	public List<Product> displayProductFullData() {
		List<Product> pls=pd.displayProductFullData();
		return pls;
	}

	public int[] saveMultipleProductDataService(List<Product> products) {
		
	int[] a=pd.saveMultipleProductDataDao(products);
	     return a;
		
	}

	



}
