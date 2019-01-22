package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import util.Functions;

public class Librarian extends PersonGiveProfessor implements Role, Serializable {

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

}
