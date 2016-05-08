package DogAnimals;

public class Dog extends Canine
	{
		final public boolean DOMESTICATED = true;
			
		///////////////////////// constructors ///////////////////
		public Dog()
			{
				super();
			}
		
		public Dog(Dog l)
			{
				name=l.name;
				sound=l.sound;
				weight=l.weight;
			}//end one constructor
		
		public Dog(String n, String s,  double w)
			{
				super(n, s, w);
			}
	
	///////////////////////// toString() ///////////////////
		public String toString()
			{
				String toReturn1 = " Dog DOMESTICATED = "  + DOMESTICATED	+ ".\n";
				return ("Dog:  \n" + super.toString() + toReturn1	+ "\n\n");
			}// end toString()
		///////////////////////// equals() ///////////////////
		public boolean equals(Dog w)
			{
				if (super.equals(w))
				return true;
				else
				return false;
			}//end equals()	
		///////////////////////// compareTo() ///////////////////
	
		public int compareTo (Object o)
			{
				Canine c =(Canine) o;
				if(weight > c.weight+del){return 1;}
				else
				if(weight +del < c.weight) {return -1;}
				else
				return 0;
			}// end compareTo()
		///////////////////////// sets() ///////////////////
	
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
		
		public boolean getDomesticated ()
			{
				return DOMESTICATED;
			}
	}// end class Dog
