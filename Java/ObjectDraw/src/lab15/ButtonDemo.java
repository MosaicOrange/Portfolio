package lab15;
import javax.swing.*; 
import java.awt.event.*;
import java.awt.*;

public class ButtonDemo extends JFrame implements ActionListener
{
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    
    public static void main(String[] args)
    {
        ButtonDemo buttonGui = new ButtonDemo();
        buttonGui.setVisible(true);
    }


    public ButtonDemo()
    {
        setSize(WIDTH, HEIGHT);

        addWindowListener(new WindowDestroyer()); 
        setTitle("Button Demonstration");
        
        Container contentPane = getContentPane ();
        contentPane.setBackground(Color.blue);
        
        contentPane.setLayout(new FlowLayout());

        JButton stopButton = new JButton("Stop"); 
        stopButton.addActionListener(this);
        contentPane.add(stopButton);

        JButton goButton = new JButton("Go");
        goButton.addActionListener(this); 
        contentPane.add(goButton);
        
        JButton caution = new JButton("Caution");
        caution.addActionListener(this); 
        contentPane.add(caution);
    }
   
  public void actionPerformed(ActionEvent e) 
    {
    	  Container contentPane = getContentPane ();
        if (e.getActionCommand().equals("Stop"))
        {
            contentPane.setBackground(Color.red);
        }
        else if (e.getActionCommand().equals("Go"))
        {
           contentPane.setBackground(Color.green);
                   }
        else if (e.getActionCommand().equals("Caution"))
        {
           contentPane.setBackground(Color.yellow);
                   }
        else
           System.out.println ( "Error in button interface." );
        }
 
 
  }