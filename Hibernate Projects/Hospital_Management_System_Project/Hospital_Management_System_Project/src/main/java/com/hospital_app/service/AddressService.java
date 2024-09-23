package com.hospital_app.service;

import java.util.List;

import com.hospital_app.dao.imp.AddressdaoImp;
import com.hospital_app.dto.Address;

public class AddressService 
{
	public void saveAddress(int bid, Address address)
	{
		AddressdaoImp daoImp =new  AddressdaoImp();
		Address address1 = daoImp.saveAddress(bid, address);
		if(address1!=null)
		{
			System.out.println("Address Saved");
		}
		else
		{
			System.out.println("Unfortunately Data Not Saved");
		}
	}
	
	public  Address getAddressbyId(int aid)
	{
		AddressdaoImp daoImp =new  AddressdaoImp();
		Address address1 = daoImp.getAddressId(aid);
		if(address1!=null)
		{
			return address1;
		}
		else
		{
			return null;
		}
	}
	public void deleteAddressbyId(int aid)
	{
		AddressdaoImp daoImp =new  AddressdaoImp();
		boolean flag = daoImp.deleteAddressId(aid);
		if(flag)
		{
			System.out.println("data deleted");
		}
		else
		{
			System.out.println("data not found");
		}
	}
	
	public Address updateAddressbyid(int aid, Address address)
	{
		AddressdaoImp daoImp =new  AddressdaoImp();
		Address address1= daoImp.updateEncounterId(aid, address);
		if(address1!=null)
		{
			return address1;
		}
		else
		{
			return null;
		}
		
	}
	public List<Address> getAllAddress()
	{
		AddressdaoImp daoImp =new  AddressdaoImp();
		List<Address> list=daoImp.getAllAddress();
		
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