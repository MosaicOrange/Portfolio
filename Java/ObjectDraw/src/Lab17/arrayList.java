package Lab17;
import java.util.ArrayList;
import java.util.Scanner;

public class arrayList
	{
		public static ArrayList<String> toDoList = new ArrayList<String> ();

		public static void main (String [] args)
			{
				System.out.println(toDoList.size());
				boolean done = false;
				Scanner keyboard = new Scanner (System.in );

				System.out.println ("Enter items for the list, when prompted");
	
				while ( !done )
					{
						System.out.println ("Type an entry:");
						String   entry = keyboard.nextLine ();
						toDoList.add(entry);
						System.out.print("More items for the list?");
						String  ans = keyboard.nextLine ();
						if ( !ans.equalsIgnoreCase("yes"))
							{
								done = true;
							}
					}

				int size = toDoList.size();
				String contentAdd = "addition at index point:" + (size);
				printing();
				String contentSet = "modified content at index point 0";
				toDoList.add(size, contentAdd);
				printing();
				toDoList.set(size-2, contentSet);
				printing();
				toDoList.remove(1);
				printing();
				System.out.println(toDoList.get(2));
				toDoList.clear();
				System.out.println("content cleared");
				printing();
			}
	
		private static void printing()
			{
				System.out.println ("The list contains;");
				for (String content: toDoList)
					{
						System.out.println (content);
					}
			}
	}