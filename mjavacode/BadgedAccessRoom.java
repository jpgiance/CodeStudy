package mjavacode;

import java.util.HashSet;
import java.util.Set;

/**
 *  We are working on a security system for a badged-access room in our company's building.

	Given an ordered list of employees who used their badge to enter or exit the room, write a function that returns two collections:

	1. All employees who didn't use their badge while exiting the room - they recorded an enter without a matching exit. (All employees are required to leave the room before the log ends.)

	2. All employees who didn't use their badge while entering the room - they recorded an exit without a matching enter. (The room is empty when the log begins.)

	Each collection should contain no duplicates, regardless of how many times a given employee matches the criteria for belonging to it.
 */

public class BadgedAccessRoom {
    public static void main(String[] args) {
        String[][] log = {	  {"Martha",   "exit"},
        {"Paul",     "enter"},
        {"Martha",   "enter"},
        {"Steve",    "enter"},
        {"Martha",   "exit"},
        {"Jennifer", "enter"},
        {"Paul",     "enter"},
        {"Curtis",   "exit"},
        {"Curtis",   "enter"},
        {"Paul",     "exit"},
        {"Martha",   "enter"},
        {"Martha",   "exit"},
        {"Jennifer", "exit"},
        {"Paul",     "enter"},
        {"Paul",     "enter"},
        {"Martha",   "exit"},
        {"Paul",     "enter"},
        {"Paul",     "enter"},
        {"Paul",     "exit"},
        {"Paul",     "exit"}};

        for (String[] strings : answer(log)) {
            for (String s : strings) {
                System.out.print(s);
            }
            System.out.println("-");
        } 
        

    }

    public static String[][] answer(String[][] log){
        
        Set<String> collection1 = new HashSet<>();
        Set<String> collection2 = new HashSet<>();
        Set<String> room = new HashSet<>();

        for (String[] entry : log) {
            if (entry[1].equals("enter")) {
                if (room.contains(entry[0])) {
                    collection1.add(entry[0]);
                } else {
                    room.add(entry[0]);
                }
            } else {
                if (room.contains(entry[0])) {
                    room.remove(entry[0]);
                } else {
                    collection2.add(entry[0]);
                }
            }
        }

        for (String string : room) {
            collection1.add(string);
        }


        String[][] out = {collection1.toArray(new String[collection1.size()]), collection2.toArray(new String[collection2.size()])};
        return out;
    }
}
