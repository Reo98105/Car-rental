package carrental;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class CarRentalFourth extends JFrame {
    
    private JPanel finalPanel, buttonPanel;
    private JButton button1, button2;
    
    public CarRentalFourth(Info info, Payment pay){
        
        JFrame frame4 = new JFrame("Car Rental System");
        frame4.setLayout(new BoxLayout(frame4.getContentPane(), BoxLayout.Y_AXIS));
        frame4.setSize(300, 225);
        frame4.setResizable(false);
        frame4.setLocationRelativeTo(null);
        frame4.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame4.setVisible(true);
        
        //set up receipt panel
        finalPanel = new JPanel();
        finalPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        finalPanel.add(new JLabel(info.toString() +
                                 "<br>Car model: " + info.getCar().getModel() +
                                 "<br>Rental duration: " + info.getCar().getDuration() + " hour(s)" + 
                                 "<br>Fee: RM " + info.getCar().calculateFee() + 
                                  pay.toString()));
        
        frame4.add(finalPanel);
        
        //set up button panel
        buttonPanel = new JPanel();
        button1 = new JButton();
        button1.setText("OK");
        button1.setToolTipText("Press to save the receipt and back to input new order");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                    File file = new File("C:\\Users\\Type-002 Fumitsuki\\Desktop\\" + "Customer1" + ".txt");
                    int increase = 1;
                    while(file.exists()){
                        increase ++;
                        file = new File("C:\\Users\\Type-002 Fumitsuki\\Desktop\\" + "Customer" + increase + ".txt");
                    }
                    if(!file.exists()){
                        try{
                            file.createNewFile();
                            
                            PrintWriter pw = new PrintWriter(file, "UTF-8");
                            pw.printf(info.toString());
                            pw.println("Car model: " + info.getCar().getModel());
                            pw.println("Rental duration: " + info.getCar().getDuration() + "hour(s)");
                            pw.println("Fee: RM" + info.getCar().calculateFee());
                            pw.println("Payment amount: RM" + pay.getPay());
                            pw.println("Return: RM " + pay.returnFee());
                            pw.close();
                            //verify using console output
                            System.out.println("done writing");
                        }
                        catch(IOException ioE){
                            JOptionPane.showMessageDialog(null, ioE, "Cannot create new receipt!", JOptionPane.ERROR_MESSAGE);
                        }
                    }               
                CarRentalFirst first = new CarRentalFirst();
                frame4.dispose();
            }
        });
        
        button2 = new JButton();
        button2.setText("Cancel");
        button2.setToolTipText("Press to logout");
        button2.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
                int onClick = JOptionPane.showConfirmDialog(null, "Do you want to logout and exit program?", 
                                                            "Car Rental System", JOptionPane.YES_NO_OPTION);                
                if(onClick == 0){
                    frame4.dispose();
                    JOptionPane.showMessageDialog(null, "Logout successfull!", "Car Rental System", 
                                                  JOptionPane.INFORMATION_MESSAGE);
                }
                else{                    
                }
            }
        });        
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        frame4.add(buttonPanel);
    }    
}