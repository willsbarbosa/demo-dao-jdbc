package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Department department = new Department(2, null);
		
		
		System.out.println("=== TEST 1 : Seller findByID");
		Seller seller = sellerDao.findById(3);
		
		System.out.println("\n\n=== TEST 2 : Seller findByDepartment");
		List<Seller> listSeller = sellerDao.findByDepartment(new Department(2, null));
		for (Seller s : listSeller) {
			System.out.println(s);
		}
		
		System.out.println("\n\n=== TEST 3 : Seller findAll");
		List<Seller> listSellerAll = sellerDao.findAll();
		for (Seller s : listSellerAll) {
			System.out.println(s);
		}
		
		System.out.println("\n\n=== TEST 4 : Seller INSERT");
		Seller sellerInsert = new Seller(null, "William", "will@gmail.com", new Date(), 4000.00, department);
		sellerDao.insert(sellerInsert);
		System.out.println("Inserted !! New ID : " + sellerInsert.getId());
		
		
		System.out.println("\n\n=== TEST 5 : Seller UPDATE");
		Seller sellerUpdate = sellerDao.findById(11);
		sellerUpdate.setName("Will");
		sellerDao.update(sellerUpdate);
		
	}
}
