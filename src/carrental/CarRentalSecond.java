package carrental;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CarRentalSecond extends JFrame{
    
    private JPanel resultPanel, buttonPanel;
    private JButton button1, button2;
    
    public CarRentalSecond(Info info){
        JFrame frame2 = new JFrame("Car Rental System");
        frame2.setLayout(new BoxLayout(frame2.getContentPane(), BoxLayout.Y_AXIS));
        frame2.setSize(325, 200);
        frame2.setResizable(false);
        frame2.setLocationRelativeTo(null);
        frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame2.setVisible(true);
                
        //setup the result panel
        resultPanel = new JPanel();
        resultPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        resultPanel.add(new JLabel(info.toString() +
                                 "<br>Car model: " + info.getCar().getModel() +
                                 "<br>Rental duration: " + info.getCar().getDuration() + " hour(s)" + 
                                 "<br>Fee: RM " + info.getCar().calculateFee()));
        
        frame2.add(resultPanel);
        
        //setup panel for buttons
        buttonPanel = new JPanel();
        button1 = new JButton();
        button1.setText("OK");
        button1.setToolTipText("Press to proceed to payment");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                CarRentalThird third = new CarRentalThird(info);
                frame2.dispose();
            }
        });
        
        button2 = new JButton();
        button2.setText("Cancel");
        button2.setToolTipText("Press to back to previous page");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CarRentalFirst first = new CarRentalFirst();
                frame2.dispose();
            }
        });
        
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        frame2.add(buttonPanel);
    }
}