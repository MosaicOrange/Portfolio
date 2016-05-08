package Lab13;
class LinkedNode
{
	public  Object data;
	public   LinkedNode  next;

	public LinkedNode ( Object newData)
	{
		 data = newData;
		 next = null;
        }

	public void displayNode ( )
	{
		System.out.print (  data  + " -> " );

	}


}