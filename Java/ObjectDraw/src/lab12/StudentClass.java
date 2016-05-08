package lab12;

public class StudentClass extends PersonClass
{
	private int classYear;
	private double gpa;
	private int creditHours;
	private boolean  billsPaid;
	
	
	
	public StudentClass ()
	{
		super ();
		classYear = 1;
	}
	
	public StudentClass ( String newName, int newYear)
	{
		super(newName);
		classYear = newYear;
	}
	
	public int getClassYear()
	{
		return classYear;
	}
	
	public void changeYear(int newYear)
	{
		classYear =newYear;
	}
	
	public void writeOutput( )
	{
		super.writeOutput();
		System.out.println ( "  Year = " + classYear);
	}		
}	
	