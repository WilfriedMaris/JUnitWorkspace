package be.vdab.services;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import be.vdab.entities.Land;
import be.vdab.repositories.LandRepository;
import static org.mockito.Mockito.*;

public class LandServiceTest {
	private LandRepository landRepository;
	private LandService landService;
	
	@Before
	public void before(){
		landRepository = mock(LandRepository.class);
		when(landRepository.findOpperlakteAlleLanden()).thenReturn(20);
		when(landRepository.read("B")).thenReturn(new Land("B", 5));
		when(landRepository.read("NL")).thenReturn(new Land("NL",6));
		when(landRepository.read("")).thenThrow(new IllegalArgumentException());
		landService = new LandService(landRepository);
	}
	
	@Test 
	public void findVerhoudingOppervlakteLandTovOppervlakteAlleLanden(){
		assertEquals(0, BigDecimal.valueOf(0.25).compareTo(
				landService.findVerhoudingOppervlakteLandTovOppervlakteAlleLanden("B")));
		verify(landRepository).findOpperlakteAlleLanden();
		verify(landRepository).read("B");
	}
}
