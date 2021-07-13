package carrental;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CarRentalThird extends JFrame {
    
    private JTextField paymentField;
    private JPanel receiptPanel, paymentPanel, buttonPanel;
    private JButton button1, button2;
    
    public CarRentalThird(Info info){
        JFrame frame3 = new JFrame("Car Rental System");
        frame3.setLayout(new BoxLayout(frame3.getContentPane(), BoxLayout.Y_AXIS));
        frame3.setSize(300, 250);
        frame3.setResizable(false);
        frame3.setLocationRelativeTo(null);
        frame3.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame3.setVisible(true);
        
        //setup the panel to show receipt
        receiptPanel = new JPanel();
        receiptPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        receiptPanel.add(new JLabel(info.toString() +
                                 "<br>Car model: " + info.getCar().getModel() +
                                 "<br>Rental duration: " + info.getCar().getDuration() + " hour(s)" + 
                                 "<br>Fee: RM " + info.getCar().calculateFee()));
        
        frame3.add(receiptPanel);
        
        //setup the panel to get payment
        paymentPanel = new JPanel();
        paymentPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        paymentPanel.add(new JLabel("Payment amount: "));
        paymentField = new JTextField(10);
        
        paymentPanel.add(paymentField);
        frame3.add(paymentPanel);
        
        //setup panel for buttons
        buttonPanel = new JPanel();
        button1 = new JButton();
        button1.setText("OK");
        button1.setToolTipText("Press to calculate and generate a receipt");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                double payAmount = Double.parseDouble(paymentField.getText());
                
                Payment pay = new Payment(info, payAmount);
                
                CarRentalFourth fourth = new CarRentalFourth(info, pay);
                frame3.dispose();
            }
        });
        
        button2 = new JButton();
        button2.setText("Cancel");
        button2.setToolTipText("Press to input new order");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CarRentalFirst first = new CarRentalFirst();
                frame3.dispose();
            }
        });
        
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        frame3.add(buttonPanel);
    }
}