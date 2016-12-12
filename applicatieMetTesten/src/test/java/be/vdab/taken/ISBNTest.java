package be.vdab.taken;

import static org.junit.Assert.*;

import org.junit.Test;

public class ISBNTest {

	@Test (expected = IllegalArgumentException.class)
	public void isbnMet12CijfersIsVerkeerd() {
		new Isbn(978907617494L);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void isbnMet14CijfersIsVerkeerd() {
		new Isbn(97890761749487L);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void isbnMet977VooraanIsVerkeerd() {
		new Isbn(9779076174945L);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void isbnMet980VooraanIsVerkeerd() {
		new Isbn(9809076174945L);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void isbnControleIsVerkeerd() {
		new Isbn(9789084847812L);
	}
	
	@Test 
	public void isbnControleIsJuist() {
		new Isbn(9789048835157L);
	}
	
	@Test
	public void equalsOpTweeDezelfdeIsbnMoetTrueZijn(){
		assertEquals(new Isbn(9789026336898L), new Isbn(9789026336898L));
	}
	
	@Test
	public void equalsOpTweeVerschillendeIsbnMoetFalseZijn(){
		assertNotEquals(new Isbn(9789400508040L), new Isbn(9789026336898L));
	}
	
	@Test
	public void hashCodeOpTweeDezelfdeIsbnMoetGelijkZijn(){
		assertEquals(new Isbn(9789048835157L).hashCode(),
				new Isbn(9789048835157L).hashCode());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void isbnMagNietNegatiefZijn() {
		new Isbn(-9789084847812L);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void hetNummer0IsVerkeerd() {
	new Isbn(0L);
	}
	
	@Test
	public void toStringMoetHetNummerTeruggeven() {
	long nummer = 9789027439642L;
	assertEquals(nummer, Long.parseLong(new Isbn(nummer).toString()));
	}

}
