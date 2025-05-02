package StackAndQue;

import java.util.Scanner;

class Person {
    // Variables for person.
    String Name;
    int Height;
    Person NextInLine;
    Person PreviousInLine;

    // Sets the variables for the person class.
    Person(String name, int height, Person PersonNextInLine, Person PreviousInLine) {
        this.Name = name;
        this.Height = height;
        this.NextInLine = PersonNextInLine;
        this.PreviousInLine = PreviousInLine;
    }
}

public class StackQueueTest {
    public static void main(String[] args) {
        // Initalize scanner and StackAndQue variables.
        Scanner Scan = new Scanner(System.in);
        TheStackAndQue StackAndQue = new TheStackAndQue();

        // Will not ever stop repeating as it runs the main cuntions of teh code.
        while (true) {

            System.out.println("Line Actions");

            // Lists all of the actions you can do to the line.
            System.out.println("-2: Check list from beggining of line");
            System.out.println("-1: Check list from the end of line");
            System.out.println("0: Remove first Person from Line");
            System.out.println("1: Remove last Person from Line");
            System.out.println("2: Add Person to start of Line");
            System.out.println("3: Add Person to end of Line");

            // Gets next input from the user/player.
            int NextInput = Scan.nextInt();
            Scan.nextLine();

            // Checks and prints evrey one from the beggining of the line.
            if (NextInput == -2) {
                // checks if the line is null.
                if (!StackAndQue.CheckIfLineIsEmpty()) {
                    StackAndQue.PrintFromStartOfLine();
                }
            }

            // Checks and prints evrey one from the end of the line.
            if (NextInput == -1) {
                // checks if the line is null.
                if (!StackAndQue.CheckIfLineIsEmpty()) {
                    StackAndQue.PrintFromEndOfLine();
                }
            }

            // Removes the first person from the line.
            if (NextInput == 0) {
                if (!StackAndQue.CheckIfLineIsEmpty()) {
                    System.out.println("Removeing first person in line" + StackAndQue.GetPersonAtFrontOfLine());
                    StackAndQue.RemoveFromFront();
                    System.out.println("Removed.");
                }
            }

            // Removes the last person from the line.
            if (NextInput == 1) {
                if (!StackAndQue.CheckIfLineIsEmpty()) {
                    System.out.println("Removeing last person in line" + StackAndQue.CurrentTop.Name);
                    StackAndQue.RemoveEnd();
                    System.out.println("Removed.");
                }
            }

            // Lets the user create a new person at the front of the line.
            if (NextInput == 2) {
                System.out.println("Add Name and Height to the person who skipped to the front of the line.");
                StackAndQue.AddToFront(Scan.nextLine(), Scan.nextInt());
                Scan.nextLine();
                System.err.println("Added " + StackAndQue.CurrentTop.Name + " to the front of the line.");
            }

            // Lets the user create a new person at the end of the line.
            if (NextInput == 3) {
                System.out.println("Add Name and Height to the person who got into line.");
                StackAndQue.AddToEnd(Scan.nextLine(), Scan.nextInt());
                Scan.nextLine();
                System.err.println("Added " + StackAndQue.CurrentTop.Name + " to the end of the line.");
            }
        }
    }
}