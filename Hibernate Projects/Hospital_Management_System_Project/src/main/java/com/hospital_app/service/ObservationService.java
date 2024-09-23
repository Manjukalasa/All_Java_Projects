package com.hospital_app.service;

import java.util.List;

import com.hospital_app.dao.imp.ObservationdaoImp;
import com.hospital_app.dto.Observation;

public class ObservationService 
{
	public void saveObservation(int eid, Observation observation) 
	{
		ObservationdaoImp daoImp =new ObservationdaoImp();
		Observation observation1 = daoImp.saveObservation(eid, observation);
		if(observation1!=null)
		{
			System.out.println("Data Saved");
		}
		else
		{
			System.out.println("Unfortunately Data Not Saved");
		}
		
	}
	public  Observation getObservationbyId(int oid)
	{
		ObservationdaoImp daoImp =new ObservationdaoImp();
		Observation observation1 = daoImp.getObservationId(oid);
		if(observation1!=null)
		{
			return observation1;
		}
		else
		{
			return null;
		}
	}
	public void deleteObservationbyId(int oid)
	{
		ObservationdaoImp daoImp =new ObservationdaoImp();
		boolean flag = daoImp.deleteObservationId(oid);
		if(flag)
		{
			System.out.println("data deleted");
		}
		else
		{
			System.out.println("data not found");
		}
	}
	public Observation updateObservationbyid(int oid, Observation observation)
	{
		ObservationdaoImp daoImp =new ObservationdaoImp();
		Observation observation1= daoImp.updateObservationId(oid, observation);
		if(observation1!=null)
		{
			return observation1;
		}
		else
		{
			return null;
		}
		
	}
	public List<Observation> getAllObservation()
	{
		ObservationdaoImp daoImp =new  ObservationdaoImp();
		List<Observation> list=daoImp.getAllObservation();
			if(list!=null)
			{
			
			return list;
		}
		else
		{
			return null;
		}
	}
	public List<Observation>getObservationBydoctorName(String dname)
	{
		ObservationdaoImp daoImp =new  ObservationdaoImp();
		List<Observation> list=daoImp.getObservationByDoctorname(dname);
			if(list!=null)
			{
			
			return list;
		}
		else
		{
			return null;
		}
	}

}