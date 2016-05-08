package Lab13;

public class IntLinkedNode
{
  public  int info;
  public  IntLinkedNode  next;

  public IntLinkedNode(int newValue)
  {
      info = newValue;
      next = null;
  }

  public void displayNode()
  {
    System.out.print ( info + " -> " );
  }

}
