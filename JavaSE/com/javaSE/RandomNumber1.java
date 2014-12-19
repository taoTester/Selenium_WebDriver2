package com.javaSE;

import java.util.Random;





public class RandomNumber1 {
	
	int double1;
	



	
	public int getNumber(){
		
		return double1=(int) (Math.random()*1000);
		

	}
	
	public static void main(String[] args) {
		
		RandomNumber1 r =new RandomNumber1();
		r.getNumber();
		Random random = new Random(10);
		int c = random.nextInt(10);
		switch (c) {
		case 1:System.out.println("1");
			
			break;

		case 2:System.out.println("1");
		
		break;
		default:System.out.println("2");
			break;
		}
		
	}

}
