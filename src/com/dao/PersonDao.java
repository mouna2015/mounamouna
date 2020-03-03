package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Person;
import com.util.HibernateUtil;

public class PersonDao {
	
	public void addPerson(Person person)
    {
        Transaction trans=null;
        Session session= HibernateUtil.currentSession().getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            session.save(person);
            trans.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
	 public void deletePerson(int id)
	    {
	        Transaction trans=null;
	        Session session= HibernateUtil.currentSession().getSessionFactory().openSession();
	        try 
	        {
	            trans=session.beginTransaction();
	            Person pr =(Person)session.load(Person.class, new Integer(id));
	            session.delete(pr);
	            trans.commit();
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
	    }
	 public List<Person> getbyID(int sno)
	    {
	        Person person =new Person();
	        List<Person> person1=new ArrayList();
	       
	         Transaction trans=null;
	        Session session=HibernateUtil.currentSession().getSessionFactory().openSession();
	        try 
	        {
	            trans=session.beginTransaction();
	            Query query=session.createQuery("from Person where id= :id");
	            query.setInteger("id", sno);
	            person=(Person)query.uniqueResult();
	            person1=query.list();
	            
	            trans.commit();
	        }
	        catch(Exception e)
	        {
	            
	        }
	        return person1;
	    }
	 public void updatePerson(Person person)
	    {
	        Transaction trans=null;
	        Session session=HibernateUtil.currentSession().getSessionFactory().openSession();
	        try 
	        {
	            trans=session.beginTransaction();
	            session.update(person);
	            trans.commit();
	        }
	        catch(Exception e)
	        {
	            
	        }
	        
	    }
	 public List<Person> retrievePerson()
	    {
	       
	        List pr=new ArrayList();
	        Person pr1=new Person();
	        Transaction trans=null;
	        Session session=HibernateUtil.currentSession().getSessionFactory().openSession();
	        try
	        {
	            trans=session.beginTransaction();
	            Query query=session.createQuery("from Person");
	           pr=query.list();
	            pr.add(pr1.getName());
	            pr.add(pr1.getCountry());
	           
	         
	            trans.commit();
	            
	        }
	        catch(Exception e)
	        {
	            
	        }
	        return pr;
	    }

}
