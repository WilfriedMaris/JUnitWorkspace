package be.vdab.entities;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

public class RekeningTest {
	private Rekening rekening;
	
	@Before
	public void before(){
		rekening = new Rekening();
	}

	@Test
	public void hetSaldoVanEenNieuweRekeningIsNul() {
		assertEquals(0, rekening.getSaldo().compareTo(BigDecimal.ZERO));
	}
	
	@Test
	public void saldoVanRekeningMetEenStortingisGelijkAanDeStorting(){
		BigDecimal bedrag = BigDecimal.valueOf(200);
		rekening.storten(bedrag);
		assertEquals(0, rekening.getSaldo().compareTo(bedrag));
	}
	
	@Test
	public void saldoRekeningMetTweeStortingenIsGelijkAanSomStortingen(){
		rekening.storten(BigDecimal.valueOf(100));
		rekening.storten(BigDecimal.valueOf(350));
		assertEquals(0, rekening.getSaldo().compareTo(BigDecimal.valueOf(450)));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void hetBedragVanEenStortingMagNietNulZijn(){
		rekening.storten(BigDecimal.ZERO);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void hetBedragVanEenStortingMagNietNegatiefZijn(){
		rekening.storten(BigDecimal.valueOf(-1));
	}
	
	@Test(expected = NullPointerException.class)
	public void hetBedragVanEenStortingMagNietNullZijn(){
		rekening.storten(null);
	}
	

}
