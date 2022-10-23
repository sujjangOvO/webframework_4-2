package chap2.ex2;

import java.util.ArrayList;
import java.util.List;

public class ContactDAO {
	ArrayList<Contact> clist;
	
	public ContactDAO() {
		clist = new ArrayList<Contact>();
	}
	
	public void insert(Contact item) {
		clist.add(item);
	}
	
	public List<Contact> getList(){
		return clist;
	}
	
}
