package model;

public class Video {
	private int id;
	private String path;
	
	public Video(int id, String path) {
		super();
		this.id = id;
		this.path = path;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}
	
}
