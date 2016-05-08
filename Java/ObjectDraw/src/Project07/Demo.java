package Project07;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;

import java.awt.*; 
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Demo  extends JFrame implements ActionListener {

	public static final int WIDTH = 600;
	public static final int HEIGHT = 300;
	public static final int LINES = 10;
	public static final int CHAR_PER_LINE = 40;
	private JTextArea theText;
	private String addTemp = null;
	private String deleteTemp = null;
	private String searchTemp = null;

	public String name = null, answer = null, response = null, redo, input;
	public static String reference = "M";
	public String moreFunctions;
	public boolean error = true, redoError, mistake = true, massiveLoop = true, conditionalBoolean;
	public static LinkedListClass drTaosList = new LinkedListClass ();
	public static LinkedListClass drCourtneysList = new LinkedListClass ();
	
    public Demo()
    {
        setSize(WIDTH, HEIGHT);
        addWindowListener(new WindowDestroyer()); 
        setTitle("Demo"); 
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.white);
        buttonPanel.setLayout(new FlowLayout());
        JButton memo1Button = new JButton("Add"); 
        memo1Button.addActionListener(this);
        buttonPanel.add(memo1Button); 
        JButton memo2Button = new JButton("Delete"); 
        memo2Button.addActionListener(this);
        buttonPanel.add(memo2Button);
        JButton clearButton = new JButton("Search"); 
        clearButton.addActionListener(this);
        buttonPanel.add(clearButton);
        JButton get1Button = new JButton("Dr. Tao's List"); 
        get1Button.addActionListener(this);
        buttonPanel.add(get1Button);
        JButton get2Button = new JButton("Dr. Courtney's List"); 
        get2Button.addActionListener(this);
        buttonPanel.add(get2Button);
        
        contentPane.add(buttonPanel, BorderLayout.NORTH);
      
        JPanel textPanel = new JPanel(); 
        textPanel.setBackground(Color.blue);
    
        theText = new JTextArea(LINES, CHAR_PER_LINE);
        theText.setBackground(Color.white);
        textPanel.add(theText);
        contentPane.add(textPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) 
    {
        String actionCommand = e.getActionCommand();
        if (actionCommand.equals("Add"))
        	{
	            addTemp = theText.getText();
		        if(addTemp.compareTo(reference) < 0) {
					drTaosList.addStudent(addTemp);
				} else if(addTemp.compareTo(reference) > 0) {
					drCourtneysList.addStudent(addTemp);
				} else { System.out.println("This Should Never Be Reached!"); 
				}
        	}
        else if (actionCommand.equals("Delete"))
            {
        		deleteTemp = theText.getText();
				if(deleteTemp.compareTo(reference) < 0) {
					drTaosList.deleteStudent(deleteTemp);
				} else if(deleteTemp.compareTo(reference) > 0) {
					drCourtneysList.deleteStudent(deleteTemp);
				} else { System.out.println("This Should Never Be Reached!"); }
            }
        else if (actionCommand.equals("Search"))
            {
        		searchTemp = theText.getText();
				if(searchTemp.compareTo(reference) < 0) {
					drTaosList.searchStudent(searchTemp);
					System.out.println(" on Dr. Tao's List.");
				} else if(searchTemp.compareTo(reference) > 0) {
					drCourtneysList.searchStudent(searchTemp);
					System.out.println(" on Dr. Courtney's List.");
				} else { System.out.println("This Should Never Be Reached!"); }
            }
        else if (actionCommand.equals("Dr. Tao's List"))
        	{
	            drTaosList.printList();
	            System.out.println();
        	}
        else if (actionCommand.equals("Dr. Courtney's List"))
	    	{
	        	drCourtneysList.printList();
	            System.out.println();
	    	}
        else
            theText.setText("Error in memo interface");
     } 
   
	public static void main ( String [] args)throws IOException {
		Scanner keyboard = new Scanner (System.in);

		BufferedReader list = new BufferedReader ( new FileReader("StudentNames.txt") );
		String numString = list.readLine ();
		int numberOfStudents = Integer.parseInt (numString );
		for ( int i = 1; i <= numberOfStudents; i ++ ) {
			String insertingName = list.readLine ();
			if(insertingName.compareTo(reference) < 0) {
				drTaosList.addStudent( insertingName );
				System.out.println("inserting name " + insertingName + " into Dr. Tao's List");
			} else if(insertingName.compareTo(reference) > 0) {
				drCourtneysList.addStudent( insertingName );
				System.out.println("inserting name " + insertingName + " into Dr. Courtney's List");
			} else {}
		}
		System.out.println();

        Demo guiMemo = new Demo();
        guiMemo.setVisible(true);
	}
}