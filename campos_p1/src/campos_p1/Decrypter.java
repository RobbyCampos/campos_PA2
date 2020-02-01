package campos_p1;

import java.util.Scanner;

public class Decrypter {

	public static void Decrypt(String preDecrypt) {
		
		Scanner in = new Scanner(System.in);
	
		int postDecrypt = 0;
		int holder;
		int holder2;
		
		// Convert encrypted 4 digit number into array
		int[] decryptArray = new int[preDecrypt.length()]; 
		
		for(int i=0; i<preDecrypt.length(); i++){
		    decryptArray[i] = Character.getNumericValue(preDecrypt.charAt(i));
		}
		
		// Swap second digit with fourth
		holder = decryptArray[1];
		holder2 = decryptArray[3];
		decryptArray[1] = holder2;
		decryptArray[3] = holder;
		
		// Swap first digit with third
		holder = decryptArray[0];
		holder2 = decryptArray[2];
		decryptArray[0] = holder2;
		decryptArray[2] = holder;
		
		// take each digit if digit >= 3, add 10 THEN subtract seven
		// if digit is 0,1, or 2, just add seven
		for(int i = 0; i <= 3; i++)
		{
			if(decryptArray[i] >= 7 && decryptArray[i] <= 9) 
				{
				decryptArray[i] -= 7;
				}
			else if (decryptArray[i] > 0 && decryptArray[i] <= 6)
			{
				decryptArray[i] += 10;
				decryptArray[i] -= 7;
			}
			else if (decryptArray[i] == 0)
			{
				decryptArray[i] += 3;
			}
		}
		
		//covert new array into int
		for(int i = 0; i < decryptArray.length; i++)
		{
		    postDecrypt = postDecrypt*10+decryptArray[i];
		}
		
		//display decrypted int to user
		System.out.println("Your encrypted 4 digit number is: " + postDecrypt);

	}

}
