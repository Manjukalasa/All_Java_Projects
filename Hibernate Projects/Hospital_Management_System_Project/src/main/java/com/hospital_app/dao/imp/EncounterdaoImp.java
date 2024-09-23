package com.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hospital_app.dao.Encounterdao;
import com.hospital_app.dto.Branch;
import com.hospital_app.dto.Encounter;

public class EncounterdaoImp implements Encounterdao {
		public Encounter saveEncounter(int bid, Encounter encounter) {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			Branch branch=entityManager.find(Branch.class, bid);
			if(branch!=null)
			{
				entityTransaction.begin();
				entityManager.merge(branch);
				entityTransaction.commit();
				return encounter;
			}
			else
			{
				return null;
			}
			
		}
	
		public Encounter getEncounterId(int eid) {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			Encounter encounter=entityManager.find(Encounter.class, eid);
			return encounter;
		}

		public boolean deleteEncounterId(int eid) {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			Encounter encounter=entityManager.find(Encounter.class, eid);
			if(encounter!=null)
			{
				entityTransaction.begin();
				entityManager.remove(encounter);
				entityTransaction.commit();
				return true;
			}
			else
			{
				return false;
			}
		}	
		
		public Encounter updateEncounterId(int eid, Encounter encounter) {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			Encounter encounter1=entityManager.find(Encounter.class, eid);
			if(encounter1!=null)
			{
				encounter1.setDateofjoin(encounter.getDateofjoin());
				encounter1.setDdischarge(encounter.getDdischarge());
				entityTransaction.begin();
				entityManager.merge(encounter1);
				entityTransaction.commit();
				return encounter1;
			}
			else
			{
			return null;
			}
			
		}
		public List<Encounter> getAllEncounter() {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			Query query=entityManager.createQuery("select s from Encounter s");
			List<Encounter> encounter=query.getResultList();
			return encounter;
			
		}
}
