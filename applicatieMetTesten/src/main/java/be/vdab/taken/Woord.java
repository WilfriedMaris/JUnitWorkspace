package be.vdab.taken;

public class Woord {
	private final String woord;
	
	public Woord(String woord){
		this.woord = woord;
	}
	
	public boolean isPalindroom(){
		String reverse = new StringBuilder(woord).reverse().toString();
		return reverse.equals(woord);
	}
	
}
