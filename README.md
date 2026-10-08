# Case Study 174 — Parking Fee Calculator

A Java-based **Parking Fee Calculator** developed as part of the **B.Tech Computer Science Engineering 2025–29, Semester III Java Programming Case Study**.

The application calculates parking charges based on vehicle type and parking duration. It accepts vehicle information, calculates parking duration using entry and exit times, applies vehicle-specific rates and duration-based fee slabs, and generates a detailed parking receipt.

The project contains the required **Scanner-based console implementation** and an additional **Java Swing GUI** as an extra feature.

---

## 📌 Case Study Information

| Category | Details |
|---|---|
| **Case Study No.** | 174 |
| **Case Study Title** | Parking Fee Calculator |
| **Program** | B.Tech Computer Science Engineering |
| **Batch** | 2025–29 |
| **Semester** | III |
| **Subject** | Java Programming |

---

## 📖 Problem Statement

A commercial parking facility requires a system to calculate parking charges based on vehicle type and parking duration.

The system accepts vehicle information, calculates the parking duration, applies vehicle-specific rates and duration-based charges, and generates a parking receipt.

---

## 🎯 Objectives

The main objectives of the project are:

- Accept vehicle information.
- Calculate parking duration using entry and exit times.
- Apply vehicle-specific parking rates.
- Apply different charges based on parking duration.
- Generate parking receipts.
- Demonstrate Java concepts such as `Scanner`, `switch`, operators, conditional statements, and methods.
- Provide an additional graphical user interface using Java Swing.

---

## ✨ Features

### 1. Vehicle Entry

The system accepts the vehicle number from the user.

**Example:** `MH12AB1234`

---

### 2. Vehicle Type Selection

The system supports three vehicle types:

- Bike
- Car
- Truck

---

### 3. Entry and Exit Time

The user enters the parking entry and exit time in `HH:mm` format.

**Example:**

- Entry Time: `10:00`
- Exit Time: `14:00`

---

### 4. Automatic Parking Duration Calculation

The system automatically calculates the parking duration using the entry and exit times.

**Example:**

`10:00 → 14:00`

**Parking Duration: 4 hours**

The system also handles parking that continues after midnight.

**Example:**

`22:00 → 02:00`

**Parking Duration: 4 hours**

---

### 5. Vehicle-Specific Rates

The project uses the following implementation-defined hourly rates:

| Vehicle Type | Rate per Hour |
|---|---:|
| Bike | ₹20 |
| Car | ₹40 |
| Truck | ₹60 |

> **Note:** The original case study does not specify exact vehicle rates. Therefore, these rates have been defined as part of the project implementation.

---

### 6. Duration-Based Fee Slabs

The parking fee is calculated according to the following duration slabs:

| Parking Duration | Fee Calculation |
|---|---|
| Up to 2 hours | Normal hourly rate |
| 3–5 hours | Normal rate + 20% |
| More than 5 hours | Normal rate + 40% |

---

### 7. Parking Fee Calculation

The `calculateFee()` method:

1. Selects the vehicle-specific hourly rate.
2. Calculates the base parking fee.
3. Applies the appropriate duration slab.
4. Returns the final parking fee.

---

### 8. Receipt Generation

The system generates a detailed parking receipt containing:

- Vehicle Number
- Vehicle Type
- Entry Time
- Exit Time
- Parking Hours
- Parking Fee

---

### 9. Input Validation

The application validates:

- Empty vehicle number
- Invalid vehicle selection
- Empty entry time
- Empty exit time
- Invalid time format
- Invalid parking duration

---

### 10. Console Mode

The project includes a Scanner-based console implementation as required by the case study.

The user can enter the vehicle details and parking times through the terminal.

---

### 11. GUI Mode

As an additional feature, the project includes a Java Swing graphical user interface.

The GUI provides:

- Vehicle number input
- Vehicle type dropdown
- Entry time input
- Exit time input
- Calculate Fee button
- Clear button
- Parking receipt display area
- Input validation messages

---

## 🛠️ Technologies Used

- Java
- Java Swing
- Java AWT
- Java Time API
- Scanner
- Switch Statements
- If-Else Statements
- Arithmetic Operators
- Methods
- Exception Handling

