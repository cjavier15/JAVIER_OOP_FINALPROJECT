import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract class for Waste
abstract class Waste {
    private String type;
    private double weight;
    private String location;
    private boolean isCollected;

    public Waste(String type, double weight, String location) {
        this.type = type;
        this.weight = weight;
        this.location = location;
        this.isCollected = false;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public String getLocation() {
        return location;
    }

    public boolean isCollected() {
        return isCollected;
    }

    public void declareCollected() {
        this.isCollected = true;
    }

    public abstract double calculateDisposalCost(); // Abstract method
}

// Subclass for Organic Waste
class OrganicWaste extends Waste {
    public OrganicWaste(double weight, String location) {
        super("Organic", weight, location);
    }

    @Override
    public double calculateDisposalCost() { // Method overriding
        return getWeight() * 0.5; // Cost per kg for organic waste
    }
}

// Subclass for Recyclable Waste
class RecyclableWaste extends Waste {
    public RecyclableWaste(double weight, String location) {
        super("Recyclable", weight, location);
    }

    @Override
    public double calculateDisposalCost() { // Method overriding
        return getWeight() * 0.3; // Cost per kg for recyclable waste
    }
}

// Subclass for Hazardous Waste
class HazardousWaste extends Waste {
    public HazardousWaste(double weight, String location) {
        super("Hazardous", weight, location);
    }

    @Override
    public double calculateDisposalCost() { // Method overriding
        return getWeight() * 1.5; // Cost per kg for hazardous waste
    }
}

// Main class for the waste management system
public class wastemanagementsystem {
    private List<Waste> wasteList;

    public wastemanagementsystem() {
        wasteList = new ArrayList<>();
    }

    public void addWaste(Waste waste) {
        wasteList.add(waste);
    }

    public void displayWasteDetails() {
        if (wasteList.isEmpty()) {
            System.out.println("No waste details available.");
            return;
        }
        System.out.println("\n==============================");
        System.out.println("         Waste Details         ");
        System.out.println("==============================");
        
        for (int i = 0; i < wasteList.size(); i++) {
            Waste waste = wasteList.get(i);
            double weight = waste.getWeight();
            String location = waste.getLocation(); // Get the location
            String status = waste.isCollected() ? "Collected" : "Pending"; // Get collection status

            System.out.printf("%d: Type: %-12s | Weight: %-6.2f kg | Location: %s | Status: %s%n",
                    (i + 1), waste.getType(), weight, location, status);
        }

        // Print collection schedule
        System.out.println("\nALL WASTES ARE TO BE COLLECTED ON MONDAY, WEDNESDAY, FRIDAY AT 6AM ONWARDS");
        System.out.println("==============================");
    }

    public static void main(String[] args) {
        wastemanagementsystem system = new wastemanagementsystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("Welcome to the Waste Management System!");
        System.out.println("========================================");

        while (true) {
            // User authentication
            String role = "";
            while (true) {
                System.out.println("Select your role:");
                System.out.println("1: Admin");
                System.out.println("2: User");
                System.out.print("Enter your choice: ");
                String roleInput = scanner.nextLine();

                if (roleInput.equals("1")) {
                    System.out.print("Enter admin password: ");
                    String password = scanner.nextLine();
                    if (password.equals("admin")) {
                        role = "admin";
                        break; // Exit the loop if authenticated
                    } else {
                        System.out.println("Incorrect password. Please try again.");
                    }
                } else if (roleInput.equals("2")) {
                    role = "user";
                    break; // Exit the loop for user
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }

            // Main loop based on role
            while (true) {
                try {
                    if (role.equals("admin")) {
                        System.out.println("\nAdmin Menu:");
                        System.out.println("1: View Waste Details");
                        System.out.println("2: Logout");
                        System.out.println("0: Exit");
                        System.out.print("Enter your choice: ");
                        String input = scanner.nextLine();
                        if (input.equals("0")) {
                            System.out.println("Exiting the program. Thank you!");
                            scanner.close();
                            return; // Exit the program
                        } else if (input.equals("1")) {
                            system.displayWasteDetails();
                            System.out.print("Enter the number of the waste item to declare as collected (or 0 to declare all): ");
                            String declareInput = scanner.nextLine();
                            int declareChoice = Integer.parseInt(declareInput);

                            if (declareChoice == 0) {
                                for (Waste waste : system.wasteList) {
                                    waste.declareCollected(); // Declare all waste as collected
                                }
                                System.out.println("All waste has been declared as collected.");
                            } else if (declareChoice > 0 && declareChoice <= system.wasteList.size()) {
                                Waste selectedWaste = system.wasteList.get(declareChoice - 1); // Get the selected waste item
                                selectedWaste.declareCollected(); // Declare the selected waste as collected
                                System.out.println("Waste item " + declareChoice + " has been declared as collected.");
                            } else {
                                System.out.println("Invalid choice. Please try again.");
                            }
                        } else if (input.equals("2")) {
                            System.out.println("Logging out...");
                            break; // Exit to authentication loop
                        } else {
                            System.out.println("Invalid choice. Please try again.");
                        }
                    } else if (role.equals("user")) {
                        System.out.println("\nUser Menu:");
                        System.out.println("1: Add Waste");
                        System.out.println("2: View Waste Details");
                        System.out.println("3: Logout");
                        System.out.println("0: Exit");
                        System.out.print("Enter your choice: ");
                        String input = scanner.nextLine();
                        if (input.equals("0")) {
                            System.out.println("Exiting the program. Thank you!");
                            scanner.close();
                            return; // Exit the program
                        } else if (input.equals("1")) {
                            System.out.println("Select waste type:");
                            System.out.println("1: Organic");
                            System.out.println("2: Recyclable");
                            System.out.println("3: Hazardous");
                            System.out.print("Enter your choice: ");
                            String wasteTypeInput = scanner.nextLine();
                            int wasteTypeChoice = Integer.parseInt(wasteTypeInput);

                            double weight = 0;
                            boolean validWeight = false;
                            while (!validWeight) {
                                System.out.print("Enter weight (kg): ");
                                String weightInput = scanner.nextLine(); // Store weight input as a string
                                try {
                                    weight = Double.parseDouble(weightInput); // Parse only after validation
                                    validWeight = true;
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid input. Please enter numeric values.");
                                }
                            }

                            System.out.print("Enter pick-up location: "); // New input for location
                            String location = scanner.nextLine(); // Store location input

                            Waste waste = null;
                            switch (wasteTypeChoice) {
                                case 1:
                                    waste = new OrganicWaste(weight, location);
                                    break;
                                case 2:
                                    waste = new RecyclableWaste(weight, location);
                                    break;
                                case 3:
                                    waste = new HazardousWaste(weight, location);
                                    break;
                                default:
                                    System.out.println("Invalid waste type selected.");
                                    continue; // Skip to the next iteration of the loop
                            }

                            system.addWaste(waste);
                            System.out.println("Waste added successfully!");
                        } else if (input.equals("2")) {
                            system.displayWasteDetails();
                        } else if (input.equals("3")) {
                            System.out.println("Logging out...");
                            break; // Exit to authentication loop
                        } else {
                            System.out.println("Invalid choice. Please try again.");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("An unexpected error occurred: " + e.getMessage());
                }
            }
        }
    }
}