package Project05;
import java.io.*;

public class MagicDemo
	{
		public static void main ( String [] args ) throws IOException
			{
				MagicClass perfectSquare = new MagicClass();
				BufferedReader input = new BufferedReader (new FileReader ("infile.txt"));

				for ( int i =0; i<5; i++)
					{
						perfectSquare.readInMatrix(input);
						perfectSquare.printMatrix();
						perfectSquare.findStandardTotal();

						if (perfectSquare.searchRows() && perfectSquare.searchLeftToRightDiagnonals()
								&& perfectSquare.searchRightToLeftDiagnonals() && perfectSquare.searchCols() )
							{
								System.out.println ("This is a magic square");
							}
						else
							{
								System.out.println ("This is not a magic square");
							}
					}
			}
	}