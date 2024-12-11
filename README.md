# Waste Management System
Final Project | Cristian Javier | Object Oriented Programming | IT-2102 

## Overview
The **Waste Management System** is a Java-based console application designed to streamline the categorization, management, and collection of waste. It enables users to add waste details, view waste statuses, and calculate disposal costs based on the type of waste. The system supports role-based access with distinct functionalities for admins and regular users.

## Features
- **Role-Based Access**: Admins can view and update waste collection statuses, while users can add waste details.
- **Waste Categorization**: Supports three waste types:
  - Organic
  - Recyclable
  - Hazardous
- **Dynamic Disposal Cost Calculation**: Costs are calculated based on the waste type and weight.
- **Location Tracking**: Keeps track of the pickup location for each waste item.
- **Collection Scheduling**: Displays a predefined collection schedule.
- **User-Friendly Interface**: Provides simple menus for easy navigation.

## Instructions
### Running the Program
1. Ensure you have **Java Development Kit (JDK)** installed on your system.
2. Compile the program using the following command:
   ```bash
   javac wastemanagementsystem.java
   ```
3. Run the program using:
   ```bash
   java wastemanagementsystem
   ```

### Usage
- **Authentication**:
  - Admins must enter the password `admin` to access admin features.
  - Users can directly access user features without a password.
- **Admin Features**:
  - View waste details.
  - Declare waste items as collected.
- **User Features**:
  - Add new waste details.
  - View waste details.

## Code Structure
- **Abstract Class**: `Waste`
  - Contains shared attributes and methods for all waste types.
  - Defines an abstract method `calculateDisposalCost()` for dynamic cost calculation.
- **Subclasses**:
  - `OrganicWaste`: Implements cost calculation specific to organic waste.
  - `RecyclableWaste`: Implements cost calculation specific to recyclable waste.
  - `HazardousWaste`: Implements cost calculation specific to hazardous waste.
- **Main Class**: `wastemanagementsystem`
  - Handles user input and system operations such as adding waste and viewing details.

## Object-Oriented Programming (OOP) Principles
The system effectively demonstrates key OOP principles:

1. **Polymorphism**:
   - The `calculateDisposalCost()` method is overridden in each subclass to provide specific behavior for different waste types.

2. **Inheritance**:
   - The `Waste` abstract class serves as a parent class, and its subclasses (`OrganicWaste`, `RecyclableWaste`, `HazardousWaste`) inherit its attributes and methods.

3. **Encapsulation**:
   - Attributes in the `Waste` class are private, and access is provided through public getter and setter methods.
   - This ensures controlled access to the internal state of objects.

4. **Abstraction**:
   - The `Waste` class is abstract, hiding implementation details of `calculateDisposalCost()` while enforcing its implementation in subclasses.

## Alignment with Sustainable Development Goals (SDGs)
This project aligns with the following United Nations Sustainable Development Goals (SDGs):

1. **SDG 6: Clean Water and Sanitation**
   - By promoting proper waste management, the system helps prevent water contamination and ensures cleaner environments.

2. **SDG 11: Sustainable Cities and Communities**
   - The system contributes to sustainable urban development by organizing waste collection and disposal efficiently.

3. **SDG 13: Climate Action**
   - Proper waste categorization and disposal reduce environmental hazards, supporting actions against climate change.

## Author
- [@cjavier15](https://github.com/cjavier15)

