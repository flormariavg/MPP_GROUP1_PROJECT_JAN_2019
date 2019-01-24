package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import util.Functions;
import util.StringUtil;

public class Librarian extends Person implements Role, Serializable {

	List<Integer> functionList;
	public void checkoutBook() {

	}

	public Librarian() {
		functionList = new ArrayList<Integer>();
		functionList.add(Functions.CHEKOUTBOOK.getValue());
	}

	@Override
	public List<Integer> getListFunction() {
		return functionList;
	}

	@Override
	public String getRoleName() {

		 return StringUtil.LIBRARIAN_ROLE;
	}

}
