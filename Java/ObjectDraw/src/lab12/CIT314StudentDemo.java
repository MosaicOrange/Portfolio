package lab12;

import java.io.*;
import java.util.Scanner; 
class CIT314StudentDemo
{
	public static void main ( String [ ] args) throws IOException
		{
			Scanner keyboard = new Scanner (System.in); 
			String name, major, advisor, grade;
			int hours;
			CIT314StudentClass PaceStudent = new CIT314StudentClass ();
			System.out.println( "What is your name ");
			name = keyboard.nextLine ();
			PaceStudent.setName ( name);
			System.out.println ( "What is your major in the school of CSIS?");
			major = keyboard.nextLine();
			PaceStudent.setMajor ( major);
			System.out.println ( "Who is your faculty advisor?");
			advisor = keyboard.nextLine();
			PaceStudent.setAcademicAdvisor ( advisor);
			System.out.println ( "How many hours are you planning to study?");
			hours = Integer.parseInt(keyboard.nextLine());
			PaceStudent.setHours (hours);
			System.out.println ( "What grade do you expect to receive?");
			grade = keyboard.nextLine();
			PaceStudent.setGrade (grade);
			PaceStudent.writeOutput();
		}
}