package com.happysystems.dao;

import com.happysystems.model.Recharge;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import org.hibernate.criterion.Projections;
import org.hibernate.service.ServiceRegistry;

import java.util.List;


 

public class RechargeDAO	{
	
	private Configuration configuration;
	private SessionFactory sessionFactory;

	private static RechargeDAO instance = new RechargeDAO();

	public static RechargeDAO getInstance()	{
		return instance;
	}

	private RechargeDAO()	{
		configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry =new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public List<Recharge> getHistory(int start, int end)	{
		Session session = sessionFactory.openSession();
		try	{
			Query qry = session.createQuery("from Recharge r order by r.id desc ");
			return getHistory(session, qry, start, end);
		}finally	{
				session.close();
		}
	}
	
	
	public List<Recharge> getHistory(String search, int start, int end, int [] filteredLength)	{
		Session session = sessionFactory.openSession();
		try	{
			search = "'%"+search+"%'";
			Query cqry = session.createQuery("select count(*) from Recharge r where r.id like "+search+ " OR r.operator like "+search+" OR r.number like "+search+" OR r.amount like "+search+" OR r.response like "+search+" order by r.id desc");
			filteredLength[0] = (int)((Long)cqry.uniqueResult()).longValue();
			Query qry = session.createQuery("from Recharge r where r.id like "+search+ " OR r.operator like "+search+" OR r.number like "+search+" OR r.amount like "+search+" OR r.response like "+search+" order by r.id desc");
			return getHistory(session, qry, start, end);
		}finally	{
			session.close();
		}
	}

	private List<Recharge> getHistory(Session session, Query qry, int start, int end)	{
		 qry.setFirstResult(start);
		 qry.setMaxResults(end);
		 List<Recharge> list = qry.list();
		 for(Recharge r : list)	r.getOrderId();
		 return list;
	}

	public long getTotal()	{
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Recharge.class);
        criteria.setProjection(Projections.rowCount());
        return (Long)criteria.uniqueResult();
	}

	public void saveRecharge(long number, double amount, String operator, String response)	{
         Session session = sessionFactory.openSession();
         Transaction transaction = session.beginTransaction();
         Recharge rc = new Recharge();
         rc.setNumber(number);
         rc.setAmount(amount);
         rc.setOperator(operator);
		 rc.setResponse(response);
         session.save(rc);
         transaction.commit();
	}
}
