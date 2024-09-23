package com.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hospital_app.dao.Addressdao;
import com.hospital_app.dto.Address;
import com.hospital_app.dto.Branch;

public class AddressdaoImp implements Addressdao {

	public Address saveAddress(int bid, Address address) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Branch branch=entityManager.find(Branch.class, bid);
		if(branch!=null)
		{
			entityTransaction.begin();
			entityManager.merge(branch);
			entityTransaction.commit();
			return address;
		}
		else
		{
			return null;
		}
	}
	public Address getAddressId(int aid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Address address=entityManager.find(Address.class, aid);
		return address;
	}

	public boolean deleteAddressId(int aid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Address address=entityManager.find(Address.class, aid);
		if(address!=null)
		{
			entityTransaction.begin();
			entityManager.remove(address);
			entityTransaction.commit();
			return true;
		}
		else
		{
			return false;
		}
	}


	public Address updateEncounterId(int aid, Address address) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Address address1=entityManager.find(Address.class, aid);
		if(address1!=null)
		{
			address1.setStreet(address.getStreet());
			address1.setPin(address.getPin());
			address1.setState(address.getState());
			address1.setCountry(address.getCountry());
			entityTransaction.begin();
			entityManager.merge(address1);
			entityTransaction.commit();
			return address1;
		}
		else
		{
			return null;
		}
	}

	public List<Address> getAllAddress() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select s from Address s");
		List<Address> address=query.getResultList();
		return address;
	}
}
