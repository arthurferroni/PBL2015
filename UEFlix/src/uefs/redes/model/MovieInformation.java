package uefs.redes.model;

import java.util.ArrayList;

public class MovieInformation {
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	private String name_file = null; 
	private ArrayList< String > tags_file = new ArrayList< String >();
	private String description = null;
	private int quantity = 0;
	private String category = null;
	
	
	public MovieInformation( String name, ArrayList< String > tags, String description,int quantity,String category )
	{
		this.name_file = name;
		this.tags_file = tags;
		this.description = description;
		this.quantity = quantity;
		this.category = category;
	}
	public MovieInformation( String name, String description,int quantity,String category )
	{
		this.name_file = name;
		this.description = description;
		this.quantity = quantity;
		this.category = category;
	}
	public String getName_file() {
		return name_file;
	}
	public void setName_file(String name_file) {
		this.name_file = name_file;
	}
	public ArrayList<String> getTags_file() {
		return tags_file;
	}
	public void setTags_file(ArrayList<String> tags_file) {
		this.tags_file = tags_file;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	

}
