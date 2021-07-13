package carrental;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CarRentalFirst extends JFrame{
    
    private JTextField textField1, textField2, textField3, textField4;
    private JPanel namePanel, icPanel, datePanel, carPanel, timePanel, lastPanel;
    private JButton button1, button2;
    
    public CarRentalFirst(){
        JFrame frame1 = new JFrame("Car Rental System");
        frame1.setLayout(new BoxLayout(frame1.getContentPane(), BoxLayout.Y_AXIS));
        frame1.setSize(350, 300);
        frame1.setResizable(false);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame1.setVisible(true);
        
        //set up all the textfield
        namePanel = new JPanel();
        namePanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        namePanel.add(new JLabel("Name:                  "));        
        textField1 = new JTextField(10);
        
        namePanel.add(textField1);
        frame1.add(namePanel);
        
        icPanel = new JPanel();
        icPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        icPanel.add(new JLabel("IC:                         "));
        textField2 = new JTextField(10);
        
        icPanel.add(textField2);
        frame1.add(icPanel);
        
        datePanel = new JPanel();
        datePanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        datePanel.add(new JLabel("Date:                    "));
        textField3 = new JTextField(10);
        textField3.setToolTipText("Date format in DD/MM/YYYY");
        
        datePanel.add(textField3);
        frame1.add(datePanel);
        
        timePanel = new JPanel();
        timePanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        timePanel.add(new JLabel("Rental duration:"));
        textField4 = new JTextField(10);
        textField4.setToolTipText("Duration in Hour");
        
        timePanel.add(textField4);
        frame1.add(timePanel);
        
        //setting up the droplist for choosing
        carPanel = new JPanel();
        carPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        carPanel.add(new JLabel("Car model:"));
        Object[] car = {"Perodua Myvi", "Perodua Axia", "Perodua Viva",
                        new JSeparator(JSeparator.HORIZONTAL),
                        "Nissan Livina", "Proton Exora", "Perodua Alza"};
        
        JComboBox<Object> comboBox = new JComboBox<>(car);
        comboBox.setSelectedIndex(1);                       //set how many user can select
        ComboBoxRenderer renderer = new ComboBoxRenderer();
        renderer.setPreferredSize(new Dimension(100,25));   //size of the box
        comboBox.setRenderer(renderer);
        
        carPanel.add(comboBox);
        frame1.add(carPanel);
        
        //setup button for either exit or anything else
        lastPanel = new JPanel();
        button1 = new JButton();
        button1.setText("OK");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {                 
                String name = textField1.getText();
                String ic = textField2.getText();
                
                String day = textField3.getText().substring(0,2);
                String month = textField3.getText().substring(3,5);
                String year = textField3.getText().substring(6);
                
                int d = Integer.parseInt(day);
                int m = Integer.parseInt(month);
                int y = Integer.parseInt(year);
                
                String currentCar;
                int duration = Integer.parseInt(textField4.getText());
                                 
                Date date = new Date(d, m, y);
                Info info = new Info();
                
                if(comboBox.getSelectedItem() == "Perodua Myvi" ||
                   comboBox.getSelectedItem() == "Perodua Axia" ||
                   comboBox.getSelectedItem() == "Perodua Viva"){
                    currentCar = String.valueOf(comboBox.getSelectedItem());
                    
                    Normal norm = new Normal(currentCar, duration);
                    info = new Info(name, ic, date, norm);
                    CarRentalSecond second = new CarRentalSecond(info);
                }
                else{
                    currentCar = String.valueOf(comboBox.getSelectedItem());
                    
                    MPV mpv = new MPV(currentCar, duration);
                    info = new Info(name, ic, date, mpv);
                    CarRentalSecond second = new CarRentalSecond(info);
                }                                
                frame1.dispose();
            }
        });
        
        button2 = new JButton();
        button2.setText("Cancel");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int onClick = JOptionPane.showConfirmDialog(null, "Do you want to logout and exit program?", 
                                                            "Car Rental System", JOptionPane.YES_NO_OPTION);                
                if(onClick == 0){
                    frame1.dispose();
                    JOptionPane.showMessageDialog(null, "Logout successfull!", "Car Rental System", 
                                                  JOptionPane.INFORMATION_MESSAGE);
                }
                else{                    
                }
            }
        });
        
        lastPanel.add(button1);
        lastPanel.add(button2);
        frame1.add(lastPanel);
    }
    
    //class for comboBox
    class ComboBoxRenderer extends JLabel implements ListCellRenderer<Object> {
        public Component getListCellRendererComponent(JList<? extends Object> list,
        Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if(value instanceof JSeparator){
                return (Component)value;
            }
            else{
                setText(value.toString());
            }
            return this;
        }
    }
}