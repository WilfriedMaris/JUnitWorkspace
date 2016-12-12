package be.vdab.services;

import java.math.BigDecimal;

import be.vdab.entities.Land;
import be.vdab.repositories.LandRepository;

	public class LandService {
	private final LandRepository landRepository;
	
	public LandService(LandRepository landRepository){
		this.landRepository = landRepository;
	}
	
	public BigDecimal findVerhoudingOppervlakteLandTovOppervlakteAlleLanden(String landcode){
		Land land = landRepository.read(landcode);
		int oppervlakteAlleLanden = landRepository.findOpperlakteAlleLanden();
		return new BigDecimal(land.getOppervlakte()).divide(BigDecimal.valueOf(oppervlakteAlleLanden));
	}
	
}