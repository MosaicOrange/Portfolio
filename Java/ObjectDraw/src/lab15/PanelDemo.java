package lab15;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;

/***************************************************************
 *Simple demonstration of putting buttons in a panel. If you do
 *not see the colored part of the window with text in it, use your
 *mouse to increase the size of the window and it will appear.
 ***************************************************************/
public class PanelDemo extends JFrame implements ActionListener
{
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    public static void main(String[] args)
    {
        PanelDemo guiWithPanel = new PanelDemo();
        guiWithPanel.setVisible(true);
    }

    public PanelDemo()
    {
        setSize(WIDTH, HEIGHT);
        addWindowListener(new WindowDestroyer());
        setTitle("Panel Demonstration");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.white);

        Container contentPane = getContentPane ();                
        contentPane.setBackground(Color.blue); 
        contentPane.setLayout (new BorderLayout () );
        
        
        buttonPanel.setLayout(new FlowLayout());

        JButton stopButton = new JButton("Red");
        stopButton.setBackground(Color.red); 
        stopButton.addActionListener(this);
        buttonPanel.add(stopButton);

        JButton goButton = new JButton("Green");
        goButton.setBackground(Color.green);
        goButton.addActionListener(this); 
        buttonPanel.add(goButton);        

        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
    }
 
       
    public void actionPerformed(ActionEvent e) 
    {
    	 Container contentPane = getContentPane (); 
       if (e.getActionCommand().equals("Red"))
        {
            contentPane.setBackground(Color.red);
        }
        else if (e.getActionCommand().equals("Green"))
        {
           contentPane.setBackground(Color.green);
        }
        else
           System.out.println ( "Error in button interface.");

     }
    
}