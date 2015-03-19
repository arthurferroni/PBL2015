package uefs.redes.define;

import java.io.Serializable;
import java.util.ArrayList;

public class Pack implements Serializable {
	
	private int CODE;
	private ArrayList< Object > INFO = new ArrayList< Object >();
	private int count=0;
	
	
	public Pack (int CODE){
		this.CODE = CODE;
		}
	public Pack (int CODE,ArrayList< Object > INFO ){
		this.CODE = CODE;
		this.INFO = INFO;
	}
	public int getCODE(){
		return this.CODE;
	}
	public void setCODE(int CODE){
		this.CODE = CODE;
	}
	public ArrayList<Object> getINFO(){
		return this.INFO;
	}
	public void setINFO(ArrayList<Object> INFO){
		this.INFO = INFO;
	}
	public void addOneByOne(Object o){
		this.INFO.add(o);		
	}
	
	
}
