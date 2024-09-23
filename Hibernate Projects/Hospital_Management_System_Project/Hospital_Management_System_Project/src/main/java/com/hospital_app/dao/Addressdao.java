package com.hospital_app.dao;

import java.util.List;

import com.hospital_app.dto.Address;

public interface Addressdao 
{
	public Address saveAddress(int bid,Address address);
	public Address getAddressId(int aid);
	public boolean  deleteAddressId(int aid);
	public Address updateEncounterId(int hid,Address address);
	public List<Address> getAllAddress();
}
