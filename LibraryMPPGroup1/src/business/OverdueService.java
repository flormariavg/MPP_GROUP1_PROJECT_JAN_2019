package business;

import java.util.ArrayList;
import java.util.List;

import dataaccess.BookDAO;
import dataaccess.MemberDAO;
import model.Book;
import model.BookCopy;
import model.CheckoutEntry;
import model.Member;

public class OverdueService {

	private MemberDAO memberDAO = new MemberDAO();
	private BookDAO bookDAO = new BookDAO();

	public List<OverdueData> searchBookOverdue(String isbn) {

		List<Member> members = memberDAO.findAll();

		Book book = bookDAO.findByISBN(isbn);

		List<OverdueData> data = new ArrayList<>();

		if (members != null) {
			for (Member member : members) {
				if (member.getCheckoutRecord() != null && member.getCheckoutRecord().getCheckoutEntries() != null) {
					for (CheckoutEntry ce : member.getCheckoutRecord().getCheckoutEntries()) {
						if(isbn.equals(ce.getBookCopy().getIsbn()))
						data.add(
								new OverdueData(isbn, book.getTitle(), String.valueOf(ce.getBookCopy().getCopyNumber()),
										member.getLastName() + " " + member.getFirstName(), ce.getDueDateFormatted()));
					}
				}
			}
		}

		return data;
	}

	public static void main(String[] args) {
		OverdueService service = new OverdueService();
		service.searchBookOverdue("123");
	}
}
