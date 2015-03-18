package communication;

import java.util.ArrayList;
import java.util.List;

public class MyPackage {
	private int type;
	private List<Object> items;
	
	public MyPackage(int type) {
		super();
		this.type = type;
		this.items = new ArrayList<Object>();
	}

	public void add(Object item) {
		this.items.add(item);
	}
	
	public int getType() {
		return type;
	}
	public List<Object> getItems() {
		return items;
	}
	
	
	
}
