package CatAnimals;

public class Cat extends Feline
	{
		final public boolean WILD = false;
			
		///////////////////////// constructors ///////////////////
		public Cat()
			{
				super();
			}
		
		public Cat(Cat l)
			{
				name=l.name;
				color=l.color;
				sound=l.sound;
				size=l.size;
			}//end one constructor
		
		public Cat(String n, String c, String s,  double kg)
			{
				super(n, c, s, kg);
				
			}
	
		///////////////////////// toString() ///////////////////
		public String toString()
			{
				String toReturn1 = " Cat WILD = "  + WILD	+ ".\n";
				return ("Cat:  \n" + super.toString() + toReturn1	+ "\n\n");
			}// end toString()
	
		///////////////////////// equals() ///////////////////
		public boolean equals(Cat kg)
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
			
		public void setSize (double w)
			{
				size = w;
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
	}// end class Cat