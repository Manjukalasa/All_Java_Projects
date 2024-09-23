package com.hospital_app.dao;

import java.util.List;
import com.hospital_app.dto.Medorder;

public interface Medorderdao
{
	public Medorder saveMedorder(int eid,Medorder medorder);
	public Medorder getMedorderId(int mid);
	public boolean  deleteMedorderId(int mid);
	public Medorder updateMedorderId(int mid,Medorder medorder);
	public List<Medorder> getAllMedorder();
	public List<Medorder> getMedorderByDoctorname(String name);	
	public List<Medorder> getMedorderBydate(String date);
}
