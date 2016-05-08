package CatAnimals;

public abstract class Feline implements Comparable
	{
		protected String	name="";
		protected String	color="";
		protected String	sound="";
		protected double 	size=0.0;
			
		///////////////////////// constructors ///////////////////
	
		public Feline()
			{
			}//end no arg constructor
		
		public Feline(Feline l)
			{
				name=l.name;
				color=l.color;
				sound=l.sound;
				size=l.size;
			}//end one constructor
		
		public Feline(String n, String c, String s, double kg)
			{
				name=n;
				color=c;
				sound=s;
				size=kg;
			  	
			 }// end one arg constructor
		
		public  int compareSize (Object d)
			{
				Feline a =(Feline) d;
				if(size > a.size + del){return 1;}
				else
				if(size + del < a.size) {return -1;}
				else
				return 0;
			}// end compareSize()
		
		///////////////////////// toString() ///////////////////
		public String toString()
			{
				String toReturn0 = " Feline A  Name 	= "  	+ name			+ ".\n";
				String toReturn1 = " Feline B  Color	= "  	+ color			+ ".\n";
				String toReturn2 = " Feline C  Sound	= "  	+ sound			+ ".\n";
				String toReturn3 = " Feline D  Size		= "  	+ size	 		+ ".\n";
				
				return ("Feline:\n" + toReturn0 + toReturn1 +  toReturn2 +  toReturn3  + "\n");
			}// end toString()
	
		///////////////////////// equals() ///////////////////
	
		public double del = (double) 10E-4;
		
		public boolean deq(double d1, double d2)
			{
				return ((Math.abs(d1-d2))<del);
			}
	
		public boolean equals(Feline l)
			{
				if((name.equals(l.name))&&(color.equals(l.color))&&(sound.equals(l.sound))&&
				deq(size, l.size))
				{return true;}
				else
				{return false;}
			}// end equals()
	
		////////////////////////// sets ///////////////////
		public void setName (String N)
			{
				name = N;
			}
	
		public void setColor (String C)
			{
				color = C;
			}
		
		public void setSound (String S)
			{
				sound = S;
			}
		
		public void setSize (double kg)
			{
				size = kg;
			}
		
		///////////////////////// gets ///////////////////
		
		public String getName ()
			{
				return name;
			}
	
		public String getColor ()
			{
				return color;
			}
	
		public String getSound ()
			{
				return sound;
			}
		
		public double getSize ()
			{
				return size;
			}
	}// end class Feline