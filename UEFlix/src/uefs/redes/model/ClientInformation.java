package uefs.redes.model;

import java.io.Serializable;
import java.util.ArrayList;

public class ClientInformation implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name,login,password;
	private ArrayList<MovieInformation>history = new  ArrayList<MovieInformation>();
	
	public ClientInformation(String name, String login, String password)
	{
	
		this.name=name;
		this.login = login;
		this.password =password;
	}
	public ClientInformation( String login, String password)
	{
	
		this.name="NULL";
		this.login = login;
		this.password =password;
	}
	public ArrayList<MovieInformation> getMyMovies()
        {
            return history;
        }
	public void addMoiveHistory(MovieInformation x )
	{
            int i = 0 ;
		for(MovieInformation y:this.history)
		{
			if(y.getName_file().equals(x.getName_file()))
			{
				history.remove(x);
				break;
			}
		}
            history.add(x);
		
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof ClientInformation )
		{
			ClientInformation x = (ClientInformation) o;
			if( x.getLogin().equals(this.getLogin()) &&
				x.getPassword().equals(this.getPassword()))
			return true;
		}
		return false;
	}
	

	
	
}
