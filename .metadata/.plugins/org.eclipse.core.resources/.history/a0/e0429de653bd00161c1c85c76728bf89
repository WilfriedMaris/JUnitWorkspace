package be.vdab.valueobjects;

public class Jaar {
	public final int jaar;
	
	public Jaar(int jaar){
		this.jaar = jaar;
	}
	
	public boolean isSchrikkeljaar(){
		if(jaar % 400 == 0){
			return true;
		}
		if(jaar % 100 == 0){
			return false;
		}
		return jaar % 4 == 0;
	}
}
