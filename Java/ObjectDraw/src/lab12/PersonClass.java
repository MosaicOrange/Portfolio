package lab12;

class PersonClass
{
	private String name;
	private String phone;
	private String address;
	
	public PersonClass ( )
	{
		name = "No name";
	}
	
	public  PersonClass (String newName)
	{
		name = newName;
	}
	
	public PersonClass ( String newName, String newAddress, String newPhone)
	{
		name = newName;
		address = newAddress;
		phone = newPhone;
	}
	
	public void setName( String newName )
	{
		name = newName;
	}

	public String getName()
	{
		return name;
	}
	
	public String getPhone()
	{
		return phone;
	}
	
	public String getAddress()
	{
		return address;
	}

  public void changeName ( String newName )
	{
		name = newName;
	}
	
	public boolean sameName ( PersonClass otherPerson)
	{
		 if( name.equals (otherPerson.name ))
		 	return true;
		 else
		 	return false;
	}
	
	public void writeOutput ( )
	{
		System.out.println( " name is " + name );
	}	
}		 	
		 
		 	   