---

## 📚 Required Java Implementation

The project implements all the Java concepts specified in the case study.

### Scanner

`Scanner` is used to accept user input in console mode.

Example:

```java
static Scanner scanner = new Scanner(System.in);
```

---

### Switch Statement

A `switch` statement is used to select the vehicle type and assign the corresponding hourly rate.

```java
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
```

A second `switch` statement is used in console mode to select Bike, Car, or Truck based on the user's choice.

---

### Operators

Arithmetic and relational operators are used for calculations and validation.

Examples:

```java
hourlyRate * hours
```

```java
(hourlyRate * hours) + (hourlyRate * hours * 0.20)
```

```java
hours <= 2
```

---

### If-Else Statements

Different parking duration slabs are handled using `if-else` statements.

```java
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
```

---

### Methods

The project uses separate methods for different tasks.

| Method | Purpose |
|---|---|
| `calculateDuration()` | Calculates parking duration from entry and exit times |
| `getParkingHours()` | Converts parking minutes into billable hours |
| `calculateFee()` | Calculates the parking fee |
| `generateReceipt()` | Generates the parking receipt |
| `consoleMode()` | Runs the Scanner-based console implementation |
| `createGUI()` | Creates and displays the Java Swing GUI |

---

## 🧩 Expected Modules

The project implements all five modules specified in the case study.

### 1. Vehicle Entry

Accepts the vehicle number from the user.

### 2. Vehicle Type Selection

Allows the user to select:

- Bike
- Car
- Truck

### 3. Duration Entry

The user enters the entry and exit time in `HH:mm` format.

### 4. Fee Calculation

The program:

1. Calculates the parking duration.
2. Selects the vehicle-specific hourly rate.
3. Applies the appropriate duration slab.
4. Calculates the final parking fee.

### 5. Receipt Generation

The program generates a complete parking receipt containing the vehicle and parking details.

---

## 🔄 System Workflow

The overall workflow of the application is:

**Start → Select Mode → Enter Vehicle Number → Select Vehicle Type → Enter Entry Time → Enter Exit Time → Calculate Duration → Select Vehicle Rate → Apply Duration Slab → Calculate Fee → Generate Receipt → Display Receipt → End**

---

## 💰 Fee Calculation Example

Consider the following example:

**Vehicle Number:** `MH12AB1234`  
**Vehicle Type:** `Car`  
**Entry Time:** `10:00`  
**Exit Time:** `14:00`

### Step 1 — Calculate Parking Duration

`14:00 - 10:00 = 4 hours`

### Step 2 — Select Vehicle Rate

`Car = ₹40 per hour`

### Step 3 — Calculate Base Fee

`₹40 × 4 = ₹160`

### Step 4 — Apply Duration Slab

Since 4 hours falls under the 3–5 hour slab:

`20% of ₹160 = ₹32`

### Step 5 — Calculate Final Fee

`₹160 + ₹32 = ₹192`

**Final Parking Fee: ₹192.00**

---

## 🖥️ Console Execution

### Compile the Program

```bash
javac ParkingFeeCalculator.java
```

### Run the Program

```bash
java ParkingFeeCalculator
```

The program first displays:

```text
========================================
       PARKING FEE CALCULATOR
========================================
1. Console Mode
2. GUI Mode
Enter your choice:
```

Select:

`1`

to run the required Scanner-based console implementation.

---

## 🧾 Sample Console Input

```text
Enter your choice: 1

========================================
       PARKING FEE CALCULATOR
========================================
Enter vehicle number: MH12AB1234

Select Vehicle Type:
1. Bike
2. Car
3. Truck
Enter your choice: 2

Enter entry time (HH:mm): 10:00
Enter exit time (HH:mm): 14:00
```

---

## 🧾 Sample Console Output

```text
========================================
           PARKING RECEIPT
========================================
Vehicle Number : MH12AB1234
Vehicle Type   : Car
Entry Time     : 10:00
Exit Time      : 14:00
Parking Hours  : 4
Parking Fee    : ₹192.00
========================================
             Thank You!
========================================
```

