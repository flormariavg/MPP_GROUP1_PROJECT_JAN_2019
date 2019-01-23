package business;

import java.util.List;

import dataaccess.MemberDAO;
import model.Member;

public class MemberService {

	MemberDAO memberDAO = new MemberDAO();
	public boolean addNewMember(Member member) {

		if (member == null)
			return false;
		return memberDAO.create(member);
	}

	public List<Member> getMemberListFromDB() {

		return (List<Member>) memberDAO.findAll();
	}
}
