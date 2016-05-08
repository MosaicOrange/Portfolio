package Miscellaneous;

import java.util.Arrays;
// Import this to be able to use arrays

import java.util.Scanner;
// Import this to be able to use Scanner to take in keyboard input

public class MidtermNotes
	{ // START OF CLASS

		public static void main(String[] args) // should be self explanatory
			{ // START OF MAIN
				Scanner userInput = new Scanner(System.in);
					// you pull Scanner from the imported library and use it to be able to task
					// an object, in this case the variable "userInput" to pull in input

				boolean error = true;
					// boolean is a primitive data type, it's either "0" or "1", "yes" or "no", "true" or "false"
					// this boolean was created in order to maintain the infinite loop cycle of my "do-while" statement
					// I'm setting it up ~AND~ initializing it to be "true"

				boolean redoEr = true;
					// This boolean was created in order to maintain the infinite loop cycle of my "while" statement
					// I'm setting it up ~AND~ initializing it to be "true"

				String answer, redo;
					// string is a non-primitive Data-Type, it can store whatever input you want, however all
					// this versatility comes at a cost, ie you can't perform math functions on a string.
					// I set these Strings outside the loop in order to be able to use them outside of the loops.
					// setting them is defining them, initializing them means you have assigned them a value.

// Beginning of checking input block
				do
					// this "do-while" statement checks for correct user input.
					// I picked a "Do-While" statement because they happen at least
					// once even if the condition is already false when it starts.
					// that is important because I need this to happen at least once.
					// It is infinite until proper input is entered.
					{ // START OF DO-WHILE STATEMENT
					// I recommend doing every section of any statement in brackets that
					// way you know where the code actually belongs too
						System.out.print("Would you like to enter in \"Doubles\" or \"Longs\" for the calculations?");
					// this prints out information to the console, certain things can't be printed normally, like 
					// quotations or parenthesis, so you put a "\" in front of those items.
					// \n pushes everything to the next line and \t is like tab in word
					// "println" behaves exactly like a "print" except it adds an "\n" at the end (new line)
						answer = userInput.nextLine();
					// this takes in user input and assigns it to "answer" which was set up outside the loop
					// notice the "(variable).nextLine", it's important, you could also use "(variable).next"
					// for other data types you'd use "(variable).next(type of data)"
						answer = answer.toLowerCase();
					// this converts everything in answer into lower case, it makes it easier to do comparisons
						if ( answer.equals("l") || answer.equals("long") || answer.equals("lng") )
					// this is a nested "If-Else If-Else" statement because it's inside the "Do-While" statement
					// the "||" means "or", (variable name).equals checks to make sure something is exactly equal to
					// whatever is inside the parenthesis, this is case sensitive and why I lower-cased everything before.
					// using "==" doesn't work exactly as intended with strings so I've been told, and it just seems easier
					// this way. This statement first checks for any one of these 3 things to be true. 
							{ // START OF IF PART OF 1ST IF-ELSEIF-ELSE STATEMENT
								answer = "long";
					// this sets the "answer" to "long" which is something I use later on
								error = false;
					// this will break the cycle of the "Do-While" statement
							} // END OF ELSE PART OF 1ST IF-ELSEIF-ELSE STATEMENT
						else if ( answer.equals("d") || answer.equals("double") || answer.equals("dbl") )
					// if nothing is true in the previous section then this is checked next.
							{ // START OF ELSEIF PART OF 1ST IF-ELSEIF-ELSE STATEMENT
								answer = "double";
					// this sets the "answer" to "double" which is something I use later on
								error = false;
					// this will break the cycle of the "Do-While" statement
							} // END OF ELSEIF PART OF 1ST IF-ELSEIF-ELSE STATEMENT
						else
					// this is last case scenario, if nothing before this was true then this "while" statement happens
							{ // START OF ELSE PART OF 1ST IF-ELSEIF-ELSE STATEMENT
								redoEr = true;
					// this is here in case the user still gets input wrong, so when they come back to this section it'll
					// keep doing the following "while" code
								while ( redoEr )
					// this "While" statement will keep going while whatever in the parenthesis is "true" 
									{ // START OF WHILE STATEMENT
										System.out.print("\nYou have provided unacceptable input. Accepted answers are "
												+ "[L], [LNG],\n[LONG], [D], [DBL], and [DOUBLE]. The answer is not case "
												+ "senstivite.\n\n\tWould you like to try again? [Y] or [N]:");
					// giving the user instructions, the "+" puts stuff together
										redo = userInput.nextLine();
					// assigns the next line of input to "redo", notice "(variable).nextLine"
										redo = redo.toLowerCase();
					// this converts everything in answer into lower case, it makes it easier to do comparisons					
										if ( redo.equals("y") || redo.equals("yes") )
					// if either of the conditions is true then proceed
											{ // START OF IF PART OF 2ND IF-ELSEIF-ELSE STATEMENT
												System.out.print("\n");
					// all this does is insert a line break space
												redoEr = false;
					// this breaks the current "while" statement, but not the "do-while" statement
											} // END OF IF PART OF 2ND IF-ELSEIF-ELSE STATEMENT
										else if ( redo.equals("n") || redo.equals("no") )
					// if either of the conditions is true then proceed,
					// basically a scenario in which the user changes his/her mind about running the program.
											{ // START OF ELSEIF PART OF 2ND IF-ELSEIF-ELSE STATEMENT
												System.exit(0);
					// user have decided to stop running this program, and this
					// piece of code does just that, it terminates the application.
											} // START OF ELSEIF PART OF 2ND IF-ELSEIF-ELSE STATEMENT
										else
					// for users who still can't input data in correctly
											{ // START OF ELSE PART OF 2ND IF-ELSEIF-ELSE STATEMENT
												System.out.print("\n\nPlease Try Again\n");
					// prints out user instructions
												redoEr = true;
					// forces the "while" statement to loop again 
											} // START OF ELSE PART OF 2ND IF-ELSEIF-ELSE STATEMENT
									} // END OF WHILE STATEMENT
							} // END OF ELSE PART OF 1ST IF-ELSEIF-ELSE STATEMENT
					} // END OF DO-WHILE STATEMENT
				while ( error ) ;
					// notice the ";" at the end of the "Do-While" statement, it's necessary, Syntax is as follows:
					// Do { content/code } while (condition);
// End of checking input block

// Beginning of asking for number of variables desired block
				int numVars;
				// "int" is a primitive data type, it has to be a whole number, this integer was created in order
				// This is being used to define the length of my array later on I'm setting it up, but not initializing it
				boolean checking = true;
				// This boolean was created in order to maintain the infinite loop cycle of the following "Do-While" statement
				// I'm setting it up ~AND~ initializing it to be "true"

				do
				// this "do-while" statement asks for a valid integer for the number of variables
				// these variables will later be stored as the length of an array. the only reason why a "Do-While statement"
				// is being used is because if the user enters in any value less than 2 then the array won't work correctly.
				// it is infinite until a proper integer is entered. inputting a string or characters or numbers with
				// decimal points will give an error
					{ // START OF DO-WHILE STATMENT
			            System.out.print("\nHow many variables would you like to use?"
			            		+ "\nInteger value greater than 1 please: ");
			    // printing out to screen user instructions
	            		numVars = userInput.nextInt();
	            // this takes in user input and assigns it to "numVars" which was set up outside the loop
				// notice the "(variable).nextInt", it's important.
			            if (numVars >= 2)
			    // this if statement checks to see if "numVars" is greater than or equal to true
			    // if it is it does the following
			            	{ // START OF IF PART OF IF-ELSE STATEMENT
			            		checking = false;
			    // it sets the boolean "checking" to false which will break the "Do-While" statement
			            	} // END OF IF PART OF IF-ELSE STATEMENT
			            else
			    // for any other integer that does not satisfy the previous requirement then it makes this happen
			            	{ // START OF ELSE PART OF IF-ELSE STATEMENT
			            		System.out.print("\nYou have entered in an invalid value. Please Try Again.\n\n");
			    // prints out more user instruction and keeps the "Do-While" loop going. it'll cycle until the user breaks
			    // the code or until proper input is inserted.
			            	} // END OF ELSE PART OF IF-ELSE STATEMENT
					} // END OF DO-WHILE STATMENT
				while ( checking ) ;
// End of asking for number of variables desired block	

// Start of doing the math stuff
				double [] varIn = new double[numVars];
				// this is what an array looks like, it's an array containing doubles
				// the length of the this array is "numVars"
				// alternatively you can set your own arrays like so:
				// "double [] (name of variable) = new double[]{(series of numbers separated by commas)};"
				// "double [] (name of variable) = {(series of numbers separated by commas)};"
				// "double [] (name of variable) = new double[(this defines the array's capacity)];"
				// do not put in the parenthesis when coding or it won't work
	    		System.out.print("\nPlease enter in " + numVars + " values:");
	    		// prints to console, inserts what "numVars" is and then adds more print to console
			    for ( int x = 0 ; x < numVars ; x++ )
			    // syntax for the "for" statement is first a starting point 
			    // "(primitive numerical data type) (variable name) = (value)" followed by semicolon
			    // "(variable name) compare to (a different variable or a value)" followed by semicolon
			    // "(variable name) (do something to it)", this can be ++ or it can be "x = x+2"
			    // "++" means add 1, "--" means subtract one, but you can't just write "x+2", needs to be "x = x+2"
			    // you don't have to initialize before hand, but you HAVE to initialize inside the statement
			    // you are not required to insert the data type if you already defined it outside of the loop
			    // "=" means assigned to and "==" means equal to
			    // equal to means you're comparing and checking to see if it's the same on the other side of "=="
				// assigned to means you're assigning the value on the other side of "="
			    // you do the comparison in the middle part so you use "==" there
			    // you do calculations in the end so you put "=" there, here is a different example
			    // "for (int x = -1 ; x == numVars ; x = x + numVars )"
					{ // START OF FOR STATEMENT
			    		varIn[x] = userInput.nextDouble();
			    // since an array's index starts at 0, I set "x" to 0, while "x" is less than "numVars" it will input data
			    // this will continuously store user input into varIn[] until the capactiy is reached, which is "numVars"
					} // END OF FOR STATEMENT
			    Arrays.sort(varIn);
			    // this is super easy, all it does is call upon the Array library we imported in and sorts all the values
			    // in the array that's in the parenthesis, how awesome is that, you don't even need math max and min
			    double range = varIn[numVars - 1] - varIn[0];
			    // here I set (defined it's data type) and initialized (assigned a value to) a new "double" type variable
			    // this is a simple math equation to evaluate the difference between the highest and the lowest values
			    double totArr = 0;
				// set and initialized a new "double" type variable for the incoming "For-Each" statement
			    for( double d : varIn ) // besides enumerators, this is the single biggest thing I've struggled to wrap my head around
			    // for each "d" do the following for the length of array "varIn"
			    	{ // START OF FOR STATEMENT
			    		totArr += d; // can be rewritten as "totArr = totArr + d;"
			    // totArr is just a way to create the sum of all the values inside the array, which we'll need for computing the average
			    	} // END OF FOR STATEMENT
			    double avg = totArr / numVars;
				// here I set (defined it's data type) and initialized (assigned a value to) another new "double" type variable
				// this is a simple math equation, takes the total of the values of the array and
			    // divides by the number of values inside the array
			    if ( answer.equals("long") )
			    // if the user selected "long" as their answer then this code will run
			    	{ // START OF IF PART OF 1ST IF-ELSEIF-ELSE STATEMENT
					    System.out.print("\nThe min value is: " + (long)varIn[0]);
					    System.out.print("\nThe max value is: " + (long)varIn[numVars - 1]);
					    System.out.print("\nThe range between the values is: " + (long)range);
						System.out.print("\nThe average of the values is: " + avg);
						System.out.print("\nThe values given are: ");
				// prints out information to the screen
				// also the "(long)" casts the double "varIn[0]", which means it makes a double into an "long"
				// the number "0" inside the array indicates the very first variable in the array set
				// the expression "numVars-1" inside the array means the very last value in the array set
				// remember arrays start at 0 not 1, so if I didn't add the "-1" then it would reach a non existing
				// value, for example for an array with the 3 numbers "10, 20, 30", index 0 is 10, index 1 is 20
				// and index 2 is 30 which is the final value of that array set
				// notice everything is being cast to "(long)", I'm actually being very slick by doing this
				// because this allows me to use the same equations and same values, all I'm doing is tweaking what's
				// posted on the console, no one would ever know that I'm casting without looking at the code
						for ( double y = 0 ; y < varIn.length ; y++ )
				// this "for" statement will systematically print out the values and separate them with commas
				// because our array is a double we have to initialize and set the local variable as well
				// not doing so will give you an error
							{ // START OF NESTED FOR STATEMENT
					    		if ( y == numVars-1 )
				// this is set up so the last value will have a "." instead of a ", "
					    			{ // START OF IF OF NESTED IF-ESLE STATEMENT
					    				System.out.print((long)varIn[(int)y] + ".");
				// this is where it gets tricky, you have to cast the local variable into an "(int)" to use it inside the
				// array, because by these syntax, the local variable is considered current index which is only an integer
					    			} // END OF IF OF NESTED IF-ESLE STATEMENT
					    		else
					    			{ // START OF ELSE OF NESTED IF-ESLE STATEMENT
					    				System.out.print((int)varIn[(int)y] + ", ");		    			
					    			} // END OF ELSE OF NESTED IF-ESLE STATEMENT
							} // END OF NESTED FOR STATEMENT
			    	} // END OF IF PART OF 1ST IF-ELSEIF-ELSE STATEMENT
			    else if ( answer.equals("double") )
			    // if the user selected "double" as their answer then this code will run
			    	{ // START OF ELSEIF PART OF 1ST IF-ELSEIF-ELSE STATEMENT
					    System.out.print("\nThe min value is: " + varIn[0]);
					    System.out.print("\nThe max value is: " + varIn[numVars - 1]);
					    System.out.print("\nThe range between the values is: " + range);
						System.out.print("\nThe average of the values is: " + avg);
						System.out.print("\nThe values given are: ");
				// prints out information to the screen, notice that nothing is being cast. 
				// other than the casting it's identical to the stuff above, read the notes above for more information
						for ( double z = 0 ; z < varIn.length ; z++ )
				// this "for" statement will systematically print out the values and separate them with commas
				// refer to notes above for this "for" statement, it's identical minus the casting of "(long)"
							{ // START OF NESTED FOR STATEMENT
					    		if ( z == numVars-1 )
				// this is set up so the last value will have a "." instead of a ", "
					    			{ // START OF IF OF NESTED IF-ESLE STATEMENT
					    				System.out.print(varIn[(int)z] + ".");		    			
					    			} // END OF IF OF NESTED IF-ESLE STATEMENT
					    		else
					    			{ // START OF ELSE OF NESTED IF-ESLE STATEMENT
					    				System.out.print(varIn[(int)z] + ", ");		    			
					    			} // END OF ELSE OF NESTED IF-ESLE STATEMENT
							} // END OF NESTED FOR STATEMENT
			    	} // END OF ELSEIF PART OF 1ST IF-ELSEIF-ELSE STATEMENT
			    else
			    // this is just a fail safe, this should never be reached ever
			    	{ // START OF ELSE PART OF 1ST IF-ELSEIF-ELSE STATEMENT
			    		System.out.print("\nYou have reached an error.\n\n");
			    // prints to the console
			    		System.exit(0);
			    // terminates the program
			    	} // END OF ELSE PART OF 1ST IF-ELSEIF-ELSE STATEMENT
// End of doing the math stuff

			    userInput.close(); // closes the scanner keyboard to avoid resource leaks
			} // END OF MAIN
	} // END OF CLASS