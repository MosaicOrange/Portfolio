package CatAnimals;



public class Panther extends Feline
	{
		final public boolean WILD = true;
			
		///////////////////////// constructors ///////////////////
		public Panther()
			{
				super();
			}
		
		public Panther(Panther l)
			{
				name=l.name;
				color=l.color;
				sound=l.sound;
				size=l.size;
			}//end one constructor
		
		public Panther(String n, String c, String s, double kg)
			{
				super(n, c, s, kg);
				
			}

		///////////////////////// toString() ///////////////////
		public String toString()
			{
				String toReturn1 = " Panther Wild = "  + WILD	+ ".\n";
				return ("Panther:  \n" + super.toString() + toReturn1	+ "\n\n");
			}// end toString()
		///////////////////////// equals() ///////////////////
		public boolean equals(Panther kg)
			{
				if (super.equals(kg))
				return true;
				else
				return false;
			}//end equals()	
		///////////////////////// compareTo() ///////////////////
		
		public int compareTo (Object o)
			{
				Feline c =(Feline) o;
				if(size > c.size+del){return 1;}
				else
				if(size +del < c.size) {return -1;}
				else
				return 0;
			}// end compareTo()
		///////////////////////// sets() ///////////////////
	
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
			
		public void setsize (double KG)
			{
				size = KG;
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
		
		public boolean getWild ()
			{
				return WILD;
			}
		
	}// end class Panther
