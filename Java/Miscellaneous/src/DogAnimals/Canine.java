package DogAnimals;

public abstract class Canine implements Comparable
	{
		protected String	name="";
		protected String	sound="";
		protected double 	weight=0.0;
			
		///////////////////////// constructors ///////////////////
	
		public Canine()
			{
			}//end no arg constructor
		
		public Canine(Canine l)
			{
				name=l.name;
				sound=l.sound;
				weight=l.weight;
			}//end one constructor
		
		public Canine(String n, String s, double w)
			{
				name=n;
				sound=s;
				weight=w;
			 }// end one arg constructor 
		
		///////////////////////// toString() ///////////////////
	
		public String toString()
			{
				String toReturn0 = " Canine 1  Name 	= "  	+ name			+ ".\n\n";
				String toReturn1 = " Canine 2  Sound	= "  	+ sound			+ ".\n\n";
				String toReturn2 = " Canine 3  Weight	= "  	+ weight 		+ ".\n";
				
				return ("Canine:\n" + toReturn0 + toReturn1 +  toReturn2  + "\n\n");
			}// end toString()
	
		///////////////////////// equals() ///////////////////
	
		public double del = (double) 10E-4;
		
		public boolean deq(double d1, double d2)
			{
				return ((Math.abs(d1-d2))<del);
			}
	
	
		public boolean equals(Canine l)
			{
				if((name.equals(l.name))&&(sound.equals(l.sound))&&
				deq(weight, l.weight))
				{return true;}
				else
				{return false;}
			}// end equals()
	
		////////////////////////// sets ///////////////////
		public void setName (String N)
			{
				name = N;
			}
	
		public void setSound (String S)
			{
				sound = S;
			}
		
		public void setWeight (double w)
			{
				weight = w;
			}
		
	///////////////////////// gets ///////////////////
		
		public String getName ()
			{
				return name;
			}
		
			public String getSound ()
			{
				return sound;
			}
			
			public double getWeight ()
			{
				return weight;
			}
		
	}// end class Canine


