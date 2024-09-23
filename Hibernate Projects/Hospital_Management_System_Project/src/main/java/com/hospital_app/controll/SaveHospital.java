package com.hospital_app.controll;

import com.hospital_app.dto.Hospital;
import com.hospital_app.service.HospitalService;

public class SaveHospital
{
	public static void main(String[] args) {
		Hospital hospital=new Hospital();
		hospital.setName("manju");
		hospital.setWebsite("www.manju.com");
		
		HospitalService service=new HospitalService();
		service.saveHospital(hospital);
		
		Hospital hospital1=new Hospital();
		hospital1.setName("mk");
		hospital1.setWebsite("www.mk.com");
		
		HospitalService service1=new HospitalService();
		service1.saveHospital(hospital1);
		
		Hospital hospital2=new Hospital();
		hospital2.setName("mbk");
		hospital2.setWebsite("www.mbk.com");
		
		HospitalService service2=new HospitalService();
		service2.saveHospital(hospital2);
		
		
	}

}