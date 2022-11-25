package com.examples;
import java.util.Scanner;

public class Problem2 {
	static double discountedAmount;
	static double discount;
	
	static void billdiscount(double billAmount) {
	if(billAmount < 1000)
		discount=0;
	else if(billAmount == 1000)
		discount = 0.02* billAmount; 
	else if(billAmount > 1000 && billAmount <= 5000)
		discount=0.05*billAmount;
	else if(billAmount > 5000 && billAmount <= 10000)
		discount=0.1*billAmount;
	else if(billAmount > 10000 )
		discount=0.2*billAmount;
	
	discountedAmount=billAmount-discount;
	
	System.out.println("Actual Bill Amt:"+billAmount+ '\n'+"Discount Offered:" +discount +'\n'+ "Discounted Amt:"+discountedAmount );
		
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter bill Amount: ");
		double billAmount=0;
		try {
		 billAmount=sc.nextDouble();
		}catch(Exception e) {
			System.out.println("Invalid Input");
		}
		billdiscount(billAmount);
		sc.close();
		
		
	}
}
