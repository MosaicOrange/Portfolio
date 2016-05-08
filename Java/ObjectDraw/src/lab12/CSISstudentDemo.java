package lab12;

import java.io.*;
import java.util.Scanner; 
class CSISstudentDemo
{
	public static void main ( String [ ] args) throws IOException
	{
		Scanner keyboard = new Scanner (System.in); 
		String name, major, advisor;
		CSISstudentClass PaceStudent = new CSISstudentClass ();
		System.out.println( "What is your name ");
		name = keyboard.nextLine ();
		PaceStudent.setName ( name);
		System.out.println ( "What is your major in the school of CSIS?");
		major = keyboard.nextLine();
		PaceStudent.setMajor ( major);
		System.out.println ( "Who is your faculty advisor?");
		advisor = keyboard.nextLine();
		PaceStudent.setAcademicAdvisor ( advisor);
		PaceStudent.writeOutput();
	}
}