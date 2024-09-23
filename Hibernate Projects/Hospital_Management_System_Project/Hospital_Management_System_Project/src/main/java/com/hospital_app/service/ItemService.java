package com.hospital_app.service;

import java.util.List;

import com.hospital_app.dao.imp.ItemdaoImp;
import com.hospital_app.dto.Items;

public class ItemService
{
	public void saveItem(int mid, Items item) 
	{
		ItemdaoImp daoImp =new ItemdaoImp();
		Items item1 = daoImp.saveItem(mid, item);
		if(item1!=null)
		{
			System.out.println("Data Saved");
		}
		else
		{
			System.out.println("Unfortunately Data Not Saved");
		}
		
	}
	public  Items getItembyId(int iid)
	{
		ItemdaoImp daoImp =new ItemdaoImp();
		Items item1 = daoImp.getItemsId(iid);
		if(item1!=null)
		{
			return item1;
		}
		else
		{
			return null;
		}
	}
	public void deleteItembyId(int iid)
	{
		ItemdaoImp daoImp =new ItemdaoImp();
		boolean flag = daoImp.deleteItemsId(iid);
		if(flag)
		{
			System.out.println("data deleted");
		}
		else
		{
			System.out.println("data not found");
		}
	}
	public Items updateItembyid(int iid, Items item)
	{
		ItemdaoImp daoImp =new ItemdaoImp();
		Items item1 = daoImp.updateItemsId(iid, item);
		if(item1!=null)
		{
			return item1;
		}
		else
		{
			return null;
		}
		
	}
	public List<Items> getAllItem()
	{
		ItemdaoImp daoImp =new  ItemdaoImp();
		List<Items> list=daoImp.getAllItems();
		
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
