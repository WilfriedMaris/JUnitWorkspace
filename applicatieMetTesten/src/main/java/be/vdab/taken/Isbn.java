package be.vdab.taken;

public class Isbn {
	private final Long isbn;

	public Isbn(Long nummer){
		String num = nummer.toString();
		if (nummer > 0) {
			if (num.length() == 13) {
				if (num.startsWith("978") || num.startsWith("979")) {
					//charAt begint van 0.
					int oneven = 0;
					int even = 0;
					int index = -1;
					for(int teller = 6; teller > 0; teller--){
						//char - '0' in talen die unicode gebruiken geeft de int waarde.
						oneven = oneven + num.charAt(++index)-'0';
						even = even + num.charAt(++index)-'0';
					}
					even = even * 3;
					Integer somBeide = oneven + even;
					Integer hogertiental = somBeide;
					while(hogertiental % 10 != 0){
						//hier verder gaan...
					}
//					String naastHogerGet = somBeide.toString();
//					while (naastHogerGet.charAt(naastHogerGet.length() - 1) != '0') {
//						naastHogerGet = String.valueOf(Integer.parseInt(naastHogerGet) + 1);
//					}
					Integer verschil = hogertiental - somBeide;
					if (verschil == 10) {
						if (num.charAt(13) == 0) {
							this.isbn = Long.parseLong(num);
						} else {
							throw new IllegalArgumentException("ISBN nummer eindigt niet met 0");
						}
					} else {
						if (num.charAt(13) == verschil) {
							this.isbn = Long.parseLong(num);
						} else {
							throw new IllegalArgumentException("ISBN nummer eindigt niet met het verschil");
						}
					}
				} else {
					throw new IllegalArgumentException("ISBN nummer begint niet met 978 of 979");
				}
			} else {
				throw new IllegalArgumentException("ISBN nummer is geen 13 cijfers lang.");
			}
		} else {
			throw new IllegalArgumentException("ISBN nummer is geen 13 cijfers lang.");
		}
	}

	public String toString() {
		return isbn.toString();
	}

}
