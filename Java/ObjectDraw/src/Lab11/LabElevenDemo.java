package Lab11;
import java.io.*;

public class LabElevenDemo
	{
		public static void main ( String [] args ) throws IOException
			{
				TwoDimArray starNight = new TwoDimArray();
				starNight.readInData();
				System.out.println("printing the digital array");
				starNight.printData();
				
				
				starNight.createMap();
				System.out.println("printing the char array");
				starNight.printMap();
			}
	}
