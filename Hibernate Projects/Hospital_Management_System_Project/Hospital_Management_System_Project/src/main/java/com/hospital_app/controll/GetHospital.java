package com.hospital_app.controll;

import com.hospital_app.dto.Hospital;
import com.hospital_app.service.HospitalService;

public class GetHospital
{
public static void main(String[] args) {
	HospitalService service=new HospitalService();
	Hospital hospital=service.getHospitalById(4);
	System.out.println(hospital.getHid());
	System.out.println(hospital.getName());
	System.out.println(hospital.getWebsite());
}
}
