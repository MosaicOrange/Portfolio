package RoundOneHockey;
import java.io.*;

public class League
	{
		private  int numTeams;
		private Team[] league;

		public League () {}

		public int search(String key)
			{
				boolean found = false;
				int i = 0;
				while ( ! found && i < numTeams )
					{
						if(league[i].getTeam().equals(key))
							{found = true;}
						else
							{i++;}
					}
				if (found)
					{return i;}
				else
					{return(-1);}
			}

		private  void swap (int first, int second)
			{  
				Team temp;
				temp = league[first];
				league[first] = league[second];
				league[second] = temp;
			}

		public void sort ()
			{
				int i, j, minSubscript;
				for ( i = 0; i < numTeams-1; i++)
					{ 
						minSubscript = i;
						for ( j = i ; j < numTeams; j ++ )
							{
								if (league[j].getPlayed() < league[minSubscript].getPlayed())
								minSubscript = j;
							}
						swap ( i, minSubscript );
					} 
			}

		public void getData() throws IOException
			{
				BufferedReader input = new BufferedReader(new FileReader("firstround.txt"));
				String str = input.readLine();
				numTeams = Integer.parseInt(str);
				league = new Team [numTeams];
				for(int i = 0; i < numTeams; i++)
					{
						league[i] = new Team();
						league[i].readInput(input);
					}
			}

		public void displayInventory()
			{
				System.out.println("The First Round");
				System.out.println("Team    \tPlayed\tWins\tLosses\tTies\tPoints");
				for (int  i = 0; i <= numTeams -1; i++)
					{
						league[i].writeOutput();
					}
			}
	}