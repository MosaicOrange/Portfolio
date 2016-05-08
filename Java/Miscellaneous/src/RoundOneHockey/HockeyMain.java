package RoundOneHockey;
import java.io.*;

public class HockeyMain
	{
		public static void main(String arg[]) throws IOException
			{
				League PaceInventory = new League();
				PaceInventory.getData();
				PaceInventory.displayInventory();
			}
	}

