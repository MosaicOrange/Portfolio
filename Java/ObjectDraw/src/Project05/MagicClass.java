package Project05;
import java.io.*;
import java.util.StringTokenizer;

public class MagicClass
	{
		private int standardTotal;
		private int [] [] magicSquare;
		private int size;
		String stringSize, inputString;

		public MagicClass ()
			{
				standardTotal = 0;
			}

		public void readInMatrix (BufferedReader input) throws IOException
			{
				int col, row, value;

				stringSize = input.readLine();
				size = Integer.parseInt(stringSize);

				System.out.println ("The size of this alleged magic square is" + size);
				magicSquare = new int [size] [size];

				for (row = 0; row<size; row = row + 1)
					{
						inputString = input.readLine();
						StringTokenizer tokens = new StringTokenizer (inputString);
						for (col = 0; col < size; col++)
							{
								value = Integer.parseInt (tokens.nextToken ());
								magicSquare [row] [col] = value;
							}
					}
			}

		public boolean searchRows()
			{
				int col, sum = 0, row = 0; 
				boolean magicRows = true ;

				while (magicRows == true && row < size)
					{
						sum = 0;
						for (col = 0; col < size; col ++)
							{
								sum = sum + magicSquare [row] [col];
							}
						if (sum!= standardTotal)
							{
								magicRows = false;
							}
						else 
							{
								row = row +1;
							}
					}
				return magicRows;
			}

		public boolean searchLeftToRightDiagnonals ()
			{
				
					int sum = 0, row = 0;
					boolean magicDiagonals = true;
					for(row = 0; row < size; row++)
						{
							sum = sum + magicSquare[row][row];
						}
	
					{
						if(sum != standardTotal)
							{
								magicDiagonals = false;
							}
						else
							{
								row = row + 1;
							}
					}
				return magicDiagonals;
			}

		public boolean searchRightToLeftDiagnonals ()
			{
				int row, column = 0, sum = 0;
				boolean magicDiagonals = true;
				for(row = size -1; row >=0; row--)
					{
						sum = sum + magicSquare[row][column];
					}
				if(sum != standardTotal)
					{
						magicDiagonals = false;
					}
					
				else
					{
						row = row - 1;
						column = column + 1;
					}
				return magicDiagonals;
			}

		public void findStandardTotal ()
			{
				int sum = 0;
				for (int i = 0; i < size; i ++)
					{
			           sum = sum + magicSquare [i] [0];
					}
				standardTotal = sum;
				System.out.println ("Your standard total is:" + standardTotal);
			}

		public void printMatrix()
			{
				int row, column;
				for ( row = 0; row < size; row ++ )
					{
						for ( column = 0; column <size; column ++)
							{
								System.out.print(magicSquare [row] [column] +" ");
							}
						System.out.println();
					}
			}

		public boolean searchCols()
			{
				int row, sum, col = 0; 
				boolean magicCols = true ;
				while (magicCols == true && col < size)
					{
						sum = 0;
						for (row = 0; row < size; row ++)
							{
								sum = sum + magicSquare [row] [col];				
							}
						if (sum!= standardTotal)
							{
								magicCols = false;
							}
						else 
							{
								col = col +1;			
							}
					}
				return magicCols;
			}

	}
