package com.hospital_app.service;

import java.util.List;

import com.hospital_app.dao.imp.BranchdaoImp;
import com.hospital_app.dto.Branch;

public class BranchService 
{
	public void saveBranch(Branch branch,int hid)
	{
		BranchdaoImp branchdaoImp=new BranchdaoImp();
		Branch branch1=branchdaoImp.saveBranch(hid, branch);
		if(branch1!=null)
		{
			System.out.println("Branch Saved");
		}
		else
		{
			System.out.println("Unfartunatly Branch Not saved");
		}
	}

	public Branch getBranchById(int bid)
	{
		BranchdaoImp daoImp=new BranchdaoImp();
		Branch branch1=daoImp.getBranchId(bid);
		if(branch1!=null)
		{
			return branch1;
		}
		else
		{
			return null;
		}
	}
	
	public void deleteBranchById(int bid)
	{
		BranchdaoImp daoImp=new BranchdaoImp();
		boolean flag=daoImp.deleteBranchId(bid);
		if(flag)
		{
			System.out.println("Branch Deleted");
		}
		else
		{
			System.out.println("Branch Not found");
		}
	}
	
	public Branch updateBranchById(int bid,Branch branch)
	{
		BranchdaoImp daoImp=new BranchdaoImp();
		Branch branch1=daoImp.updateBranchId(bid, branch);
		if(branch1!=null)
		{
			return branch1;
		}
		else
		{
			return null;
		}
	}
	
	public List<Branch> getAllBranchById(int bid)
	{
		BranchdaoImp daoImp=new BranchdaoImp();
		List<Branch> branch1=daoImp.getAllBranch();
		if(branch1!=null)
		{
			return branch1;
		}
		else
		{
			return null;
		}
	}
}