---

## 🖥️ GUI Mode

The project also provides an additional Java Swing GUI.

When the program starts, select:

`2`

for GUI Mode.

The GUI provides input fields for:

- Vehicle Number
- Vehicle Type
- Entry Time
- Exit Time

It also provides:

- Calculate Fee button
- Clear button
- Receipt display area
- Input validation messages

---

## 🧾 GUI Example

### Input

- Vehicle Number: `MH12AB1234`
- Vehicle Type: `Car`
- Entry Time: `10:00`
- Exit Time: `14:00`

### Generated Result

- Parking Duration: `4 hours`
- Parking Fee: `₹192.00`

---

## 📸 Screenshots

Screenshots demonstrating the working of the project are included in the `screenshots` folder.

### Console Execution

<img width="737" height="657" alt="console-output" src="https://github.com/user-attachments/assets/f9ec97dd-5275-4bfa-9e67-6179b1c00935" />


This screenshot demonstrates the successful execution of the Scanner-based console implementation and generation of the parking receipt.

### GUI Input

<img width="548" height="647" alt="gui-input" src="https://github.com/user-attachments/assets/27ae38d2-7ab5-4d5e-9463-fac252e8c42d" />


This screenshot demonstrates the Java Swing interface with vehicle number, vehicle type, entry time, and exit time.

### Parking Receipt

<img width="510" height="542" alt="parking-receipt" src="https://github.com/user-attachments/assets/9384d955-ed6e-40ef-bca1-d0fb643087ac" />
<img width="436" height="177" alt="parking-receipt2" src="https://github.com/user-attachments/assets/ee0dc057-cc96-4cbb-89f1-1bb498b02d3f" />


This screenshot demonstrates the generated parking receipt with the calculated parking duration and final parking fee.

### Input Validation

<img width="927" height="653" alt="gui-validation" src="https://github.com/user-attachments/assets/9658d1bd-2e6b-4f90-9952-0b503a15d375" />


This screenshot demonstrates input validation for invalid or missing information.

> **Note:** Make sure the screenshot files are uploaded inside a folder named `screenshots` in the GitHub repository. If your actual screenshot filenames are different, update the image paths accordingly.

---

## 📁 Project Structure

```text
Parking-Fee-Calculator/
│
├── ParkingFeeCalculator.java
├── README.md
│
└── screenshots/
    ├── console-output.png
    ├── gui-input.png
    ├── parking-receipt.png
    └── gui-validation.png
```

---

## 🧠 Java Concepts Demonstrated

The project demonstrates the following Java concepts:

- Class
- Main Method
- Variables
- Data Types
- String
- int
- double
- long
- Scanner
- Methods
- Parameters
- Arguments
- Return Statement
- Switch Statement
- If Statement
- Else-If Statement
- Else Statement
- Arithmetic Operators
- Relational Operators
- Input Validation
- Exception Handling
- LocalTime
- Duration
- Java Swing
- AWT
- GUI Components
- Event Handling

---

## 🛡️ Input Validation and Exception Handling

The application handles invalid inputs using validation and exception handling.

### Empty Vehicle Number

```text
Vehicle number cannot be empty.
```

### Empty Entry Time

```text
Please enter entry time.
```

### Empty Exit Time

```text
Please enter exit time.
```

### Invalid Time Format

```text
Please enter time in HH:mm format.
Example: 10:00
```

### Invalid Entry or Exit Time

```text
Please enter valid entry and exit times.
```

### Invalid Vehicle Choice

```text
Invalid vehicle choice.
```

---

## 🌙 Overnight Parking

The application supports parking that continues after midnight.

For example:

**Entry Time:** `22:00`  
**Exit Time:** `02:00`

The system calculates the duration across midnight.

**Parking Duration: 4 hours**

This is handled by the `calculateDuration()` method using Java's `LocalTime` and `Duration` classes.

---

## 🎓 Learning Outcomes

This project helped demonstrate and practice:

