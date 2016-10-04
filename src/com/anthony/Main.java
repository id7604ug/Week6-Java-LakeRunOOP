package com.anthony;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static Scanner numberScanner = new Scanner(System.in);
    private static Scanner stringScanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Create ArrayList for objects
        //Create HashMap for lakes and data
        HashMap<String, LakeData> lakeList = new HashMap<String, LakeData>();
        // While loop to continue to ask for times
        while(true) {
            // Get a lake name and time
            getLakeAndTime(lakeList);
            // Display current lakes and times
            showLakeTimes(lakeList);
            // Ask to add another
            System.out.println("Would you like to add another time? (y/n)");
            String another = stringScanner.nextLine();
            // Stop if user does not input "y"
            if ( ! another.equalsIgnoreCase("y")) {
                // Display top times
                displayTopTimes(lakeList);
                break;
            }
        }
        stringScanner.close();
        numberScanner.close();
    }

    // Method to display top times
    private static void displayTopTimes(HashMap<String, LakeData> lakeList) {
        System.out.println("Here are your best times:");
        for (String lake:lakeList.keySet()) {
            lakeList.get(lake).showBestTime();
        }
    }

    // Method to display lakes and run times
    private static void showLakeTimes(HashMap<String, LakeData> lakeList) {
        // Loop over each lake
        for (String lake:lakeList.keySet()) {
            lakeList.get(lake).showTimes();
        }
    }

    // Method to get run time
    private static void getLakeAndTime(HashMap<String, LakeData> lakeList) {
        // Get lake and times
        System.out.print("What lake did you run at? ");
        String lakeName = stringScanner.nextLine();
        System.out.print("What time did you get? ");
        Double runTime = numberScanner.nextDouble();
        if (!lakeList.keySet().contains(lakeName)) {
            lakeList.put(lakeName, new LakeData(lakeName));
            lakeList.get(lakeName).addTime(runTime);
        } else {
            lakeList.get(lakeName).addTime(runTime);
        }
        // Set values in HashMap
        // runningTimes.put(lakeName, runTime);
    }
}
