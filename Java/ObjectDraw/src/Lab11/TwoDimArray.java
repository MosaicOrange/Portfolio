package Lab11;
import java.io.*;
import java.util.*;

public class TwoDimArray
	{
		private int [][] matrix;
		private char [][] map;
		
		public TwoDimArray ()
		{
			matrix = new int [6][16];
			map = new char [6][16];
		}
		
		public void readInData () throws IOException
			{
				BufferedReader input = new BufferedReader ( new FileReader ("starNumbers.txt" ));
				int row, column,number;
				String numberString;
				for ( row = 0; row < 6; row ++ )
					{
						for ( column = 0; column < 16; column ++)
							{ 
								numberString = input.readLine ();
								number = Integer.parseInt (numberString);
								matrix[row][column] = number; 
							}
					}
			}
		
		public void printData()
			{
				int row, column;
				for ( row = 0; row < 6; row ++ )
					{
					for ( column = 0; column < 16; column ++)
						{
							System.out.print(matrix[row][column] + "\t");
						}
						System.out.println();
					}
			}
		
		public void createMap ( )
			{
				int row, col;
				double sum;

				for ( row = 0; row < 6; row ++)
					{
						for ( col = 0; col < 16; col ++)
							{
								map[row][col] = ' ';
							}
					}

				for ( row = 1; row < 5; row ++ )
					{
						for ( col = 1; col < 15; col ++ )
							{
								sum = matrix[row][col] + matrix [row-1][col] + matrix [row+1][col] + matrix [row][col-1] + matrix [row][col+1];
								if ( (sum/5) > 6 )
									{
										map[row][col] = '*';
									}
							}
					}
			}
		
		public void printMap ()
			{
				int row, column;
				for ( row =0; row < 6; row++)
					{
						for ( column = 0; column < 16;  column ++)
							{
								System.out.print(map[row][column] + "\t");
							}
						System.out.println();
					}
			}
	}
