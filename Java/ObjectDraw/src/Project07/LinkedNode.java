package Project07;
class LinkedNode
{
	public  Object  data;
	public   LinkedNode  next;

	public LinkedNode ( String newData ) {
		 data = newData;
		 next = null;
        }

	public void displayNode ()	{
		System.out.print ( data  + " -> " );
	}

}