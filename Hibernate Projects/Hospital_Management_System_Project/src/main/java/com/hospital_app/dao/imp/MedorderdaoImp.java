package com.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hospital_app.dao.Medorderdao;
import com.hospital_app.dto.Encounter;
import com.hospital_app.dto.Medorder;

public class MedorderdaoImp implements Medorderdao {

	public Medorder saveMedorder(int eid, Medorder medorder) {
		EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Encounter encounter=entityManager.find(Encounter.class, eid);

		if(encounter!=null)
		{
			entityTransaction.begin();
			entityManager.persist(medorder);
			entityTransaction.commit();
			return medorder;
		}
		else
		{
			return null;
		}

	}

	public Medorder getMedorderId(int mid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Medorder medorder =entityManager.find(Medorder.class, mid);
		return medorder;
	}


	public boolean deleteMedorderId(int mid) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Medorder medorder =entityManager.find(Medorder.class, mid);
	if(medorder!=null)
	{
		entityTransaction.begin();
		entityManager.remove(medorder);
		entityTransaction.commit();
		return true;
	}
	else
	{
		return false;
	}
}

	public Medorder updateMedorderId(int mid, Medorder medorder) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Medorder medorder1 =entityManager.find(Medorder.class, mid);
		if(medorder1!=null)
		{
			medorder1.setDname(medorder.getDname());
			medorder1.setOrderdate(medorder.getOrderdate());
			
			entityTransaction.begin();
			entityManager.merge(medorder1);
			entityTransaction.commit();
			return medorder1;
		}
		else
		{
			return null;
		}
	}

	public List<Medorder> getAllMedorder() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select s from Medorder s");
		List<Medorder> medorder=query.getResultList();
		return medorder;
	}


	public List<Medorder> getMedorderByDoctorname(String name) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select s from Medorder s where name=?");
		List<Medorder> medorder=query.getResultList();
		return medorder;
	}
	public List<Medorder> getMedorderBydate(String date) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select s from Medorder s where date=?");
		List<Medorder> medorder=query.getResultList();
		return medorder;
	}


}
