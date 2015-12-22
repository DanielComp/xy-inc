package com.xyInc.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.xyInc.entity.PontoDeInteresse;
import com.xyInc.util.PontoDeInteresseUtils;

import junit.framework.Assert;

public class TesteLogica {
	
	@Test
	public void testaFiltroDistancia() {
		PontoDeInteresse poi0 = new PontoDeInteresse(0L, "poi0", 10,10); //dist 0
		PontoDeInteresse poi1 = new PontoDeInteresse(1L, "poi1", 10,11); //dist 1
		PontoDeInteresse poi2 = new PontoDeInteresse(2L, "poi2", 10,12); //dist 2
		PontoDeInteresse poi3 = new PontoDeInteresse(3L, "poi3", 11,11); //dist 1.41
		PontoDeInteresse poi4 = new PontoDeInteresse(4L, "poi4", 11,12); //dist 2.23
		PontoDeInteresse poi5 = new PontoDeInteresse(5L, "poi5", 12,11); //dist 2.23
		PontoDeInteresse poi6 = new PontoDeInteresse(6L, "poi6", 12,12); //dist 2.82

		List<PontoDeInteresse> listaOriginal = new ArrayList<PontoDeInteresse>();
		listaOriginal.add(poi1); 
		listaOriginal.add(poi2); 
		listaOriginal.add(poi3); 
		listaOriginal.add(poi4); 
		listaOriginal.add(poi5); 
		listaOriginal.add(poi6); 
		
		List<PontoDeInteresse> listaFiltrada = new ArrayList<PontoDeInteresse>();
		listaFiltrada = PontoDeInteresseUtils.filtraDistancia(listaOriginal, poi0, 1);
		Assert.assertTrue(listaFiltrada.contains(poi1));
		Assert.assertEquals(listaFiltrada.size(), 1);
		
		listaFiltrada = PontoDeInteresseUtils.filtraDistancia(listaOriginal, poi0, 2.3);
		Assert.assertTrue(listaFiltrada.contains(poi5));
		Assert.assertFalse(listaFiltrada.contains(poi6));
		Assert.assertEquals(listaFiltrada.size(), 5);
	}

}
