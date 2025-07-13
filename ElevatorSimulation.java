//This is the file which contains main function
import java.util.Scanner;

public class ElevatorSimulation {
    public static void main(String[] args) {
        Elevator elevator = new Elevator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Elevator System");
        while (true) {
            System.out.println("\nCurrent Floor: " + elevator.getCurrentFloor() +
                               " | Direction: " + elevator.getDirection());
            System.out.print("Enter floor number to request (or -1 to run elevator): ");
            int floor = scanner.nextInt();

            if (floor == -1) {
                if (elevator.isIdle()) {
                    System.out.println("No pending requests.");
                } else {
                    elevator.runElevator();
                }
            } else {
                elevator.requestFloor(floor);
            }

            System.out.print("Do you want to add more requests? (yes/no): ");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("no")) {
                System.out.println("Final run starting...");
                elevator.runElevator();
                System.out.println("Elevator is now idle at Floor " + elevator.getCurrentFloor());
                break;
            }
        }

        scanner.close();
    }
}
