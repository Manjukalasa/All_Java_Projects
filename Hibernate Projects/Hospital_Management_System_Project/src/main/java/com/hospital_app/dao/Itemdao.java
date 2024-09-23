package com.hospital_app.dao;

import java.util.List;
import com.hospital_app.dto.Items;
public interface Itemdao 
{
	public Items saveItem(int mid,Items item);
	public Items getItemsId(int iid);
	 public boolean  deleteItemsId(int iid);
	 public Items updateItemsId(int iid,Items items);
	 public List<Items> getAllItems();
}