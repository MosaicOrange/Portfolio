package Lab10;
import java.io.*;
public class Lab10Demo
{	  public static void main(String arg[]) throws IOException
	  {
	 	InventoryClass  PaceInventory = new InventoryClass();
	  	PaceInventory.getData();
	  	PaceInventory.displayInventory();
	  	PaceInventory.updateInventory();
	  	PaceInventory.discount();
	  	PaceInventory.sort();
	  	PaceInventory.displayInventory();
	  }
}