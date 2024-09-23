package com.hospital_app.service;
import com.hospital_app.dao.imp.HospitaldaoImp;
import com.hospital_app.dto.Hospital;

public class HospitalService 
{
	public void saveHospital(Hospital hospital)
	{
		HospitaldaoImp daoImp=new HospitaldaoImp();
		Hospital hospital1=daoImp.saveHospital(hospital);
		if(hospital1!=null)
		{
			System.out.println("Data Saved");
		}
		else
		{
			System.out.println("Unfartunatly Data Not saved");
		}
	}

	public Hospital getHospitalById(int hid)
	{
		HospitaldaoImp daoImp=new HospitaldaoImp();
		Hospital hospital1=daoImp.getHospitalId(hid);
		if(hospital1!=null)
		{
			return hospital1;
		}
		else
		{
			return null;
		}
	}

	public void deleteHospitalById(int hid)
	{
		HospitaldaoImp daoImp=new HospitaldaoImp();
		boolean flag=daoImp.deleteHospitalId(hid);
		if(flag)
		{
			System.out.println("Data Deleted");
		}
		else
		{
			System.out.println("Data Not found");
		}
	}
	
	public Hospital updateHospitalById(int hid,Hospital hospital)
	{
		HospitaldaoImp daoImp=new HospitaldaoImp();
		Hospital hospital1=daoImp.updateHospitalId(hid, hospital);
		if(hospital1!=null)
		{
			return hospital1;
		}
		else
		{
			return null;
		}
	}

}
