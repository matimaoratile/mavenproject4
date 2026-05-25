/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject4;

import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

public class Mavenproject4 {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Message> sentMessages = new ArrayList<>();
    static int totalMessagesSent = 0;

    public static void main(String[] args) {

        String firstname, lastname, username, password, cellnumber;

        // ================= REGISTRATION =================
        System.out.print("Enter First Name: ");
        firstname = input.nextLine();

        System.out.print("Enter Last Name: ");
        lastname = input.nextLine();

        // Username validation
        do {
            System.out.print("Enter Username (must contain '_' and max 5 chars): ");
            username = input.nextLine();

            if (!checkUsername(username)) {
                System.out.println("Invalid username.");
            }

        } while (!checkUsername(username));

        System.out.println("Username successfully captured.");

        // Password validation
        do {
            System.out.print("Enter Password (min 8 chars, 1 capital, 1 number, 1 special char): ");
            password = input.nextLine();

            if (!checkPasswordComplexity(password)) {
                System.out.println("Invalid password.");
            }

        } while (!checkPasswordComplexity(password));

        System.out.println("Password successfully captured.");

        // Phone validation
        do {
            System.out.print("Enter Phone Number (+27 followed by 9 digits): ");
            cellnumber = input.nextLine();

            if (!checkCellNumber(cellnumber)) {
                System.out.println("Invalid cell number.");
            }

        } while (!checkCellNumber(cellnumber));

        System.out.println("Cell number successfully captured.");

        // ================= LOGIN =================
        System.out.println("\n--- LOGIN ---");

        int attempts = 3;
        boolean loggedIn = false;

        while (attempts > 0) {

            System.out.print("Enter Username: ");
            String loginUsername = input.nextLine();

            System.out.print("Enter Password: ");
            String loginPassword = input.nextLine();

            if (loginUser(username, password, loginUsername, loginPassword)) {

                System.out.println("Login successful! Welcome "
                        + firstname + " " + lastname);

                loggedIn = true;
                break;

            } else {

                attempts--;
                System.out.println("Incorrect details. Attempts left: "
                        + attempts);
            }
        }

        if (!loggedIn) {
            System.out.println("Too many failed attempts. Access denied.");
            return;
        }

        // ================= QUICKCHAT SYSTEM =================
        System.out.println("\nWelcome to QuickChat");

        int choice = 0;

        do {

            System.out.println("\nMenu:");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");

            if (input.hasNextInt()) {

                choice = input.nextInt();
                input.nextLine();

            } else {

                System.out.println("Please enter numbers only.");
                input.nextLine();
                continue;
            }

            switch (choice) {

                case 1:
                    sendMessages();
                    break;

                case 2:
                    showRecentMessages();
                    break;

                case 3:
                    System.out.println("Total messages sent: "
                            + returnTotalMessages());

                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 3);
    }

    // ================= USER VALIDATION METHODS =================

    public static boolean checkUsername(String username) {

        return username.contains("_") && username.length() <= 5;
    }

    public static boolean checkPasswordComplexity(String password) {

        boolean hasUpper = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {

            if (Character.isUpperCase(c)) {
                hasUpper = true;
            }

            if (Character.isDigit(c)) {
                hasNumber = true;
            }

            if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }

        return password.length() >= 8
                && hasUpper
                && hasNumber
                && hasSpecial;
    }

    public static boolean checkCellNumber(String number) {

        return number.matches("\\+27\\d{9}");
    }

    public static boolean loginUser(String storedUsername,
                                    String storedPassword,
                                    String enteredUsername,
                                    String enteredPassword) {

        return storedUsername.equals(enteredUsername)
                && storedPassword.equals(enteredPassword);
    }

    // ================= MESSAGE SYSTEM =================

    public static void sendMessages() {

        System.out.print("How many messages would you like to send? ");

        int numberOfMessages;

        if (input.hasNextInt()) {

            numberOfMessages = input.nextInt();
            input.nextLine();

        } else {

            System.out.println("Invalid number.");
            input.nextLine();
            return;
        }

        for (int i = 0; i < numberOfMessages; i++) {

            String messageID = generateMessageID();

            System.out.print("Enter recipient number (+27123456789): ");
            String recipient = input.nextLine();

            while (!checkRecipientCell(recipient)) {

                System.out.print("Invalid recipient. Re-enter: ");
                recipient = input.nextLine();
            }

            System.out.print("Enter message (max 250 characters): ");
            String messageText = input.nextLine();

            if (messageText.trim().isEmpty()) {

                System.out.println("Message cannot be empty.");
                i--;
                continue;
            }

            if (messageText.length() > 250) {

                System.out.println("Please enter a message of less than 250 characters.");
                i--;
                continue;
            }

            String hash = createMessageHash(messageID,
                    totalMessagesSent,
                    messageText);

            Message message = new Message(messageID,
                    hash,
                    recipient,
                    messageText);

            String result = sentMessage(message);

            if (result.equals("sent")) {

                sentMessages.add(message);
                totalMessagesSent++;

                printMessageDetails(message);
            }
        }
    }

    public static boolean checkRecipientCell(String cell) {

        return cell.matches("\\+\\d{10,12}");
    }

    public static String createMessageHash(String messageID,
                                           int messageNumber,
                                           String messageText) {

        String firstTwoDigits = messageID.substring(0, 2);

        String[] words = messageText.trim().split(" ");

        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        return firstTwoDigits
                + ":"
                + messageNumber
                + ":"
                + (firstWord + lastWord).toUpperCase();
    }

    public static String sentMessage(Message message) {

        System.out.println("\nChoose an option:");
        System.out.println("1) Send Message");
        System.out.println("2) Disregard Message");
        System.out.println("3) Store Message to send later");

        int option;

        if (input.hasNextInt()) {

            option = input.nextInt();
            input.nextLine();

        } else {

            input.nextLine();
            return "discarded";
        }

        switch (option) {

            case 1:

                System.out.println("Message successfully sent");
                return "sent";

            case 2:

                System.out.println("Message discarded");
                return "discarded";

            case 3:

                storeMessage(message);

                System.out.println("Message successfully stored");
                return "stored";

            default:

                return "discarded";
        }
    }

    public static void printMessageDetails(Message message) {

        System.out.println("\n--- Message Details ---");

        System.out.println("Message ID: " + message.messageID);
        System.out.println("Message Hash: " + message.messageHash);
        System.out.println("Recipient: " + message.recipient);
        System.out.println("Message: " + message.messageText);
    }

    public static int returnTotalMessages() {

        return totalMessagesSent;
    }

    public static void showRecentMessages() {

        if (sentMessages.isEmpty()) {

            System.out.println("No messages sent yet.");
            return;
        }

        for (Message message : sentMessages) {

            printMessageDetails(message);
        }
    }

    public static void storeMessage(Message message) {

        try {

            FileWriter writer = new FileWriter("storedMessages.json", true);

            writer.write("{\n");
            writer.write("\"MessageID\":\""
                    + message.messageID + "\",\n");

            writer.write("\"Hash\":\""
                    + message.messageHash + "\",\n");

            writer.write("\"Recipient\":\""
                    + message.recipient + "\",\n");

            writer.write("\"Message\":\""
                    + message.messageText + "\"\n");

            writer.write("}\n\n");

            writer.close();

        } catch (IOException e) {

            System.out.println("Error storing message.");
        }
    }

    public static String generateMessageID() {

        Random random = new Random();

        long number = 1000000000L
                + (long) (random.nextDouble() * 9000000000L);

        return String.valueOf(number);
    }
}

// ================= MESSAGE CLASS =================

class Message {

    String messageID;
    String messageHash;
    String recipient;
    String messageText;

    public Message(String messageID,
                   String messageHash,
                   String recipient,
                   String messageText) {

        this.messageID = messageID;
        this.messageHash = messageHash;
        this.recipient = recipient;
        this.messageText = messageText;
    }
}