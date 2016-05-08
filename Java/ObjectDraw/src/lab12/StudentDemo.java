package lab12;

import java.io.*;
import java.util.Scanner; 
class StudentDemo
{
	public static void main ( String [ ] args) throws IOException
	{
		Scanner keyboard = new Scanner (System.in); 
		String name;
		StudentClass PaceStudent = new StudentClass ();
		System.out.println( "What is your name ");
		name = keyboard.nextLine ();
		PaceStudent.setName ( name);
		PaceStudent.writeOutput();
		//PaceStudent.setAcademicAdvisor("Tricia");
	}
}
