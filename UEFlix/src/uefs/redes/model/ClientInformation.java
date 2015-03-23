package uefs.redes.model;

public class ClientInformation {
	
	
	private String name,login,password;

	
	public ClientInformation(String name, String login, String password)
	{
	
		this.name=name;
		this.login = login;
		this.password =password;
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
