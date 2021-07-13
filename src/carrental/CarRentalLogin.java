package carrental;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

public class CarRentalLogin extends JFrame{
    
    private JPanel userPanel, passwordPanel, logPanel;
    private JTextField userName;
    private JPasswordField passWord;
    private JButton logButton;
    
    public CarRentalLogin(){
        JFrame frame = new JFrame("Car Rental System");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));        
        frame.setSize(325, 150);                     //fixed the size of the program
        setResizable(false);                         //no rezise available        
        frame.setLocationRelativeTo(null);           //setting up the startup location
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //setting up input panel for user to input username
        userPanel = new JPanel();
        userPanel.add(new JLabel ("Username:"));
        userName = new JTextField(10);
        
        userPanel.add(userName);
        frame.add(userPanel);
        
        //set up the password panel for user
        passwordPanel = new JPanel();
        passwordPanel.add(new JLabel("Password:"));
        passWord = new JPasswordField(10);
        
        passwordPanel.add(passWord);
        frame.add(passwordPanel);
        
        //set up 'ok' button
        logPanel = new JPanel();
        logButton = new JButton();
        logButton.setText("Login");
        logButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                char[] pass = passWord.getPassword();   //to get the password
                char[] correctPass = new char[] {'a', 'd', 'm', 'i', 'n'};                
                try{
                    if(!userName.getText().equals("admin")){
                        throw new CustomException();
                    }
                    else if(!Arrays.equals(pass, correctPass)){
                        throw new CustomException2();
                    }
                    else{
                        CarRentalFirst first = new CarRentalFirst();                        
                    }                    
                }
                catch(CustomException iU){
                    JOptionPane.showMessageDialog(null, iU, "Invalid user", JOptionPane.ERROR_MESSAGE);
                }
                catch(CustomException2 iP){
                    JOptionPane.showMessageDialog(null, iP, "Invalid password", JOptionPane.ERROR_MESSAGE);
                }
                userName.setText("");
                passWord.setText("");
                frame.dispose();        
            }
        });
        logPanel.add(logButton);     
        frame.add(logPanel);
        frame.setVisible(true);
    }  
}