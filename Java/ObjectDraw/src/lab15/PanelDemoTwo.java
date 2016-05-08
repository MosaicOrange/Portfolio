package lab15;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;

/*Simple demonstration of placing several panels 	within the content pane.  */
 	
 	
public class PanelDemoTwo extends JFrame implements ActionListener
{
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;
    private JPanel firstPanel,secondPanel, thirdPanel;

    public static void main(String[] args)
    {
        PanelDemoTwo guiWithPanel = new PanelDemoTwo();
        guiWithPanel.setVisible(true);
    }

    public PanelDemoTwo()
    {
        setSize(WIDTH, HEIGHT);
        addWindowListener(new WindowDestroyer());
        setTitle("Panel Demonstration");
        

        Container contentPane = getContentPane ();                
 
        contentPane.setLayout (new GridLayout () );
        
        firstPanel = new JPanel ();
        firstPanel.setBackground (Color.white);

        secondPanel = new JPanel ();
        secondPanel.setBackground ( Color.gray);

        thirdPanel = new JPanel ();
        thirdPanel.setBackground ( Color.black);

        JButton stopButton = new JButton("Red");
        stopButton.setBackground(Color.red); 
        stopButton.addActionListener(this);
        firstPanel.add(stopButton);

        JButton goButton = new JButton("Green");
        goButton.setBackground(Color.green);
        goButton.addActionListener(this); 
        secondPanel.add(goButton); 

        JButton caution = new JButton("Caution");
        caution.setBackground(Color.yellow);
        caution.addActionListener(this); 
        thirdPanel.add(caution); 
        
        
        contentPane.add(firstPanel);
        contentPane.add(secondPanel);
        contentPane.add(thirdPanel);
        
        
    }
 
       
    public void actionPerformed(ActionEvent e) 
    {
    	
       if (e.getActionCommand().equals("Red"))
        {
        	 if (firstPanel.getBackground() .equals (Color.white ))
              firstPanel.setBackground(Color.red);
           else
           	  firstPanel.setBackground (Color.white );
        }
       else if (e.getActionCommand().equals("Green"))
       {
       	 if ( secondPanel.getBackground ().equals (Color.gray) )
             secondPanel.setBackground(Color.green);
          else
       	    secondPanel.setBackground ( Color.gray);      
       }

       else if (e.getActionCommand().equals("Caution"))
       {
       	 if ( thirdPanel.getBackground ().equals (Color.black) )
             thirdPanel.setBackground(Color.yellow);
          else
       	    thirdPanel.setBackground ( Color.black);      
       }
        else
           System.out.println ( "Error in button interface.");

     }
    
}