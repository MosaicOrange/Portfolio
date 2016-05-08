package lab15;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;

/**************************************
 *GUI for totaling a series of numbers.
 **************************************/
public class AdderTwoTryAsAnApplet extends JApplet implements ActionListener
{
    public static final int WIDTH = 400;
    public static final int HEIGHT = 200;

    private JTextField inputField, outputField; 
    private double sum = 0;

    

    public void init( )
    {
        //setTitle("Adding Machine");
        //addWindowListener(new WindowDestroyer());
        //setSize(WIDTH, HEIGHT);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.gray);
        buttonPanel.setLayout(new FlowLayout()); 
        JButton addButton = new JButton("Add"); 
        addButton.addActionListener(this);
        buttonPanel.add(addButton); 
        JButton resetButton = new JButton("Reset"); 
        resetButton.addActionListener(this);
        buttonPanel.add(resetButton);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        JPanel textPanel = new JPanel(); 
        textPanel.setBackground(Color.pink); 
        textPanel.setLayout(new GridLayout(3,3)); 

        inputField = new JTextField( 15);
        inputField.setBackground(Color.white);
        textPanel.add(inputField);
        
        JLabel enterLabel = new JLabel ( "Click, and enter numbers to the left" );
        textPanel.add (enterLabel);        
        outputField = new JTextField(  );
        
        outputField.setBackground (Color.white );
        textPanel.add(outputField);
        JLabel  sumLabel = new JLabel ( "The sum is on the left" );
        textPanel.add(sumLabel);
        
        contentPane.add(textPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Add"))
        {
            sum = sum +
                stringToDouble(inputField.getText());
            outputField.setText(Double.toString(sum));
        }
        else if (e.getActionCommand().equals("Reset"))
        {
            sum = 0;
            outputField.setText("0.0");
        }
        else 
            outputField.setText("Error in adder code.");
     }
   
    private static double stringToDouble(String stringObject)
    {
        return Double.parseDouble(stringObject.trim());
    }
}