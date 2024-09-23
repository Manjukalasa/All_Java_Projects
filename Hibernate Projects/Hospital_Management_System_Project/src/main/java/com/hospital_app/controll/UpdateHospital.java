package com.hospital_app.controll;

import com.hospital_app.dto.Hospital;
import com.hospital_app.service.HospitalService;

public class UpdateHospital 
{
public static void main(String[] args)
{
	
	Hospital hospital=new Hospital();
	hospital.setName("manjukk");
	hospital.setWebsite("www.manjukk.com");
	
	HospitalService service=new HospitalService();
	service.updateHospitalById(4, hospital);
}
}