1. Taking user input using `Scanner`.
2. Creating and calling Java methods.
3. Using `switch` statements for fixed choices.
4. Using arithmetic and relational operators.
5. Using `if-else` statements for duration-based fee slabs.
6. Calculating duration using `LocalTime` and `Duration`.
7. Performing input validation.
8. Handling exceptions using `try-catch`.
9. Generating formatted parking receipts.
10. Creating a graphical user interface using Java Swing.
11. Handling GUI button events.
12. Organizing the program into separate functional methods.

---

## 🚀 How to Run

### Prerequisites

Java must be installed on your system.

Check the Java version:

```bash
java -version
```

Check the Java compiler:

```bash
javac -version
```

### Step 1 — Open the Project Folder

Open the project folder in VS Code or Terminal.

### Step 2 — Compile

```bash
javac ParkingFeeCalculator.java
```

### Step 3 — Run

```bash
java ParkingFeeCalculator
```

### Step 4 — Select the Mode

For the required console implementation:

`1`

For the additional GUI implementation:

`2`

---

## 📋 Deliverables Checklist

| Requirement | Status |
|---|---|
| Vehicle information accepted | ✅ Implemented |
| Parking duration calculated | ✅ Implemented |
| Vehicle-specific rates applied | ✅ Implemented |
| Parking fee calculated | ✅ Implemented |
| Parking receipt generated | ✅ Implemented |
| Scanner implemented | ✅ Implemented |
| Switch statement implemented | ✅ Implemented |
| Operators implemented | ✅ Implemented |
| If-else statements implemented | ✅ Implemented |
| Methods implemented | ✅ Implemented |
| Vehicle Entry module | ✅ Implemented |
| Vehicle Type Selection module | ✅ Implemented |
| Duration Entry module | ✅ Implemented |
| Fee Calculation module | ✅ Implemented |
| Receipt Generation module | ✅ Implemented |
| Input validation | ✅ Implemented |
| Exception handling | ✅ Implemented |
| Automatic duration calculation | ✅ Implemented |
| Java Swing GUI | ✅ Extra Feature |

---

## 📌 Case Study Requirement Mapping

| Case Study Requirement | Implementation |
|---|---|
| Accept vehicle information | Vehicle number input |
| Calculate parking duration | `calculateDuration()` |
| Apply vehicle-specific rates | `switch` in `calculateFee()` |
| Generate parking receipts | `generateReceipt()` |
| Scanner | `consoleMode()` |
| Switch | Vehicle type and rate selection |
| Operators | Fee calculations and comparisons |
| If-Else | Duration-based fee slabs |
| Methods | Dedicated methods for major tasks |
| Vehicle Entry | Vehicle number |
| Vehicle Type Selection | Bike, Car, Truck |
| Duration Entry | Entry and exit time |
| Fee Calculation | `calculateFee()` |
| Receipt Generation | `generateReceipt()` |
| GUI | Java Swing — Extra Feature |

---

## 🔮 Future Enhancements

Possible future improvements include:

- Database connectivity using JDBC.
- Storage of parking records.
- Multiple vehicle entries.
- Parking slot allocation.
- Search and update parking records.
- Automatic receipt numbering.
- Daily and monthly revenue reports.
- Digital receipt export.
- Improved GUI design.
- Payment integration.

---

## 👩‍💻 Author

**Rashmeet Kaur**

B.Tech Computer Science Engineering  
ITM Skills University  
Batch: 2025–29  
Semester III

---

## 📄 Academic Context

This project was developed as part of:

**B.Tech CSE 2025–29 Java Programming Case Study / Problem Statement**

**Case Study 174 — Parking Fee Calculator**

**Semester III**

---

## ⭐ Conclusion

The **Parking Fee Calculator** provides a structured solution for calculating parking charges based on vehicle type and parking duration.

The project implements all the major requirements specified in the case study, including **Scanner, switch statements, operators, if-else statements, methods, automatic parking duration calculation, vehicle-specific rates, duration-based fee slabs, input validation, exception handling, and receipt generation**.

An additional **Java Swing GUI** has also been implemented to provide a user-friendly graphical interface while retaining the required Scanner-based console implementation.

---

**Case Study 174 | Parking Fee Calculator | Java Programming | B.Tech CSE 2025–29 | Semester III**
