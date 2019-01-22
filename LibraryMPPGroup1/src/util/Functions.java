package util;

public enum Functions {
	CHEKOUTBOOK(0),
	ADD_NEW_MEMBER(1),
	EDIT_MEMBER(2),
	ADD_NEW_BOOK(3);

	private int value;

    public int  getValue() {
        return value;
    }

    Functions(int value){
        this.value = value;
    }
}
