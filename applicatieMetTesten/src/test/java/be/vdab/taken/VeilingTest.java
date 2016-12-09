package be.vdab.taken;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VeilingTest {
	private Veiling veiling;
	
	@Before
	public void before(){
		veiling = new Veiling();
	}

	@Test
	public void nogGeenBodDanBodIsNul() {
		assertEquals(0,veiling.getHoogsteBod());
	}
	
	@Test
	public void EenBodUitgevoerdHoogsteBodIsGelijkAanDitBod(){
		veiling.doeBod(100);
		assertEquals(100, veiling.getHoogsteBod());
	}
	
	@Test
	public void MeerdereBiedingenHoogsteBodIsGelijkAanHoogsteBieding(){
		veiling.doeBod(100);
		veiling.doeBod(400);
		veiling.doeBod(200);
		assertEquals(400, veiling.getHoogsteBod());
	}

}
