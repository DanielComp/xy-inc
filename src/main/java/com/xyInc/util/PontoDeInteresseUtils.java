package com.xyInc.util;

import java.util.ArrayList;
import java.util.List;

import com.xyInc.entity.PontoDeInteresse;


public class PontoDeInteresseUtils {
	
	public static List<PontoDeInteresse> filtraDistancia(List<PontoDeInteresse> listaPontos, PontoDeInteresse poi, double maxDist){
		List<PontoDeInteresse> result = new ArrayList<PontoDeInteresse>();
		for(PontoDeInteresse p : listaPontos){
			if(calculaDistancia(poi,p)<=maxDist){
				result.add(p);
			}
		}
		return result;
	}
	
	public static double calculaDistancia(PontoDeInteresse poi1, PontoDeInteresse poi2){
		if(poi1==null || poi2==null
				|| poi1.getX()==null || poi1.getY()==null
				|| poi2.getX()==null || poi2.getY()==null){
			throw new RuntimeException("Ponto de interesse com valor nulo.");
		}

		double x1 = poi1.getX().doubleValue();
		double x2 = poi2.getX().doubleValue();
		double y1 = poi1.getY().doubleValue();
		double y2 = poi2.getY().doubleValue();
		
		x1 -= x2;
        y1 -= y2;
        return Math.sqrt(x1 * x1 + y1 * y1);
	}
	
}
