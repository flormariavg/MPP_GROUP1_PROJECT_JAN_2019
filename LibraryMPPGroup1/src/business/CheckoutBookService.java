package business;

import dataaccess.BookDAO;
import dataaccess.MemberDAO;
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
	
	public boolean createCheckoutRecord(Member member, Book book) {
		if(bookDAO.update(book)) {
			memberDAO.update(member);
			return true;
		}else
		return false ;
	}


}
