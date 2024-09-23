package com;

import java.util.Scanner;

public class Solution 
{
	public static void main(String[] args)
	{
		System.out.println("Welcome To MBK Departmental Strore");
		System.out.println("======================================================");
		Scanner sc=new Scanner(System.in);
		DepartmentalStrore store=new DepartmentalStroreIml(); // upcating to achieve Abstrsction
		
		store.addProduct();
		int choice=1;
		while(choice==1)
		{
		store.displayProduct();
		store.buyProduct();
		System.out.println("*******************************************************");
		System.out.println("Press 1 to continue or any other number to check Out");
		choice=sc.nextInt();
		}
		store.checkout();  // check out only once
	}
}
