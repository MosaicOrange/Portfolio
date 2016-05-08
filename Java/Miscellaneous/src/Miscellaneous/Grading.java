package Miscellaneous;
import java.util.Scanner;

public class Grading
	{
		public static void main(String[] args)
			{
				int score;
				String grade;
				System.out.println("Enter your score: ");
				Scanner keyboard = new Scanner(System.in);
				score = keyboard.nextInt();
				if (score >= 97) {
						grade = "A+";
					} else if (score >= 93) {
						grade = "A";						
					} else if (score >= 90) {
						grade = "A-";
					} else if (score >= 87) {
						grade = "B+";
					} else if (score >= 83) {
						grade = "B";						
					} else if (score >= 80) {
						grade = "B-";
					} else if (score >= 77) {
						grade = "C+";
					} else if (score >= 73) {
						grade = "C";						
					} else if (score >= 70) {
						grade = "C-";
					} else if (score >= 67) {
						grade = "D+";
					} else if (score >= 63) {
						grade = "D";						
					} else if (score >= 60) {
						grade = "D-";
					} else {
						grade = "F";
						System.out.println("You got an \"" + grade + "\". You should start considering a new career choice.");
						System.out.println("Program Out!");
						System.exit(0);
					}
				
				System.out.println("Score = " + score);
				if (score == 100) {
					System.out.println("You got an \"" + grade + "\". Great Job, keep up the good work.");
				} else {
					System.out.println("You got an \"" + grade + "\". Keep trying, the purpose of perfection is to keep striving to reach it.");
				}
				keyboard.close();
			}
	}