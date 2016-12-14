package be.vdab.taken;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

public class WinstServiceTest {
	private WinstService winstService;
	private OpbrengstRepository opbrengstRepo;
	private KostRepository kostRepo;
	
	@Before
	public void before(){
		opbrengstRepo = mock(OpbrengstRepository.class);
		when(opbrengstRepo.findTotaleOpbrengst()).thenReturn(BigDecimal.valueOf(2500));
		kostRepo = mock(KostRepository.class);
		when(kostRepo.findTotaleKost()).thenReturn(BigDecimal.valueOf(1999));
		winstService = new WinstService(opbrengstRepo, kostRepo);
	}
	
	@Test
	public void winstMoet501Zijn(){
		assertEquals(BigDecimal.valueOf(501), winstService.getWinst());
		verify(opbrengstRepo).findTotaleOpbrengst();
		verify(kostRepo).findTotaleKost();
	}

}
