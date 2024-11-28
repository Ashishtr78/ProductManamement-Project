package com.infosys.jdbc_prepared_statement_crud.Controller;

import java.time.LocalDate;
import java.util.*;

import com.infosys.jdbc_prepared_statement_crud.DAO.AdminDao;
import com.infosys.jdbc_prepared_statement_crud.DAO.UserDao;
//import com.infosys.jdbc_prepared_statement_crud.DAO.;
import com.infosys.jdbc_prepared_statement_crud.Entity.*;
import com.infosys.jdbc_prepared_statement_crud.Service.AdminService;
import com.infosys.jdbc_prepared_statement_crud.Service.ProductService;
import com.infosys.jdbc_prepared_statement_crud.Service.UserService;
import com.infosys.jdbc_prepared_statement_crud.SortingLogic.ProductPriceLowToHigh;

public class ProjectController {

	public static void main(String[] args) {
		AdminDao ad = new AdminDao();
		UserDao ud = new UserDao();
		AdminService as = new AdminService();
		UserService us = new UserService();
		ProductService ps = new ProductService();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to a project on crud operation");
		System.out.println("Please enter the the choice\n1.Register\n2.Login");
		// this is for choice the login role
		int choice = sc.nextInt();
		switch (choice) {
		case 1: {
			System.out.println("Please enter the role\n1.Register for Admin\n2.Register for User");
			int choiceforregistation = sc.nextInt();
			switch (choiceforregistation) {
			case 1: {
				System.out.println("enter your id");
				int id = sc.nextInt();
				System.out.println("enter the username");
				String username = sc.next();
				System.out.println("enter the password");
				String password = sc.next();
				try {
					int p = ad.saveAdminDao(new Admin(id,username, password));
					System.out.println(p);
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
				break;
			case 2: {
				System.out.println("enter your id");
				int id = sc.nextInt();
				System.out.println("enter the name");
				String name = sc.next();
				System.out.println("enter the password");
				String password = sc.next();
				System.out.println("enter the emailId");
				String email = sc.next();
				int a = ud.saveUserDataDao(new User(id, name, password, email));
				System.out.println(a);
				break;
			}

			default:
				throw new IllegalArgumentException("Unexpected value: " + 1);
			}

		}
		case 2: {
			System.out.println("Please enter the role\n1.Login for Admin\n2.Login for User");
			int choiceforlogin = sc.nextInt();
			switch (choiceforlogin) {
			case 1: {
				System.out.println("enter the username");
				String username = sc.next();
				System.out.println("enter the password");
				String password = sc.next();
				int a = as.checkForValidationService(username, password);
				if (a == 1) {
					System.out.println("login successfully");
					System.out.println("===========Welcome to Admin Database============");
					while (true) {
						System.out.println("1.INSERT the data in product table\n2.DELETE the data from product table"
								+ "\n3.UPDATE the data in product table\n4.DISPLAY the data in product table"
								+ "\n5.UserDetails\n6.Insert the multiple data");
						System.out.println("please enter your choice");
						int choice1 = sc.nextInt();
						switch (choice1) {
						case 1: {
							System.out.println("enter the id");
							int id = sc.nextInt();
							System.out.println("enter the name");
							String name = sc.next();
							System.out.println("enter the color");
							String color = sc.next();
							System.out.println("enter the price");
							double price = sc.nextDouble();
							System.out.println("enter the mfd");
							String mfd = sc.next();
							System.out.println("entet the expire date");
							String expd = sc.next();
							int a1 = ps.saveProductDataService(
									new Product(id, name, color, price, LocalDate.parse(mfd), LocalDate.parse(expd)));
							if (a1 == 1) {
								System.out.println("product data save successfully");
								System.out.println("===============================================");
							} else {
								System.out.println("please enter valid data");
							}

							break;

						}
						case 2: {
							System.out.println("enter the id no which is you want to delete");
							int id = sc.nextInt();
							int a1 = ps.deleteProductDataService(id);
							if (a1 == 1) {
								System.out.println("data delete successfully");
							} else
								System.out.println("failed");

							break;
						}

						// this is updation for Product table

						case 3: {
							System.out.println("enter the id which you want to update");
							int id = sc.nextInt();
							System.out.println("what is you wan to update\n1.name\n2.color\n3.price");
							int choiceforupdation = sc.nextInt();
							switch (choiceforupdation) {
							case 1: {

								System.out.println("enter the new updated name");
								String name = sc.next();
								int un = ps.updateProductNameService(id, name);
								if (un > 0) {
									System.out.println("Product name update successfully");
								} else {
									System.out.println("Product name update not successfully");
								}
								break;
							}
							case 2: {
								System.out.println("enter the color");
								String color = sc.next();
								int uc = ps.updateProductColorService(id, color);
								if (uc > 0) {
									System.out.println("Product color update successfully");
								} else {
									System.out.println("Product color update not successfully");
								}
								break;
							}
							case 3: {
								System.out.println("enter the Price");
								Double price = sc.nextDouble();
								int up = ps.updateProductColorService(id, price);
								if (up > 0) {
									System.out.println("Product price update successfully");
								} else {
									System.out.println("Product price update not successfully");
								}
								break;
							}
							default:
								throw new IllegalArgumentException("Unexpected value: " + choiceforupdation);
							}
						}

						// display the data in Admin section

						case 4: {
							System.out.println("what do you want display product data with \n1.id\n2.fullDetail\n3.product detail from low to high price");
							int choicefordisplay = sc.nextInt();
							switch (choicefordisplay) {
							case 1: {
								System.out.println("enter the id no");
								int id = sc.nextInt();
								Product displaywithid = ps.productDataDisplayWithIdService(id);
								System.out.println(displaywithid);
								System.out.println("============================");
								break;
							}
							case 2: {
								System.out.println("the full Product detail is ");
								List<Product> pfd = ps.displayProductFullData();
								for (Product x : pfd) {
									System.out.println(x);
									System.out.println("============================");
								}
								 System.out.println("================================================");
								break;
							}
							case 3:{
								System.out.println("Product detail from low to high according to price");
								List<Product> pfd = ps.displayProductFullData();
								Collections.sort(pfd, new ProductPriceLowToHigh());
								for(Product p:pfd) {
									System.out.println(p);
									System.out.println("============================");
								}
							}

							default:
								throw new IllegalArgumentException("Unexpected value: " + choicefordisplay);
							}
							break;
						}
						// Admin Access the user data
						case 5:{
							List<User> userdetail=as.userDetailService();
							for(User x:userdetail)
							{
								System.out.println(x);
								System.out.println("============================");
							}
							break;
						}

						
						case 6:
						{
							System.out.println("enter how much data you want to enter");
							int no=sc.nextInt();
							List<Product> products=new ArrayList<Product>();
							for(int i=1;i<=no;i++) {
							System.out.println("enter the "+i+" product detail");
							System.out.println("enter the id");
							int id = sc.nextInt();
							System.out.println("enter the name");
							String name = sc.next();
							System.out.println("enter the color");
							String color = sc.next();
							System.out.println("enter the price");
							double price = sc.nextDouble();
							System.out.println("enter the mfd");
							String mfd = sc.next();
							System.out.println("entet the expire date");
							String expd = sc.next();
							Product product=new Product(id, name, color, price, LocalDate.parse(mfd), LocalDate.parse(expd));
							products.add(product);
						}
						int[] a1=ps.saveMultipleProductDataService(products);
						if(a1.length>0) {
							System.out.println(a1.length+" Product table row effected");
						}
						else
						{
							System.out.println("no row data effeced");
						}
						}
						default:
							throw new IllegalArgumentException("Unexpected value: " + choice1);
						}
					}
				}

				else
					System.out.println("login not successfully");
				break;
			}

			// this is for User Section

			case 2: {

				System.out.println("enter the emailId");
				String email = sc.next();
				System.out.println("enter the password");
				String password = sc.next();
				int uservalidation = us.checkUserValidationService(email, password);
				if (uservalidation == 1) {
					System.out.println("user login successfully");
					while (true) {
						System.out.println("===============================================");

						System.out.println("enter the choice");
						System.out.println("1.for search product by name\n2.for full product Detail");
						int choiceforuser = sc.nextInt();
						switch (choiceforuser) {
						case 1: {
							System.out.println("enter the product name");
							String name = sc.next();
							Product product = us.searchProductByNameService(name);
							System.out.println(product);
							break;
						}
						case 2: {
							List<Product> fullproductdetail = us.fullProductDetail();
							for (Product x : fullproductdetail) {
								System.out.println(x);
							}
							 System.out.println("================================================");
							break;
						}
						default:
							throw new IllegalArgumentException("Unexpected value: " + choiceforuser);
						}
                          
					}
				} else {
					System.out.println("user login not successfull");
				}
				break;
			}
			

			default:
				throw new IllegalArgumentException("Unexpected value: " + choiceforlogin);
			}
			
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
			
		
		}
	}

}
