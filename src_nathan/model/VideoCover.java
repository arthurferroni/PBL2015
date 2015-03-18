package model;

public class VideoCover {
	private String name;
	private String []keyWords;
	private int type;
	private String description;
	private String quality;
	private int id;
	
	public VideoCover(String name, String[] keyWords, int type,
			String description, String quality, int id) {
		super();
		this.name = name;
		this.keyWords = keyWords;
		this.type = type;
		this.description = description;
		this.quality = quality;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String[] keyWords) {
		this.keyWords = keyWords;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
