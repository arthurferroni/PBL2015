package uefs.redes.property;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class MovieProperty {
	
	private SimpleStringProperty video;
	private SimpleStringProperty name;

	public MovieProperty(String video, String name) {
		this.video = new SimpleStringProperty(video);
		this.name = new SimpleStringProperty(name);
	}
	
	public String getVideo() {
		return video.get();
	}
	
	public void setVideo(String produto) {
		this.video.set(produto);
	}
	
	public String getName() {
		return name.get();
	}
	
	public void setName(String name) {
		this.name.set(name);
	}

}
