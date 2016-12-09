package be.vdab.taken;

public class Veiling {
	private int hoogste;
	
	public void doeBod(int bedrag){
		if(hoogste < bedrag){
			hoogste = bedrag;
		}
	}
	
	public int getHoogsteBod(){
		return hoogste;
	}

}
