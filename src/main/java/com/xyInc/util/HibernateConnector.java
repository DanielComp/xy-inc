package com.xyInc.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
 
public class HibernateConnector {
    private static HibernateConnector me;
    private Configuration cfg;
    private SessionFactory sessionFactory;
 
    private HibernateConnector() throws HibernateException {
        cfg = new Configuration().configure();
 
    	ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
    	registry.applySettings(cfg.getProperties());
    	ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
    	sessionFactory = cfg.buildSessionFactory(serviceRegistry);
    }
 
    public static synchronized HibernateConnector getInstance() throws HibernateException {
        if (me == null) {
            me = new HibernateConnector();
        }
        return me;
    }
 
    public Session getSession() throws HibernateException {
        Session session = sessionFactory.openSession();
        if (!session.isConnected()) {
            this.reconnect();
        }
        return session;
    }
 
    private void reconnect() throws HibernateException {
    	ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
    	registry.applySettings(cfg.getProperties());
    	ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
        this.sessionFactory = cfg.buildSessionFactory(serviceRegistry);;
    }
}