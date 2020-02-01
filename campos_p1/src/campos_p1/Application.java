package campos_p1;

import java.util.Scanner;

public class Application {

	
	public static void main(String[] args) {
		//declaration
		Scanner in = new Scanner(System.in);
		
		String preEncrypt;
		String preDecrypt;
		int userChoice;
		
		//Engage and direct the user
		System.out.println("\nHello! Welcome to the Encrypt/Decrypt program.");
		
		//Loop to allow continued trials
		while(true)
		{
			System.out.println("\n1. Encrypt a 4 digit integer");
			System.out.println("2. Decrypt a 4 digit integer");
			System.out.println("3. Exit Program.");
			System.out.print("\nPlease enter your selection: ");
			userChoice = in.nextInt();
			
			if(userChoice == 1) //Reference Encrypter class
			{
				System.out.print("\nPlease enter 4 digit number to ENCRYPT: ");
				preEncrypt = in.next();
				
				Encrypter.Encrypt(preEncrypt);
				continue;
			}
			
			else if(userChoice == 2)//Reference Decrypter class
			{
				System.out.print("\nPlease enter 4 digit number to DECRYPT: ");
				preDecrypt = in.next();
				
				Decrypter.Decrypt(preDecrypt);
				continue;
			}
			
			else if(userChoice == 3)//Exit program
			{
				break;
			}
		}
		
		System.out.print("\nHave a good day! ");
		
	}

}
