package NewPetDemo;
import java.util.Scanner;

public class NewPetDemo	{
	    public static void main(String[] args) {
		        NewPet yourPet = new NewPet();
		        System.out.println("My records on your pet are inaccurate.");
		        System.out.println("Here is what they currently say:");
		        yourPet.writeOutput();
				
		        Scanner keyboard = new Scanner(System.in);

		        System.out.println("Please enter the correct pet name:");
		        String correctName = keyboard.nextLine();
				yourPet.setName(correctName);
				
		        System.out.println("Please enter the correct pet age:");
		        int correctAge = keyboard.nextInt();
				yourPet.setAge(correctAge);
		
		        System.out.println("Please enter the correct pet weight:");
		        double correctWeight = keyboard.nextDouble();
				yourPet.setWeight(correctWeight);
				
		        System.out.println("Please enter the correct color of your pet:");
		        String correctColor = keyboard.nextLine();
		        correctColor = keyboard.nextLine();
				yourPet.setColor(correctColor);
				
		        System.out.println("Please enter the correct amount of legs of your pet:");
		        int correctLegs = keyboard.nextInt();
				yourPet.setLegs(correctLegs);
				
		        System.out.println("My updated records now say:");
		        yourPet.writeOutput();
		        keyboard.close();
	    	}
	}
