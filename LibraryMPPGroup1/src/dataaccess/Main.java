package dataaccess;


import java.util.ArrayList;
import java.util.List;

import business.CheckoutBookService;
import model.Address;
import model.Administrator;
import model.Book;
import model.BookCopy;
import model.Librarian;
import model.Login;
import model.Member;

public class Main {
	public static void main(String[] args) {

/*
		CheckoutBookService service = new CheckoutBookService();

		Member member= new Member("123","Flor", "Vargas", "999999", new Address("Street", "555", "Farfield", "Iowa"), "123");
		service.createMember(member);
		System.out.println(service.getMember("123"));

		Book book= new Book("123", "123",null , "availability", 21);
		service.createBook(book);
		System.out.println(service.getBook("123"));*/

		testOerdue ();
	}


	public static void testOerdue () {
		
		CheckoutBookService boCheckoutBookService= new CheckoutBookService();
		Book bookTest= boCheckoutBookService.getBook("book1");
		BookCopy bookCopy= bookTest.getBooks().get(0);
		
		System.out.println(bookTest);

	}
	public static void createBookData () {



	}
	public static void createLoginAccountData () {

			List<Login> loginList = new ArrayList<>();
			Login user = new Login("lib", "111");
			user.addRole(new Librarian());

			Login user1 = new Login("admin", "111");
			user1.addRole(new Administrator());

			Login user2 = new Login("both", "111");
			user2.addRole(new Administrator());
			user2.addRole(new Librarian());
			loginList.add(user);
			loginList.add(user1);
			loginList.add(user2);
			LoginDAO.createLoginAccountData(loginList);

	}

}
