package com.hospital_app.controll;

import com.hospital_app.service.HospitalService;

public class DeleteHospital 
{
	public static void main(String[] args) 
	{
		
		HospitalService service=new HospitalService();
		service.deleteHospitalById(7);
	}
}
