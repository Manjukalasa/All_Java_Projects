package com.hospital_app.service;

import java.util.List;

import com.hospital_app.dao.imp.MedorderdaoImp;
import com.hospital_app.dto.Medorder;

public class MedorderService 
{
	public void saveMedorder(int eid, Medorder medorder)
	{
        MedorderdaoImp daoImp =new MedorderdaoImp();
		Medorder medorder1 = daoImp.saveMedorder(eid, medorder);
		if(medorder1!=null)
		{
			System.out.println("Data Saved");
		}
		else
		{
			System.out.println("Unfortunately Data Not Saved");
		}
		
	}
	public  Medorder getMedorderbyId(int mid)
	{
		MedorderdaoImp daoImp =new MedorderdaoImp();
		Medorder medorder1 = daoImp.getMedorderId(mid);
		if(medorder1!=null)
		{
			return medorder1;
		}
		else
		{
			return null;
		}
	}
	public void deleteMedorderbyId(int mid)
	{
		MedorderdaoImp daoImp =new MedorderdaoImp();
		boolean flag = daoImp.deleteMedorderId(mid);
		if(flag)
		{
			System.out.println("data deleted");
		}
		else
		{
			System.out.println("data not found");
		}
	}
	public Medorder updateMedorderbyid(int mid, Medorder medorder)
	{
		MedorderdaoImp daoImp =new MedorderdaoImp();
		Medorder medorder1 = daoImp.updateMedorderId(mid, medorder);
		if(medorder1!=null)
		{
			return medorder1;
		}
		else
		{
			return null;
		}
		
	}
	public List<Medorder> getAllMedorder()
	{
		MedorderdaoImp daoImp =new  MedorderdaoImp();
		List<Medorder> list=daoImp.getAllMedorder();		
			if(list!=null)
			{
			
			return list;
		}
		else
		{
			return null;
		}
	}
	public List<Medorder> getmedorderbyDocotorName(String name)
	{
		MedorderdaoImp daoImp =new  MedorderdaoImp();
		List<Medorder> list=daoImp.getMedorderByDoctorname(name);
		
			if(list!=null)
			{
			
			return list;
		}
		else
		{
			return null;
		}
	}
	public List<Medorder> getmedorderbyDate(String Date)
	{
		MedorderdaoImp daoImp =new  MedorderdaoImp();
		List<Medorder> list=daoImp.getMedorderBydate(Date);
		
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