package business;

import dataaccess.BookDAO;
import dataaccess.MemberDAO;
import model.Address;
import model.Book;
import model.Member;

public class CheckoutBookService {

	MemberDAO memberDAO = new MemberDAO();
	BookDAO bookDAO= new BookDAO();

	public CheckoutBookService() {
		// TODO Auto-generated constructor stub
	}

	public CheckoutBookService(String isbn,String idMember ) {
		// TODO Auto-generated constructor stub
		getBook(isbn);
		getMember(idMember);

	}
	public boolean createMember(Member member) {
		return memberDAO.create(member);
	}

	public Member getMember(String id) {
		return memberDAO.findById(id);
	}

	public boolean createBook(Book book) {
		return bookDAO.create(book);
	}
	public Book getBook(String isbn) {
		return bookDAO.findByISBN(isbn);
	}
	public static void main(String[] args) {
		CheckoutBookService service = new CheckoutBookService();

		Member member= new Member("123","Flor", "Vargas", "999999", new Address("Street", "555", "Farfield", "Iowa"), "123");
		service.createMember(member);
		System.out.println(service.getMember("123"));

		Book book= new Book("123", "Title",null , "availability");
		service.createBook(book);
		System.out.println(service.getBook("1234"));


	}


}
