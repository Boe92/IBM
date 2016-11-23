package com.alfasoft.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alfasoft.entita.Fattura;
import com.alfasoft.util.HibernateUtil;

public class FatturaDao {
	
	public Fattura _select(String codice) {
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		Fattura fattura = null;
		try{
			tx=session.getTransaction();
			tx.begin();
			
			Query query = (Query) session.createQuery("from Fattura where codice_fattura = :campo1"); 
			query.setString("campo1", codice);
			
			fattura = (Fattura) query.uniqueResult();
			
			tx.commit(); 
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return fattura;
	}
	
	@SuppressWarnings("unchecked")
	public List<Fattura> _selectAll() {
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		List<Fattura> listaFAttura = null;
		try{
			tx=session.getTransaction();
			tx.begin();
			
			listaFAttura = session.createQuery("from Fattura").list();	
			
			tx.commit(); 
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return listaFAttura;
	}
	
	public void _delete(int id) {
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		try{
			tx=session.getTransaction();
			tx.begin();
			
			Query query = (Query)session.createQuery("delete from Fattura where id = :campo1"); 
			query.setInteger("campo1", id);
			
			query.executeUpdate();
			
			tx.commit(); 
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	
	public void _update(Fattura f) {
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		try{
			tx=session.getTransaction();
			tx.begin();
			
			session.update(f);
			
			tx.commit(); 
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	
	public boolean _insert(Fattura f) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		boolean res = false;
		try{
			tx=session.getTransaction();
			tx.begin();
			
			session.persist(f);
			
			tx.commit(); 
			
			res = true;
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return res;
	}
}
