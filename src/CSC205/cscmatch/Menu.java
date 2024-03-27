package cscmatch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import positionallist.LinkedPositionalList;

public class Menu {

    private Membership mbrshp;
    private Scanner scnr = new Scanner(System.in);
    private boolean running;
    private boolean unsavedChanges;

    public Menu() {
        mbrshp = new Membership();
        scnr = new Scanner(System.in);
        running = true;
        unsavedChanges = false;
    }

    public void run() {
        while (running) {
            System.out.println("Choose an action:");
            System.out.println("A. Load the Members");
            System.out.println("B. Save the Members");
            System.out.println("C. List All Members");
            System.out.println("D. Add a Member");
            System.out.println("E. Remove a Member");
            System.out.println("F. List Member");
            System.out.println("G. Add an Interest to a Member");
            System.out.println("Q. Quit.");

            String userInput = scnr.nextLine();
            String userChoice = userInput.toUpperCase();

            switch (userChoice) {
                case "A":
                    doLoadMembers();
                    break;
                case "B":
                    doSaveMembers();
                    break;
                case "C":
                    doListAllMembers();
                    break;
                case "D":
                    doAddMember();
                    break;
                case "E":
                    doRemoveMember();
                    break;
                case "F":
                    doListMember();
                    break;
                case "G":
                    doAddInterest();
                    break;
                case "Q":
                    doQuit();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void doLoadMembers() {
        System.out.println("Load Members");
        System.out.println("Enter the name of the file you wish to load:");

        String fileName = scnr.nextLine();
        System.out.println();
        if (fileName.isEmpty()) {
            return;
        }

        try {
            Membership loadedMbr = Membership.load(fileName);
            this.mbrshp = loadedMbr;
            unsavedChanges = false;
            System.out.println("Load successful.");
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }

    private void doSaveMembers() {
        System.out.println("Save Members");
        System.out.println("Enter the name of the file you wish to save:");

        String fileName = scnr.nextLine();
        System.out.println();
        if (fileName.isEmpty()) {
            System.out.println("No file name provided. Save operation cancelled.");
            return;
        }

        try {
            mbrshp.save(fileName);
            unsavedChanges = false;
            System.out.println("Save successful.");
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }

    private void doListAllMembers() {
        System.out.println("List All Members");

        Iterator<Member> iter = mbrshp.iterator();
        while (iter.hasNext()) {
            Member member = iter.next();
            String name = member.getName();
            String[] words = name.split("\\s+");
            StringBuilder capitalizedName = new StringBuilder();
            for (String word : words) {
                if (!word.isEmpty()) {
                    capitalizedName.append(word.substring(0, 1).toUpperCase());
                    if (word.length() > 1) {
                        capitalizedName.append(word.substring(1).toLowerCase());
                    }
                    capitalizedName.append(" ");
                }
            }
            System.out.println(capitalizedName.toString().trim());
        }
    }

    private void doAddMember() {
        String errMsg;
        System.out.println("Add Member");
        System.out.print("Name: ");
        String name = scnr.nextLine();
        System.out.println();
        Member mbr = mbrshp.findMember(name);
        if (mbr != null) {
            System.out.println("That member already exists");
            return;
        }
        errMsg = Member.validateName(name);
        if (errMsg != null) {
            System.out.println(errMsg);
            return;
        }
        int year = getBoundedInt("Year: ", Member.MIN_YEAR, Member.MAX_YEAR);
        mbrshp.addMember(name, year);
        unsavedChanges = true;
    }

    private void doRemoveMember() {
        System.out.println("Remove Members");
        System.out.println("Enter the name of the member to remove: ");
        String nameToRemove = scnr.nextLine();
        System.out.println();

        Iterator<Member> iter = mbrshp.iterator();

        while (iter.hasNext()) {
            Member member = iter.next();

            if (member.getName().equalsIgnoreCase(nameToRemove)) {
                iter.remove();
                unsavedChanges = true;
                System.out.println("Member '" + nameToRemove + "' has been located and removed.");
                break;
            } else if (!member.getName().equalsIgnoreCase(nameToRemove)) {
                System.out.println("Member '" + nameToRemove + "' has not been located.");
            }

        }

    }

    private void doListMember() {
        System.out.println("List Members");
        System.out.println("Enter a name: ");
        String name = scnr.nextLine();
        System.out.println();

        Member myMbr = mbrshp.findMember(name);

        if (myMbr != null) {
            String nameSplit = myMbr.getName();
            String[] words = nameSplit.split("\\s+");
            StringBuilder capitalizedName = new StringBuilder();
            for (String word : words) {
                if (!word.isEmpty()) {
                    capitalizedName.append(word.substring(0, 1).toUpperCase());
                    if (word.length() > 1) {
                        capitalizedName.append(word.substring(1).toLowerCase());
                    }
                    capitalizedName.append(" ");
                }
            }
            nameSplit = capitalizedName.toString().trim();

            System.out.println("Name: " + nameSplit);
            System.out.println("Year: " + myMbr.getYear());
            List<Compatibility> topMatches = displayTop5Matches(myMbr);

            System.out.println("Top 5 Matches for " + nameSplit + ":");
            for (int i = 0; i < topMatches.size(); i++) {
                Compatibility cmp = topMatches.get(i);
                String otherMbrName = cmp.getOtherMbr().getName();
                words = otherMbrName.split("\\s+");
                capitalizedName.setLength(0);
                for (String word : words) {
                    if (!word.isEmpty()) {
                        capitalizedName.append(word.substring(0, 1).toUpperCase());
                        if (word.length() > 1) {
                            capitalizedName.append(word.substring(1).toLowerCase());
                        }
                        capitalizedName.append(" ");
                    }
                }
                otherMbrName = capitalizedName.toString().trim();

                System.out.println((i + 1) + ". " + otherMbrName + " - Score: " + cmp.getScore());
            }

        } else {
            System.out.println("Member with the name '" + name + "' could not be found.");
        }
    }

    private void doAddInterest() {
        System.out.println("Add Interest");

        System.out.println("Enter the name of member: ");
        String name = scnr.nextLine();
        System.out.println();

        Member mbr = mbrshp.findMember(name);

        if (mbr != null) {
            System.out.println(mbr);
        } else {
            System.out.println("Member with the name '" + name + "' could not be found.");
            return;
        }

        System.out.println("Enter an interest: ");
        String interest = scnr.nextLine();
        System.out.println();

        if (interest.trim().isEmpty()) {
            System.out.println("Interest cannot be empty. Please enter a valid interest.");
            return;
        }
        int level = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter an interest level: ");
                level = scnr.nextInt();
                scnr.nextLine();

                if (level < Interest.MIN_LEVEL || level > Interest.MAX_LEVEL) {
                    System.out.println("Level " + level + " is out of range; please specify between " +
                            Interest.MIN_LEVEL + " and " + Interest.MAX_LEVEL + ".");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number from 0 to 10.");
                scnr.nextLine();
            }
        }

        mbr.addInterest(interest, level);
        unsavedChanges = true;
    }

    private void doQuit() {
        System.out.println("Quit");

        if (unsavedChanges) {
            System.out.println("Warning: You have unsaved changes. Do you still want to quit? (y/n)");
            String userInput = scnr.nextLine().toLowerCase();
            System.out.println();

            if (userInput.equals("y")) {
                System.out.println("Exiting program.");
                running = false;
            } else {
                System.out.println("Quit cancelled. Returning to main menu.");

            }
        } else {
            running = false;
        }
    }

    private int getBoundedInt(String prompt, int min, int max) {
        int result;
        while (true) {
            System.out.println(prompt);
            if (scnr.hasNextInt()) {
                result = scnr.nextInt();
                scnr.nextLine();
                if (result >= min && result <= max) {
                    return result;
                }
                System.out.printf("Number must be between %d and %d\n", min, max);
            } else {
                System.out.println("That is not a number");
                scnr.nextLine();
            }
        }
    }

    private List<Compatibility> displayTop5Matches(Member myMbr) {
        LinkedPositionalList<Compatibility> cmpList = new LinkedPositionalList<>();
        List<Compatibility> tempList = new ArrayList<>();

        for (Member otherMbr : mbrshp) {
            if (!otherMbr.equals(myMbr)) {
                Compatibility compatibility = new Compatibility(myMbr, otherMbr);
                tempList.add(compatibility);
            }
        }

        tempList.sort(Comparator.comparing(Compatibility::getScore).reversed());

        List<Compatibility> topMatches = new ArrayList<>();
        for (int i = 0; i < tempList.size() && i < 5; i++) {
            Compatibility cmp = tempList.get(i);
            topMatches.add(cmp);
            cmpList.addLast(cmp);
        }

        return topMatches;
    }

}
