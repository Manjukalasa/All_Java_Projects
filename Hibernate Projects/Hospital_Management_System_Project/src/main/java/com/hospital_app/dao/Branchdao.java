package com.hospital_app.dao;

import java.util.List;
import com.hospital_app.dto.Branch;

public interface Branchdao
{
	public Branch saveBranch(int hid,Branch branch);
	public Branch getBranchId(int bid);
	public boolean  deleteBranchId(int bid);
	public Branch updateBranchId(int bid,Branch branch);
	public List<Branch> getAllBranch();
}