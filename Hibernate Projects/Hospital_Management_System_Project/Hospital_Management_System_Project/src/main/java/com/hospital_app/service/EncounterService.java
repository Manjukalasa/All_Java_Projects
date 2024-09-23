package com.hospital_app.service;

import java.util.List;

import com.hospital_app.dao.imp.EncounterdaoImp;
import com.hospital_app.dto.Encounter;

public class EncounterService {
	public void saveEncounter(int bid, Encounter encounter) 
	{
		EncounterdaoImp daoImp =new EncounterdaoImp();
		Encounter encounter1= daoImp.saveEncounter(bid, encounter);
		if(encounter1!=null)
		{
			System.out.println("Data Saved");
		}
		else
		{
			System.out.println("Unfortunately Data Not Saved");
		}
	}
	public  Encounter getEncounterbyId(int eid)
	{
		EncounterdaoImp daoImp =new  EncounterdaoImp();
		Encounter encounter1 = daoImp.getEncounterId(eid);
		if(encounter1!=null)
		{
			return encounter1;
		}
		else
		{
			return null;
		}
	}
	public void deleteEncounterbyId(int eid)
	{
		EncounterdaoImp daoImp =new  EncounterdaoImp();
		boolean flag = daoImp.deleteEncounterId(eid);
		if(flag)
		{
			System.out.println("data deleted");
		}
		else
		{
			System.out.println("data not found");
		}
	}
	public Encounter updateEncounterbyid(int eid, Encounter encounter)
	{
		EncounterdaoImp daoImp =new  EncounterdaoImp();
		Encounter encounter1= daoImp.updateEncounterId(eid, encounter);
		if(encounter1!=null)
		{
			return encounter1;
		}
		else
		{
			return null;
		}
		
	}
	public List<Encounter> getAllEncounter()
	{
		EncounterdaoImp daoImp =new  EncounterdaoImp();
		List<Encounter> list=daoImp.getAllEncounter();
		
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