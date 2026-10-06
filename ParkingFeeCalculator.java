import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class ParkingFeeCalculator {

   
    static Scanner scanner = new Scanner(System.in);

   
    public static double calculateFee(String vehicleType, int hours) {

        double hourlyRate = 0;
        double fee;

       
        switch (vehicleType) {

            case "Bike":
                hourlyRate = 20;
                break;

            case "Car":
                hourlyRate = 40;
                break;

            case "Truck":
                hourlyRate = 60;
                break;

            default:
                System.out.println("Invalid vehicle type.");
                return 0;
        }

      
        if (hours <= 2) {
            fee = hourlyRate * hours;
        }
        else if (hours <= 5) {
            fee = (hourlyRate * hours)
                    + (hourlyRate * hours * 0.20);
        }
        else {
            fee = (hourlyRate * hours)
                    + (hourlyRate * hours * 0.40);
        }

        return fee;
    }


    
    public static String generateReceipt(
            String vehicleNumber,
            String vehicleType,
            int hours,
            double fee) {

        String receipt = "";

        receipt += "================================\n";
        receipt += "        PARKING RECEIPT\n";
        receipt += "================================\n";
        receipt += "Vehicle Number : " + vehicleNumber + "\n";
        receipt += "Vehicle Type   : " + vehicleType + "\n";
        receipt += "Parking Hours  : " + hours + "\n";
        receipt += "Parking Fee    : ₹" + fee + "\n";
        receipt += "================================\n";
        receipt += "          Thank You!\n";
        receipt += "================================";

        return receipt;
    }


    
    public static void createGUI() {

      
        JFrame frame = new JFrame("Parking Fee Calculator");

        frame.setSize(500, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);


       
        JLabel title = new JLabel("PARKING FEE CALCULATOR");

        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(105, 20, 350, 40);

        frame.add(title);


        JLabel vehicleLabel =
                new JLabel("Vehicle Number:");

        vehicleLabel.setBounds(50, 90, 130, 30);

        frame.add(vehicleLabel);


        JTextField vehicleField =
                new JTextField();

        vehicleField.setBounds(190, 90, 220, 30);

        frame.add(vehicleField);


       
        JLabel typeLabel =
                new JLabel("Vehicle Type:");

        typeLabel.setBounds(50, 140, 130, 30);

        frame.add(typeLabel);


        String[] vehicleTypes =
                {"Bike", "Car", "Truck"};

        JComboBox<String> vehicleBox =
                new JComboBox<>(vehicleTypes);

        vehicleBox.setBounds(190, 140, 220, 30);

        frame.add(vehicleBox);


        
        JLabel durationLabel =
                new JLabel("Parking Hours:");

        durationLabel.setBounds(50, 190, 130, 30);

        frame.add(durationLabel);


        JTextField durationField =
                new JTextField();

        durationField.setBounds(190, 190, 220, 30);

        frame.add(durationField);


      
        JButton calculateButton =
                new JButton("Calculate Fee");

        calculateButton.setBounds(150, 240, 190, 40);

        frame.add(calculateButton);


        
        JTextArea receiptArea =
                new JTextArea();

        receiptArea.setEditable(false);

        receiptArea.setFont(
                new Font("Monospaced", Font.PLAIN, 14)
        );


        JScrollPane scrollPane =
                new JScrollPane(receiptArea);

        scrollPane.setBounds(50, 300, 400, 160);

        frame.add(scrollPane);


       
        calculateButton.addActionListener(e -> {

            try {

               
                String vehicleNumber =
                        vehicleField.getText().trim();


                
                String vehicleType =
                        (String) vehicleBox.getSelectedItem();


                
                String durationText =
                        durationField.getText().trim();


                
                if (vehicleNumber.isEmpty()) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Please enter vehicle number."
                    );

                    return;
                }


              
                if (durationText.isEmpty()) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Please enter parking duration."
                    );

                    return;
                }


                int hours =
                        Integer.parseInt(durationText);


               
                if (hours <= 0) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Parking duration must be greater than 0."
                    );

                    return;
                }


               
                double parkingFee =
                        calculateFee(
                                vehicleType,
                                hours
                        );


                
                String receipt =
                        generateReceipt(
                                vehicleNumber,
                                vehicleType,
                                hours,
                                parkingFee
                        );


                receiptArea.setText(receipt);

            }
            catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please enter a valid number of hours."
                );
            }
        });


       
        JButton clearButton =
                new JButton("Clear");

        clearButton.setBounds(150, 480, 190, 35);

        frame.add(clearButton);


       
        clearButton.addActionListener(e -> {

            vehicleField.setText("");
            durationField.setText("");
            vehicleBox.setSelectedIndex(0);
            receiptArea.setText("");

        });


        
        frame.setVisible(true);
    }


    
    public static void main(String[] args) {

        createGUI();

    }
}