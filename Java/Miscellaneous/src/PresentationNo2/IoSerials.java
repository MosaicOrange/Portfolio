package PresentationNo2;

import java.io.Serializable;

//Serialized class for data on endangered species.
public class IoSerials implements Serializable
	{
		private String name; 
		private int population;
		private double growthRate;
	
		public IoSerials()
			{
				name = null;
				population = 0;
				growthRate = 0;
			}
	
		public IoSerials(String initialName, int initialPopulation,	double initialGrowthRate)
			{
				name = initialName;
				if (initialPopulation >= 0)
					{
						population = initialPopulation;
					}
				else
					{
						System.out.println("ERROR: Negative population.");
						System.exit(0);
					}
				growthRate = initialGrowthRate;
			}
	
		public String toString()
			{
				return ("Name = " + name + "\n" + "Population = " + population + "\n" + "Growth rate = " + growthRate + "%");
			}
	}
//End Part 4