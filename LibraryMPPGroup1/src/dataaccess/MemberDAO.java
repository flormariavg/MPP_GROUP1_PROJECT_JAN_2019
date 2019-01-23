package dataaccess;


import java.util.HashMap;

import model.Book;
import model.Member;
import util.WriteReadFileUtil;

public class MemberDAO extends GenericDAO<Member>{

	@Override
	public Class getClazz() {
		// TODO Auto-generated method stub
		return Member.class;
	}


}
