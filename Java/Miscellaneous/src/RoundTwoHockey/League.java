package RoundTwoHockey;

import java.io.*;

public class League
	{
		private int numTeams;
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
								if (league[j].getPoints() > league[minSubscript].getPoints())
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

		public void readSecondRound () throws IOException
		
		{
			String homeTeam;
			String awayTeam;
			int homeScore;
			int awayScore;
			BufferedReader input2 = new BufferedReader(new FileReader("hockey.txt"));
			System.out.println();
			for (int j = 0; j < 66 ; j++)
	{
		homeTeam =  input2.readLine();
		homeScore = Integer.parseInt(input2.readLine());
		awayTeam  = input2.readLine();
		awayScore = Integer.parseInt(input2.readLine());

		int homeTeamSubscript = search(homeTeam);
		int awayTeamSubscript = search(awayTeam);
		
		
						
			league[homeTeamSubscript].setPlayed(league[homeTeamSubscript].getPlayed() + 1);
			league[awayTeamSubscript].setPlayed(league[awayTeamSubscript].getPlayed() + 1);
									
			if (homeScore > awayScore)
		{
			league[homeTeamSubscript].setWins(league[homeTeamSubscript].getWins() + 1);
			league[awayTeamSubscript].setLosses(league[awayTeamSubscript].getLosses() + 1);
										}
			else if (homeScore < awayScore)
		{
		league[homeTeamSubscript].setLosses(league[homeTeamSubscript].getLosses() + 1);
		league[awayTeamSubscript].setWins(league[awayTeamSubscript].getWins() + 1);
		}
						
						
	else // (homeScore[j] == awayScore[j])
	{
	league[homeTeamSubscript].setTies(league[homeTeamSubscript].getTies() + 1);
	league[awayTeamSubscript].setTies(league[awayTeamSubscript].getTies() + 1);
										
	}
								}
							
			
		}
		
		public void setPoints() 
		{
			for ( int i = 0; i <numTeams; i++)
			
			league[i].setPoints((league[i].getWins() * 2) + league[i].getTies());
			
		}

		public void display()
			{

				System.out.println("Team    \tPlayed\tWins\tLosses\tTies\tPoints");
				for (int  i = 0; i <= numTeams -1; i++)
					{
						league[i].writeOutput();
					}
			}
	}