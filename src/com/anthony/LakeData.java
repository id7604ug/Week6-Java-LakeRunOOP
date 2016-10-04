package com.anthony;

import java.util.ArrayList;

public class LakeData {
    // Variables to store lake data
    private String lakeName;
    private ArrayList<Double> runTimes = new ArrayList<Double>();

    // Constructor
    public LakeData(String name){
        lakeName = name;
    }
    // Method to add a time
    public void addTime(double time){
        runTimes.add(time);
    }
    // Method to show all times
    public void showTimes(){
        System.out.println("Your time for " + lakeName + ":");
        for (double time:runTimes) {
            System.out.println(time);
        }
    }
    // Method to show best time
    public void showBestTime(){
        double fastestTime = runTimes.get(0);
        // Loops over each time to find the fastest
        for (double time:runTimes) {
            if (fastestTime > time){
                fastestTime = time;
            }
        }
        System.out.println("The best time for " + lakeName + " is: " + fastestTime);
    }
}