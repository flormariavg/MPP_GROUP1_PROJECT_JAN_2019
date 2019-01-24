package database;


import business.AddBookCopyService;
import business.CheckoutBookService;
import model.Address;
import model.Book;
import model.Member;

public class InitialiceData {
	
	public static void main(String[] args) {
	//		System.out.println(bookDAO.findById("ABCD", Book.class));
		
		//LoginDAO.createLoginAccountData();

	//BookService service = new BookService();
/*	Book book = new Book("title1","1234", null, "abc");
	System.out.println(service.createBook(book));*/
	
	CheckoutBookService service = new CheckoutBookService();

	Member member= new Member("123","Flor", "Vargas", "999999", new Address("Street", "555", "Farfield", "Iowa"), "123");
	service.createMember(member);
	System.out.println(service.getMember("123"));

	Book book= new Book("123", "123",null , "availability", 21);
	service.createBook(book);
	System.out.println(service.getBook("123"));
	
//	AddBookCopyService service = new AddBookCopyService();

	//service.bookDAO.create(new Book("123", "123", null, "123", 21));
}

}
