
import java.util.*;

interface ElevatorOperations {
    void requestFloor(int floor);
    void runElevator();
}

class Elevator implements ElevatorOperations {
    private int currentFloor = 0;
    private String direction = "UP";
    private Set<Integer> requests = new TreeSet<>();

    public void requestFloor(int floor) {
        if (floor == currentFloor) {
            System.out.println("Already at Floor " + floor);
            return;
        }
        if (requests.contains(floor)) {
            System.out.println("Request for Floor " + floor + " is already in queue.");
        } else {
            requests.add(floor);
            System.out.println("Added request for Floor " + floor);
        }
    }

    public void runElevator() {
        while (!requests.isEmpty()) {
            List<Integer> currentDirectionFloors = getFloorsInCurrentDirection();
            for (int floor : currentDirectionFloors) {
                moveToFloor(floor);
                requests.remove(floor);
            }
            changeDirection();
        }
    }

    private void moveToFloor(int floor) {
        while (currentFloor != floor) {
            if (currentFloor < floor) {
                currentFloor++;
            } else {
                currentFloor--;
            }
            System.out.println("Moving " + direction + " to Floor " + currentFloor);
            try {
                Thread.sleep(2000); // pause 2 seconds
            } catch (InterruptedException e) {
                System.out.println("Elevator interrupted.");
            }
        }
        System.out.println("Stopped at Floor " + currentFloor);
    }

    private List<Integer> getFloorsInCurrentDirection() {
        List<Integer> list = new ArrayList<>();
        for (int floor : requests) {
            if (direction.equals("UP") && floor > currentFloor) {
                list.add(floor);
            } else if (direction.equals("DOWN") && floor < currentFloor) {
                list.add(floor);
            }
        }
        return list;
    }

    private void changeDirection() {
        if (direction.equals("UP")) {
            direction = "DOWN";
        } else {
            direction = "UP";
        }
    }

    public boolean isIdle() {
        return requests.isEmpty();
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public String getDirection() {
        return direction;
    }
}

