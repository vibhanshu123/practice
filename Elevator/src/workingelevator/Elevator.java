package workingelevator;

import java.util.Collections;


import java.util.TreeSet;

/**
 * Created by Arun Singh on 4/3/16.
 */

/*
    Scheduling Algorithm:
    ---------------------------
    -> Upper bound of active requests per elevator (Average per elevator) = activeRequests/elevatorCount + 1
    -> Do not assign the request to an elevator if it is under MAINTENANCE or is already serving more than average number of active requests in the system.
    -> Now, among all elevators excluding above ones, find the closest elevator moving in direction of request or is IDLE.
        -> Case I -     There are 2 elevators - 1 above the requestFloor coming down and 1 below the requestFloor which is coming up:
                        Assign the request to the closest of these 2.
                        return true
        -> Case II -    There is only 1 elevator moving towards the requestFloor:
                        Assign the request to the given elevator.
                        return true
        -> Case III -   No elevators were found eligible to serve the request. Can happen if all the elevators are under MAINTENANCE
                        return false as we could not schedule the request to any of the elevators in the system.
 */


public class Elevator implements IElevator{

    private final Integer id;
    private Integer currentFloor;
    private TreeSet<Integer> upDestinationFloors;
    private TreeSet<Integer> downDestinationFloors;
    private ElevatorStatus elevatorStatus;
    private ElevatorDirection direction;

    public Elevator(Integer currentFloor, Integer id) {
        this.id = id;
        this.currentFloor = currentFloor;
        this.upDestinationFloors = new TreeSet<Integer>();
        this.downDestinationFloors = new TreeSet<Integer>(Collections.reverseOrder());
        this.elevatorStatus = ElevatorStatus.ELEVATOR_FUNCTIONAL;
        this.direction = ElevatorDirection.ELEVATOR_NONE;
    }

    public boolean updateStatus(ElevatorStatus elevatorStatus){
        /*
        Cannot update status for an elevator which is actively serving requests
         */
        if(getTotalRequests() > 0){
            return false;
        }
        this.elevatorStatus = elevatorStatus;
        return true;
    }

    public ElevatorStatus getElevatorStatus(){
        return this.elevatorStatus;
    }

    public int getId(){
        return this.id;
    }

    public int getNextDestionationFloor(){
        if(direction == ElevatorDirection.ELEVATOR_DOWN){
            return this.downDestinationFloors.first();
        }else if(direction == ElevatorDirection.ELEVATOR_UP){
            return this.upDestinationFloors.first();
        }else{
            return 0;
        }
    }

    public int getCurrentFloor(){
        return this.currentFloor;
    }

    public void addNewDestinatoin(Integer destination) {
        if(destination > currentFloor){
            upDestinationFloors.add(destination);
        }else{
            downDestinationFloors.add(destination);
        }
    }

    public boolean moveAndCheckIfServed() {
        direction();
        if(direction == ElevatorDirection.ELEVATOR_UP){
            if(upDestinationFloors.first() == currentFloor){
                return popUpDestionation();
            }else {
                currentFloor++;
            }
        }else if(direction == ElevatorDirection.ELEVATOR_DOWN){
            if(downDestinationFloors.first() == currentFloor){
                return popDownDestionation();
            }else {
                currentFloor--;
            }
        }else{
            //Do Nothing. Elevator is not moving.
        }
        return false;
    }

    public ElevatorDirection getDirection(){
        return this.direction;
    }

    private void direction() {
        if(direction == ElevatorDirection.ELEVATOR_NONE){
            if(upDestinationFloors.size() > 0 && downDestinationFloors.size() > 0){
                if(Math.abs(currentFloor - upDestinationFloors.first()) < Math.abs(currentFloor - downDestinationFloors.first())){
                    direction = ElevatorDirection.ELEVATOR_UP;
                }else{
                    direction = ElevatorDirection.ELEVATOR_DOWN;
                }
            }else if(upDestinationFloors.size() > 0){
                direction = ElevatorDirection.ELEVATOR_UP;
            }else if(downDestinationFloors.size() > 0){
                direction = ElevatorDirection.ELEVATOR_DOWN;
            }
        }
    }

    private boolean popUpDestionation() {
        upDestinationFloors.remove(upDestinationFloors.first());
        if (upDestinationFloors.size() == 0) {
            direction = ElevatorDirection.ELEVATOR_NONE;
        }
        return true;
    }

    private boolean popDownDestionation() {
        downDestinationFloors.remove(downDestinationFloors.first());
        if(downDestinationFloors.size() == 0){
            direction = ElevatorDirection.ELEVATOR_NONE;
        }
        return true;
    }

    public int getTotalRequests(){
        return upDestinationFloors.size() + downDestinationFloors.size();
    }
}