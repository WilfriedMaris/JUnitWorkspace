package be.vdab.taken;

public class Isbn {
	private final Long isbn;
	
	public Isbn(Long nummer){
		String num = nummer.toString();
		if(num.length() == 13){
			if(num.startsWith("978")||num.startsWith("979")){
				String oneven = num.substring(1) + num.substring(3) + num.substring(5) + 
						num.substring(7) + num.substring(9) + num.substring(11);
				String even = num.substring(2) + num.substring(4) + num.substring(6) + 
						num.substring(8) + num.substring(10) + num.substring(12);
				int somOneven = 0;
				int somEven = 0;
				for(int teller = oneven.length(); teller<0; teller--){
					somOneven = somOneven + oneven.charAt(teller);
					somEven = somEven + even.charAt(teller);
				}
				somEven = somEven * 3;
				Integer somBeide = somOneven + somEven;
				String naastHogerGet = somBeide.toString();
				while(naastHogerGet.charAt(naastHogerGet.length()-1) != 0){
					naastHogerGet = String.valueOf(Integer.parseInt(naastHogerGet) + 1);
				}
				Integer verschil = Integer.parseInt(naastHogerGet) - somBeide;
				if(verschil == 10){
					if(num.charAt(13) == 0){
						this.isbn = Long.parseLong(num);
					}else{
						throw new IllegalArgumentException("ISBN nummer eindigt niet met 0");
					}
				}else{
					if(num.charAt(13) == verschil){
						this.isbn = Long.parseLong(num);
					}else{
						throw new IllegalArgumentException("ISBN nummer eindigt niet met het verschil");
					}
				}
			}else{
				throw new IllegalArgumentException("ISBN nummer begint niet met 978 of 979");
			}
		}else{
			throw new IllegalArgumentException("ISBN nummer is geen 13 cijfers lang.");
		}
	}
	
	public String toString(){
		return isbn.toString();
	}

}