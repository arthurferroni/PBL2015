package uefs.redes.define;

import java.io.Serializable;
import java.util.ArrayList;

public class Pack implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int CODE;
	private ArrayList< Object > INFO = new ArrayList< Object >();
	
	
	public Pack (int CODE){
		this.CODE = CODE;
		}
	public int getCODE(){
		return this.CODE;
	}
	public void setCODE(int CODE){
		this.CODE = CODE;
	}
	public void setINFO(ArrayList<Object> INFO){
		this.INFO = INFO;
	}
	public void addOneByOne(Object o){
		this.INFO.add(o);		
	}
	public ArrayList< Object > getINFO()
	{
		return this.INFO;
	}
	
	
}
