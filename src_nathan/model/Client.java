package model;

import java.util.ArrayList;
import java.util.List;

public class Client {
	private String login;
	private String password;
	private List<VideoCover> lastWatchedVideos;
	
	public Client(String login, String password) {
		super();
		this.login = login;
		this.password = password;
		this.lastWatchedVideos = new ArrayList<VideoCover>();
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<VideoCover> getLastWatchedVideos() {
		return this.lastWatchedVideos;
	}
	
	public void addHistory(VideoCover video){
		if(this.lastWatchedVideos.size() >= 5){
			this.lastWatchedVideos.remove(0);
		}
		this.lastWatchedVideos.add(video);
	}
	
}
