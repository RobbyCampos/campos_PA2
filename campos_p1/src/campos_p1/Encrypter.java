package campos_p1;

import java.util.Scanner;

public class Encrypter {

	public static void Encrypt(String preEncrypt) {
		
		Scanner in = new Scanner(System.in);
		
		int postEncrypt = 0;
		int holder;
		int holder2;
		
		//convert 4 digit number into array
		int[] encryptArray = new int[preEncrypt.length()]; 
		
		for(int i=0; i<preEncrypt.length(); i++){
		    encryptArray[i] = Character.getNumericValue(preEncrypt.charAt(i));
		}
		

		//Replace each digit with the result of adding 7 & the remainder after dividing by 10
		for(int i = 0; i <= 3; i++)
		{
			encryptArray[i] += 7;
			encryptArray[i] %= 10;
		}
		
		//swap first digit with third
		holder = encryptArray[0];
		holder2 = encryptArray[2];
		encryptArray[0] = holder2;
		encryptArray[2] = holder;
		
		//swap second digit with fourth
		holder = encryptArray[1];
		holder2 = encryptArray[3];
		encryptArray[1] = holder2;
		encryptArray[3] = holder;
		
		//convert array to int
		for(int i = 0; i < encryptArray.length; i++)
		{
		    postEncrypt = postEncrypt*10+encryptArray[i];
		}
		
		//print encrypted integer accounting for any zeros.
		if(encryptArray[0] == 0 && encryptArray[1] != 0)
		{
		System.out.println("Your encrypted 4 digit number is: " + "0" + postEncrypt); //starting with a 0 and third integer as a zero still an issue
		}
		
		else if(encryptArray[0] == 0 && encryptArray[1] == 0 && encryptArray[2] != 0)
		{
		System.out.println("Your encrypted 4 digit number is: " + "0" + "0" +postEncrypt); //starting with a 0 and third integer as a zero still an issue
		}
		
		else if(encryptArray[0] == 0 && encryptArray[1] == 0 && encryptArray[2] == 0 && encryptArray[3] != 0)
		{
		System.out.println("Your encrypted 4 digit number is: " + "0" + "0" + "0" + postEncrypt); //starting with a 0 and third integer as a zero still an issue
		}
		
		else if(encryptArray[0] == 0 && encryptArray[1] == 0 && encryptArray[2] == 0 && encryptArray[3] == 0)
		{
		System.out.println("Your encrypted 4 digit number is: " + "0" + "0" + "0" + "0"); //starting with a 0 and third integer as a zero still an issue
		}
		
		else if(encryptArray[0] != 0)
		{
			System.out.println("Your encrypted 4 digit number is: " + postEncrypt);
		}
		
	}

}
