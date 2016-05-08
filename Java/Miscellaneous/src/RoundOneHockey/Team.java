package RoundOneHockey;
import java.io.*;

public class Team
	{
		private  String team;
		private int played, wins, losses, ties, points;

		Team()
			{
				team = "No name";
				played = 0;
				wins = 0;
				losses = 0;
				ties = 0;
				points = 0;
			}

		public void readInput(BufferedReader  input) throws IOException
			{
				team = input.readLine();
				String str = input.readLine();
				played = Integer.parseInt(str);
				str = input.readLine();
				wins = Integer.parseInt(str);
				str = input.readLine();
				losses = Integer.parseInt(str);
				str = input.readLine();
				ties = Integer.parseInt(str);
				str = input.readLine();
				points = Integer.parseInt(str);
			}

		public void writeOutput()
			{
				System.out.println(team + "   \t" + played+ "\t" + wins + "\t" + losses + "\t" + ties + "\t" + points);
			}

		public void setTeam (String newTeam)
			{team = newTeam;}
		public String  getTeam ( )
			{return team;}

		public void setPlayed (int newPlayed)
			{played = newPlayed;}
		public int getPlayed()
			{return played;}

		public void setWins (int newWins)
			{wins = newWins;}
		public int getWins()
			{return wins;}

		public void setLosses (int newLosses)
			{losses = newLosses;}
		public int getLosses()
			{return losses;}

		public void setTies (int newTies)
			{ties = newTies;}
		public int getTies()
			{return ties;}

		public void setPoints (int newPoints)
			{points = newPoints;}
		public int getPoints()
			{return points;}
	}