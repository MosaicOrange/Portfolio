package Project06;
import java.io.*;
import java.util.Scanner;

public class Demo {
	public static void main ( String [] args)throws IOException {
		Scanner keyboard = new Scanner (System.in);
		String name = null, answer = null, response = null, redo, input, reference = "M", moreFunctions;
		boolean error = true, redoError, mistake = true, massiveLoop = true, conditionalBoolean;

		LinkedListClass drTaosList = new LinkedListClass ();
		LinkedListClass drCourtneysList = new LinkedListClass ();

		BufferedReader list = new BufferedReader ( new FileReader("StudentNames.txt") );
		String numString = list.readLine ();
		int numberOfStudents = Integer.parseInt (numString );
		for ( int i = 1; i <= numberOfStudents; i ++ ) {
			String insertingName = list.readLine ();
			if(insertingName.compareTo(reference) < 0) {
				drTaosList.addStudent( insertingName );
				System.out.println("inserting name " + insertingName + " into Dr. Tao's List");
			} else if(insertingName.compareTo(reference) > 0) {
				drCourtneysList.addStudent( insertingName );
				System.out.println("inserting name " + insertingName + " into Dr. Courtney's List");
			} else {}
		}
		System.out.println();

		do {
			do {
				System.out.print("Would you like to enter \"[A]ADD\" a name to the list, \"[P]PRINT\" the list of a specific Professor, \"[D]DELETE\" a name from a list, or \"[S]SEARCH\" for name to verify a student is a CS Major?");
				answer = keyboard.nextLine();
				answer = answer.toLowerCase();
				if ( answer.equals("p") || answer.equals("print") ) {
					do {
						System.out.print("\nDo you want to print Dr. [T]Tao's List or Dr. [C]Courtney's List?");
						input = keyboard.nextLine();
						response = input.toLowerCase();
						if ( response.equals("t") || response.equals("tao") ) {
							System.out.print("Dr. Tao's List:");
							drTaosList.printList ();
							mistake = false;
						} else if ( response.equals("c") || response.equals("courtney") ) {
							drCourtneysList.printList ();
							mistake = false;
						} else {
							System.out.print("\nYou have provided unacceptable input. Acceptable answers are " + "[T], [TAO], [C], and [COURTNEY]. The answer is not case senstivite.\n\n\tPlease Try Again.");
						}
					} while ( mistake ) ;
					error = false;
				} else if (answer.equals("a") || answer.equals("add") || answer.equals("s") || answer.equals("search") || answer.equals("d") || answer.equals("delete") ) {
					System.out.print("\nPlease provide the name of the Student.");
					name = keyboard.nextLine();
					if ( answer.equals("s") || answer.equals("search") ) {
						if(name.compareTo(reference) < 0) {
							drTaosList.searchStudent(name);
							System.out.print(" on Dr. Tao's List.");
						} else if(name.compareTo(reference) > 0) {
							drCourtneysList.searchStudent(name);
							System.out.print(" on Dr. Courtney's List.");
						} else { System.out.println("This Should Never Be Reached!"); }
						error = false;
					} else if ( answer.equals("d") || answer.equals("delete") ) {
						if(name.compareTo(reference) < 0) {
							drTaosList.deleteStudent(name);
							System.out.print(name + " has been removed from Dr. Tao's List");
						} else if(name.compareTo(reference) > 0) {
							drCourtneysList.deleteStudent(name);
							System.out.print(name + " has been removed from Dr. Courtney's List");
						} else { System.out.println("This Should Never Be Reached!"); }
						error = false;
					} else if ( answer.equals("a") || answer.equals("add") ) {
						if(name.compareTo(reference) < 0) {
							drTaosList.addStudent(name);
							System.out.print(name + " has been added to Dr. Tao's List");
						} else if(name.compareTo(reference) > 0) {
							drCourtneysList.addStudent(name);
							System.out.print(name + " has been added to Dr. Courtney's List");
						} else { System.out.println("This Should Never Be Reached!"); }
						error = false;
					}
				} else {
					redoError = true;
					System.out.print("\n" + answer + " is unacceptable input. Acceptable answers are " + "[D], [DELETE], [P], [PRINT], [S], [SEARCH], [A], and [ADD]. The answer is not case " + "senstivite.\n\n\tWould you like to try again? [Y] or [N]:");
					while ( redoError ) {
						redo = keyboard.nextLine();
						redo = redo.toLowerCase();
						if ( redo.equals("y") || redo.equals("yes") ) {
							System.out.print("\n");
							redoError = false;
						} else if ( redo.equals("n") || redo.equals("no") ) {
							System.out.print("You have chosen not to proceed, goodbye!");
							System.exit(0);
						} else {
							System.out.print("\nInvalid Input, Please Try Again.");
						}
					}
				}
			} while ( error ) ;
			
			conditionalBoolean = true;
			System.out.print("\n\n\tWould you like to perform more functions? [Y] or [N]:");
			while ( conditionalBoolean ) {
				moreFunctions = keyboard.nextLine();
				moreFunctions = moreFunctions.toLowerCase();
				if ( moreFunctions.equals("y") || moreFunctions.equals("yes") ) {
					System.out.print("\n");
					conditionalBoolean = false;
				} else if ( moreFunctions.equals("n") || moreFunctions.equals("no") ) {
					System.out.print("\nYou have chosen not to proceed, goodbye!");
					System.exit(0);
				} else {
					System.out.print("\nInvalid Input, Please Try Again.");
				}
			}
		} while (massiveLoop);
	}
}