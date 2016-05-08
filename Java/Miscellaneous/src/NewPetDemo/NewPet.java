package NewPetDemo;
public class NewPet
	{
	    private String name;
	    private int age;
	    private double weight;
	    private String color;
	    private int legs;
	
		public NewPet(String initialName, int initialAge, double initialWeight, String initialColor, int initialLegs)
			{
				set(initialName, initialAge, initialWeight, initialColor, initialLegs);
			}
		
		public NewPet()
			{
				this("No name yet.", 0, 0, "No Color Yet", 0);
			}
		    
		public void setPet(String newName, int newAge, double newWeight, String newColor, int newLegs)
			{
				set(newName, newAge, newWeight, newColor, newLegs);
			}
		
	    public void setName(String newName)
	    	{
	    		set(newName, age, weight, color, legs);
	    	}
	    
	    public void setAge(int newAge)
	    	{
	    		set(name, newAge, weight, color, legs);
	    	}
	
	    public void setWeight(double newWeight)
	    	{
	    		set(name, age, newWeight, color, legs);
	    	}
	
	    public void setColor(String newColor)
	    	{
	    		set(name, age, weight, newColor, legs);
	    	}
	    
	    public void setLegs(int newLegs)
	    	{
	    		set(name, age, weight, color, newLegs);
	    	}
	      
		private void set(String newName, int newAge, double newWeight, String newColor, int newLegs)
			{
				name = newName;

				if ( (newAge < 0) || (newWeight < 0) || (newLegs < 0) ) {
						System.out.println("Error: Negative age or weight or legs.");
						System.exit(0);
					} else {
						age = newAge;
						weight = newWeight;
						legs = newLegs;
					}

				color = newColor;
			}
	
	    public String getName()
	    	{
	    		return name;
	    	}
	    
	    public int getAge()
	    	{
	    		return age;
	    	}
	    
	    public double getWeight()
	    	{
	    		return weight;
	    	}
	
	    public String getColor()
	    	{
	    		return color;
	    	}
	    
	    public int getLegs()
	    	{
	    		return legs;
	    	}
		
	    public void writeOutput()
	    	{
		        System.out.println("Name:   " + name);
		        System.out.println("Age:    " + age + " years");
		        System.out.println("Weight: " + weight + " pounds");
		        System.out.println("Color: " + color);
		        System.out.println("Legs: " + legs + " legs");
	    	}
	}
