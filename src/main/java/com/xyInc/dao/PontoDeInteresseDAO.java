package com.xyInc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xyInc.entity.PontoDeInteresse;
import com.xyInc.util.HibernateConnector;

public class PontoDeInteresseDAO {

	public List<PontoDeInteresse> listaPontosDeInteresse() {
		Session session = HibernateConnector.getInstance().getSession();
		Criteria cri = session.createCriteria(PontoDeInteresse.class);

		List<PontoDeInteresse> lista = (List<PontoDeInteresse>) cri.list();
		session.close();

		return lista;
	}
	
	public Long save(PontoDeInteresse poi) throws HibernateException{
		Session session = HibernateConnector.getInstance().getSession();
		Transaction t = session.beginTransaction();
		Long id = (Long) session.save(poi);
		t.commit();
		session.close();
		return id;
	}
	
	public void saveOrUpdate(PontoDeInteresse poi) throws HibernateException{
		Session session = HibernateConnector.getInstance().getSession();
		Transaction t = session.beginTransaction();
		session.saveOrUpdate(poi);
		t.commit();
		session.close();
	}

}
