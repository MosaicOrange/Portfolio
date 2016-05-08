package lab12;

public class CIT314StudentClass extends CSISstudentClass
	{
		private String grade;
		private int hours;
		
		public CIT314StudentClass ( )
			{
				super();
				grade = "A";
				hours = 25;
			}
		public void writeOutput ()
			{
				super.writeOutput();
				System.out.println ( "your grade is " + grade);
				System.out.println ( "your study hours are " + hours);
			}
		public void setHours ( int newHours )
			{
				hours = newHours;
			}
		public void setGrade ( String newGrade )
			{
				grade = newGrade;
			}
	}
