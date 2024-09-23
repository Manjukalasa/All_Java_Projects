package com;

import java.util.*;

public class DepartmentalStroreIml implements DepartmentalStrore
{

	// key->Product Id->Integer   & Value ->Product Instance ->Product
	Map<Integer,Product> db=new LinkedHashMap<Integer,Product>();
	Scanner sc=new Scanner(System.in);
	int totalBill=0;               // member Variable (comman for all)
	@Override
	public void addProduct()
	{
		db.put(1, new Product("chocolates",10,5));
		db.put(2, new Product("Biscuits",20,10));
		db.put(3, new Product("IceCream",30,20));
	}
	@Override
	public void displayProduct()
	{
		Set<Integer> keys=db.keySet();// 1 2 3--->convertin Map into Set
		for(int key : keys)
		{
			Product p=db.get(key);
			System.out.println("Enter "+key+" to Order "+p.getName());
			System.out.println("Availabe Quantity "+p.getQuantity());
			System.out.println("One Quantity Cost:Rs."+p.getCost());
			System.out.println("---------------------------------------");

		}
	}
	@Override
	public void buyProduct()
	{
		System.out.println("Enter choice:");  // choice->key
		int choice=sc.nextInt();    // 1,2,3
		//get() return null, when the kry(choice) is not present
		Product p=db.get(choice);//getting the product based on choice

		if(p!=null)
		{
			System.out.println("Buying "+p.getName());
			System.out.println("Enter the Quantity:");
			int quantity=sc.nextInt();

			if(quantity<= p.getQuantity())
			{
				//Calculating the current Product cost
				int productcost = quantity*p.getCost();
              
				//Adding the current product cost to totao bill
				totalBill=totalBill+productcost; // totalBill+=productcost;
				
				//Updating the new Quantity
				p.setQuantity(p.getQuantity()- quantity);
				
				System.out.println("Ordered "+quantity+" "+p.getName());
				System.out.println("Current Product cast is Rs."+productcost);
				System.out.println("Totao Bill as of now: Rs."+totalBill);
			}
			else
			{
				try
				{
					String message="Invalid Quantity "+p.getName()+" Not Available ,Avalable Quantit's are "+p.getQuantity();
					throw new InvalidQuantityException(message);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}	
			}
		}
		else
		{
			try
			{
				String message="Invalid choice, Kindly Enter Valid Choice";
				throw new InvalidChoiceException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void checkout()
	{
		System.out.println("\n\n\n\n\n\n-----------------------------------------------------");
		System.out.println("               MK Departmental Store                 ");
		System.out.println("-----------------------------------------------------\n");
		System.out.println("Total Bill is :Rs."+totalBill);
		System.out.println("Thank you for Shopping...!");
		System.out.println("-----------------------------------------------------");

	}
}
