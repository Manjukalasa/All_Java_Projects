package com.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hospital_app.dao.Itemdao;
import com.hospital_app.dto.Branch;
import com.hospital_app.dto.Items;
import com.hospital_app.dto.Medorder;

public class ItemdaoImp implements Itemdao {

	public Items saveItem(int mid, Items item) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Medorder medOrder=entityManager.find(Medorder.class, mid);
		if(medOrder!=null)
		{
			entityTransaction.begin();
			entityManager.merge(medOrder);
			entityTransaction.commit();
			return item;
		}
		else
		{
			return null;
		}
	}

	public Items getItemsId(int iid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Items item=entityManager.find(Items.class, iid);
		return item;
	}

	public boolean deleteItemsId(int iid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Items item=entityManager.find(Items.class, iid);
	if(item!=null)
	{
		entityTransaction.begin();
		entityManager.remove(item);
		entityTransaction.commit();
		return true;
	}
	else
	{
		return false;
	}
}
	public Items updateItemsId(int iid, Items items) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Items items1=entityManager.find(Items.class, iid);
		if(items1!=null)
		{
			items1.setName(items.getName());
			items1.setCost(items.getCost());
			items.setQuantity(items.getQuantity());
			
			entityTransaction.begin();
			entityManager.merge(items1);
			entityTransaction.commit();
			return items1;
		}
		else
		{
		return null;
		}
	}
	public List<Items> getAllItems() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query= entityManager.createQuery("select s from Items s");
		List<Items> item=query.getResultList();
		return item;
	}
}
