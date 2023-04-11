package ru;

import java.util.Scanner;

public class Elevator {
    private int currentFloor = 1;
    private int maxFloor;
    private int minFloor;

    Elevator(int maxFloor, int minFloor) {
        this.maxFloor = maxFloor;
        this.minFloor = minFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveDown() {
        currentFloor = currentFloor >= minFloor ? currentFloor - 1 : currentFloor;
    }

    public void moveUp() {
        currentFloor = currentFloor <= maxFloor ? currentFloor + 1 : currentFloor;
    }

    public void move(int floor){
        if (floor > maxFloor){
            System.out.println("Error");
            return;
        }
        if(currentFloor == floor){
            return;
        }
        if (floor <minFloor){
            System.out.println("Error");
            return;
        }
        while (currentFloor!=floor){
            if (currentFloor > floor) {
                moveDown();
                System.out.println("Этаж: " +getCurrentFloor());
            }
            if (currentFloor < floor){
                moveUp();
                System.out.println("Этаж: " + getCurrentFloor());
            }
        }
    }

    public static class Main {

        public static void main(String[] args) {
            Elevator elevator = new Elevator(26, -3);

            while (true) {
                System.out.println("Введите номер этажа: ");
                int floor = new Scanner(System.in).nextInt();
                elevator.move(floor);
            }
        }
    }
}
