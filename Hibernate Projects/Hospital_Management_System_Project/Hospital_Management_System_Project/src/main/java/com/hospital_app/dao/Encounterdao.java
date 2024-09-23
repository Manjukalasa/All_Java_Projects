package com.hospital_app.dao;
import java.util.List;

import com.hospital_app.dto.Encounter;

public interface Encounterdao
{
	public Encounter saveEncounter(int bid,Encounter encounter);
	 public Encounter getEncounterId(int eid);
	 public boolean  deleteEncounterId(int eid);
	 public Encounter updateEncounterId(int eid,Encounter encounter);
	 public List<Encounter> getAllEncounter();

}
