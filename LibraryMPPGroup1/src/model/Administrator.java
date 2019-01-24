package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import util.Functions;
import util.StringUtil;

public class Administrator extends Person implements Role,  Serializable {

	List<Integer> functionList;

	public void editMember(Member member) {
	}

	public void addNewMember(Member member) {

	}
	public Administrator() {

		functionList = new ArrayList<Integer>();
		functionList.add(Functions.ADD_NEW_BOOK.getValue());
		functionList.add(Functions.EDIT_MEMBER.getValue());
		functionList.add(Functions.ADD_NEW_MEMBER.getValue());
	}
	@Override
	public List<Integer> getListFunction() {

		return functionList;
	}

	@Override
	public String getRoleName() {
		// TODO Auto-generated method stub
		return StringUtil.ADMIN_ROLE;
	}

}
