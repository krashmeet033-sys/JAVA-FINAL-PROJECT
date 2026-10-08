import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ParkingFeeCalculator {

    // Scanner for console input
    static Scanner scanner = new Scanner(System.in);

    // Time format used for entry and exit time
    static DateTimeFormatter timeFormatter =
            DateTimeFormatter.ofPattern("HH:mm");


    // =========================================================
    // METHOD 1: Calculate Parking Duration
    // =========================================================
    public static long calculateDuration(String entryTime, String exitTime) {

        try {

            LocalTime entry =
                    LocalTime.parse(entryTime, timeFormatter);

            LocalTime exit =
                    LocalTime.parse(exitTime, timeFormatter);

            long minutes =
                    Duration.between(entry, exit).toMinutes();

            // Handles parking after midnight
            if (minutes < 0) {
                minutes += 24 * 60;
            }

            return minutes;

        }
        catch (DateTimeParseException e) {

            return -1;
        }
    }


    // =========================================================
    // METHOD 2: Convert Minutes into Parking Hours
    // =========================================================
    public static int getParkingHours(long minutes) {

        // If parking is not a complete hour,
        // count it as the next hour.
        return (int) Math.ceil(minutes / 60.0);
    }


    // =========================================================
    // METHOD 3: Calculate Parking Fee
    // =========================================================
    public static double calculateFee(
            String vehicleType,
            int hours) {

        double hourlyRate = 0;
        double fee;

        // Switch for vehicle-specific rates
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


        // If-else for duration slabs
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


    // =========================================================
    // METHOD 4: Generate Parking Receipt
    // =========================================================
    public static String generateReceipt(
            String vehicleNumber,
            String vehicleType,
            String entryTime,
            String exitTime,
            int hours,
            double fee) {

        String receipt = "";

        receipt += "========================================\n";
        receipt += "           PARKING RECEIPT\n";
        receipt += "========================================\n";
        receipt += "Vehicle Number : " + vehicleNumber + "\n";
        receipt += "Vehicle Type   : " + vehicleType + "\n";
        receipt += "Entry Time     : " + entryTime + "\n";
        receipt += "Exit Time      : " + exitTime + "\n";
        receipt += "Parking Hours  : " + hours + "\n";
        receipt += "Parking Fee    : ₹" + String.format("%.2f", fee) + "\n";
        receipt += "========================================\n";
        receipt += "             Thank You!\n";
        receipt += "========================================";

        return receipt;
    }


    // =========================================================
    // METHOD 5: Console Mode Using Scanner
    // =========================================================
    public static void consoleMode() {

        System.out.println("\n========================================");
        System.out.println("       PARKING FEE CALCULATOR");
        System.out.println("========================================");


        // Vehicle Entry
        System.out.print("Enter vehicle number: ");
        String vehicleNumber = scanner.nextLine().trim();


        if (vehicleNumber.isEmpty()) {

            System.out.println("Vehicle number cannot be empty.");
            return;
        }


        // Vehicle Type Selection
        System.out.println("\nSelect Vehicle Type:");
        System.out.println("1. Bike");
        System.out.println("2. Car");
        System.out.println("3. Truck");

        System.out.print("Enter your choice: ");

        int choice;

        try {

            choice = Integer.parseInt(scanner.nextLine());

        }
        catch (NumberFormatException e) {

            System.out.println("Invalid vehicle choice.");
            return;
        }


        String vehicleType;

        switch (choice) {

            case 1:
                vehicleType = "Bike";
                break;

            case 2:
                vehicleType = "Car";
                break;

            case 3:
                vehicleType = "Truck";
                break;

            default:
                System.out.println("Invalid vehicle choice.");
                return;
        }


        // Entry Time
        System.out.print(
                "Enter entry time (HH:mm): "
        );

        String entryTime =
                scanner.nextLine().trim();


        // Exit Time
        System.out.print(
                "Enter exit time (HH:mm): "
        );

        String exitTime =
                scanner.nextLine().trim();


        // Calculate duration
        long durationMinutes =
                calculateDuration(
                        entryTime,
                        exitTime
                );


        if (durationMinutes <= 0) {

            System.out.println(
                    "Invalid entry or exit time."
            );

            return;
        }


        // Convert duration into hours
        int hours =
                getParkingHours(durationMinutes);


        // Calculate fee
        double parkingFee =
                calculateFee(
                        vehicleType,
                        hours
                );


        // Generate receipt
        String receipt =
                generateReceipt(
                        vehicleNumber,
                        vehicleType,
                        entryTime,
                        exitTime,
                        hours,
                        parkingFee
                );


        System.out.println("\n" + receipt);
    }


    // =========================================================
    // METHOD 6: GUI
    // =========================================================
    public static void createGUI() {

        JFrame frame =
                new JFrame("Parking Fee Calculator");

        frame.setSize(550, 650);

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        frame.setLayout(null);


        // Title
        JLabel title =
                new JLabel("PARKING FEE CALCULATOR");

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        title.setBounds(
                120,
                20,
                350,
                40
        );

        frame.add(title);


        // Vehicle Number
        JLabel vehicleLabel =
                new JLabel("Vehicle Number:");

        vehicleLabel.setBounds(
                50,
                90,
                130,
                30
        );

        frame.add(vehicleLabel);


        JTextField vehicleField =
                new JTextField();

        vehicleField.setBounds(
                200,
                90,
                240,
                30
        );

        frame.add(vehicleField);


        // Vehicle Type
        JLabel typeLabel =
                new JLabel("Vehicle Type:");

        typeLabel.setBounds(
                50,
                140,
                130,
                30
        );

        frame.add(typeLabel);


        String[] vehicleTypes =
                {
                        "Bike",
                        "Car",
                        "Truck"
                };


        JComboBox<String> vehicleBox =
                new JComboBox<>(
                        vehicleTypes
                );

        vehicleBox.setBounds(
                200,
                140,
                240,
                30
        );

        frame.add(vehicleBox);


        // Entry Time
        JLabel entryLabel =
                new JLabel("Entry Time (HH:mm):");

        entryLabel.setBounds(
                50,
                190,
                150,
                30
        );

        frame.add(entryLabel);


        JTextField entryField =
                new JTextField();

        entryField.setBounds(
                200,
                190,
                240,
                30
        );

        frame.add(entryField);


        // Exit Time
        JLabel exitLabel =
                new JLabel("Exit Time (HH:mm):");

        exitLabel.setBounds(
                50,
                240,
                150,
                30
        );

        frame.add(exitLabel);


        JTextField exitField =
                new JTextField();

        exitField.setBounds(
                200,
                240,
                240,
                30
        );

        frame.add(exitField);


        // Calculate Button
        JButton calculateButton =
                new JButton("Calculate Fee");

        calculateButton.setBounds(
                170,
                290,
                200,
                40
        );

        frame.add(calculateButton);


        // Receipt Area
        JTextArea receiptArea =
                new JTextArea();

        receiptArea.setEditable(false);

        receiptArea.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        14
                )
        );


        JScrollPane scrollPane =
                new JScrollPane(receiptArea);

        scrollPane.setBounds(
                50,
                350,
                440,
                180
        );

        frame.add(scrollPane);


        // Calculate Button Action
        calculateButton.addActionListener(e -> {

            try {

                // Vehicle number
                String vehicleNumber =
                        vehicleField
                                .getText()
                                .trim();


                // Vehicle type
                String vehicleType =
                        (String)
                        vehicleBox
                                .getSelectedItem();


                // Entry time
                String entryTime =
                        entryField
                                .getText()
                                .trim();


                // Exit time
                String exitTime =
                        exitField
                                .getText()
                                .trim();


                // Validate vehicle number
                if (vehicleNumber.isEmpty()) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Please enter vehicle number."
                    );

                    return;
                }


                // Validate entry time
                if (entryTime.isEmpty()) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Please enter entry time."
                    );

                    return;
                }


                // Validate exit time
                if (exitTime.isEmpty()) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Please enter exit time."
                    );

                    return;
                }


                // Calculate duration
                long durationMinutes =
                        calculateDuration(
                                entryTime,
                                exitTime
                        );


                // Validate duration
                if (durationMinutes <= 0) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Please enter valid entry and exit times."
                    );

                    return;
                }


                // Convert minutes to hours
                int hours =
                        getParkingHours(
                                durationMinutes
                        );


                // Calculate fee
                double parkingFee =
                        calculateFee(
                                vehicleType,
                                hours
                        );


                // Generate receipt
                String receipt =
                        generateReceipt(
                                vehicleNumber,
                                vehicleType,
                                entryTime,
                                exitTime,
                                hours,
                                parkingFee
                        );


                // Display receipt
                receiptArea.setText(receipt);

            }
            catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please enter time in HH:mm format.\nExample: 10:00"
                );
            }
        });


        // Clear Button
        JButton clearButton =
                new JButton("Clear");

        clearButton.setBounds(
                170,
                550,
                200,
                35
        );

        frame.add(clearButton);


        // Clear Button Action
        clearButton.addActionListener(e -> {

            vehicleField.setText("");

            vehicleBox.setSelectedIndex(0);

            entryField.setText("");

            exitField.setText("");

            receiptArea.setText("");
        });


        // Display GUI
        frame.setVisible(true);
    }


    // =========================================================
    // MAIN METHOD
    // =========================================================
    public static void main(String[] args) {

        System.out.println(
                "========================================"
        );

        System.out.println(
                "       PARKING FEE CALCULATOR"
        );

        System.out.println(
                "========================================"
        );

        System.out.println(
                "1. Console Mode"
        );

        System.out.println(
                "2. GUI Mode"
        );

        System.out.print(
                "Enter your choice: "
        );


        String mode =
                scanner.nextLine();


        if (mode.equals("1")) {

            // Required Scanner implementation
            consoleMode();

        }
        else if (mode.equals("2")) {

            // Extra GUI feature
            createGUI();

        }
        else {

            System.out.println(
                    "Invalid choice."
            );
        }
    }
}
