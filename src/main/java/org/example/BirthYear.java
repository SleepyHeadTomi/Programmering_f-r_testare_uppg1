package org.example;

import java.time.Year;
import java.util.Scanner;

public class BirthYear {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("____Birth year calculator____");
        System.out.print("\nEnter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the age you turned or will turn this year: ");
        String age = scanner.nextLine();
        System.out.println("\n");

        System.out.println(getGreeting(name, age));
    }

    /*Metoden skriver ut en hälsningsfras eller ett meddelande till konsolen. Vilket fras eller meddelande
    beror på om användarens inmatningar är korrekta eller inte.*/
    public static String getGreeting(String name, String age){
        name = name.trim();
        age = age.trim();
        if (isValidName(name) && isValidNumber(age)) {
            int birthYear = calculateBirthYear(age.trim());
            return "Hello " + name + "! You were born in " + birthYear + ".";
        }
        else if (!isValidName(name) && isValidNumber(age)) {
            return "Invalid name. Must contain at least one letter.";
        }
        else if (isValidName(name) && !isValidNumber(age)) {
            return "Invalid age. Must be an integer.";
        }
        return "Invalid name and age.";
    }

    //Metoden kontrollerar karaktärerna i en sträng, och om en bokstav hittas returneras true, annars false.
    public static boolean isValidName(String name) {
        for (int i = 0; i < name.length(); i++) {
            char currentChar = name.charAt(i);
            if (Character.isLetter(currentChar)) {
                return true;
            }
        }
        return false;
    }

    /*Metoden kontrollerar först om strängen som matas in enbart består av siffror och om den gör det så
    kontrolleras det om heltalet är inom det definerade intervallet. Är talet inom intervallet returnas
    true, annars false.*/
    public static boolean isValidNumber(String age) {
        int lowerLimitAge = 6;
        int upperLimitAge = 100;

        if (age.matches("^[0-9]+$")) {
            int intAge = Integer.parseInt(age);
            return intAge >= lowerLimitAge && intAge <= upperLimitAge;
        }
        return false;
    }

    //Metoden beräknar födelseåret baserat på användarens inmatade ålder.
    public static int calculateBirthYear(String age) {
        int intAge = Integer.parseInt(age);
        return Year.now().getValue() - intAge;
    }
}