package StackAndQue;

public class TheStackAndQue {
    // Start of stack code.
    Person CurrentTop;

    // Adds a person to the end of the line.
    public void AddToEnd(String Name, int Height) {
        Person NewPerson = new Person(Name, Height, null, null);

        if (CurrentTop == null) {
            CurrentTop = NewPerson;
        } else {
            Person Temp = CurrentTop;
            while (Temp.NextInLine != null) {
                Temp = Temp.NextInLine;
            }
            Temp.NextInLine = NewPerson;
            NewPerson.PreviousInLine = Temp;
        }
    }

    // Removes the person at the end of the line.
    public void RemoveEnd() {
        if (CurrentTop == null) {
            System.out.println("Line is empty.");
            return;
        }
        if (CurrentTop.NextInLine == null) {
            CurrentTop = null;
            return;
        }
        Person Temp = CurrentTop;
        while (Temp.NextInLine.NextInLine != null) {
            Temp = Temp.NextInLine;
        }
        Temp.NextInLine = null;
    }

    // Prints evreyone in the line from the end to the front.
    public void PrintFromEndOfLine() {

        System.out.println("Showing line from the front of the line");

        // Is the tracker for the current number a person is from the end.
        int i = 1;

        // TempPerson will iterate from the NextInLine until it cannot.
        Person TempPerson = CurrentTop;
        while (TempPerson != null) {
            System.out.println(i++ + ": " + TempPerson.Name);
            TempPerson = TempPerson.NextInLine;
        }
        System.err.println("Finished going through the line.");
    }
    // End of Stack code.

    // probobly should have made a seprate file/script for this but got lazy.
    // Start of Que Code

    // Adds person to the front of the line.
    void AddToFront(String Name, int Height) {
        Person TempPerson = GetPersonAtFrontOfLine();
        Person AddedPerson = new Person(Name, Height, null, TempPerson);

        if (TempPerson != null) {
            TempPerson.PreviousInLine = AddedPerson;
        } else {
            CurrentTop = AddedPerson;
        }
    }

    // Removes person from front of line.
    void RemoveFromFront() {
        Person TempFront = GetPersonAtFrontOfLine();
        if (TempFront != null) {
            System.out.println("Removing " + TempFront.Name);
            if (TempFront.PreviousInLine != null) {
                TempFront.PreviousInLine.NextInLine = null;
            } else {
                // If only one person, clear the line
                CurrentTop = null;
            }
        }
    }

    // Gets the person at the front of the line.
    Person GetPersonAtFrontOfLine() {
        // Will iterate from the beggining of the line until it reaches the end and
        // returns the end person.
        if (CurrentTop == null) {
            return null;
        }
        Person FirstPersonInLine = CurrentTop;
        while (FirstPersonInLine.NextInLine != null) {
            FirstPersonInLine = FirstPersonInLine.NextInLine;
        }
        return FirstPersonInLine;
    }

    // Prints evreyone starting from the person at the start of the line.
    public void PrintFromStartOfLine() {
        // Stores person at the front of the line.
        Person TempPerson = GetPersonAtFrontOfLine();

        // Iterates through each person starting with the first in line.
        System.out.println("Showing line from the start of the line");
        // Number to track the current number in line.
        int i = 1;
        while (TempPerson != null) {
            System.out.println(i++ + ": " + TempPerson.Name);
            TempPerson = TempPerson.PreviousInLine;
        }

        System.err.println("Finished going through the line.");
    }
    // End of Que Code.

    // Checks if the line is empty and returns true or false.
    boolean CheckIfLineIsEmpty() {
        boolean Empty = false;
        if (CurrentTop == null) {
            System.out.println("The Line is empty I think. At least is should be.");
            Empty = true;
        }
        return Empty;
    }
}