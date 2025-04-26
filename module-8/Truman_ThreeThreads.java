/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.csd420_asgnt08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Truman Forey || 4/25/2025 || CSD 420 Assignment 8.2
 * 
 * This program is an experiment to help understand threading and multithreading.
 * This program will first define multiple classes to be used later in the program,
 * including three different thread classes. Then the program will be run, creating 
 * three threads that will operate at once. All three of the threads will output
 * 10,000 random characters.
 */
public class Truman_ThreeThreads {
    static Random random = new Random();
    
    public static int randomNumber(int max) {
        int rN = random.nextInt(max);
        return rN;
    }
    
    public static String returnList(ArrayList givenList) {
        int listLength = givenList.size();
        int randomIndex = randomNumber(listLength-1);
        String rL = (String) givenList.get(randomIndex);
        return rL;
    }

    // had to experiment with threads a bit to make this work, hopefully it's sufficient
    
    static class letterThread extends Thread {
        @Override
        public void run() {
            int i = 0;
            ArrayList<String> letterList = new ArrayList<>(Arrays.asList(
                "A","B","C","D","E","F","G","H","I","J","K","L","M",
                "N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
            ));
            while (i < 10000) {
                System.out.println(returnList(letterList));
                i++;
            }
        }
    }

    static class numberThread extends Thread {
        @Override
        public void run() {
            int i = 0;
            while (i < 10000) {
                System.out.println(randomNumber(10));
                i++;
            }
        }
    }

    static class specialThread extends Thread {
        @Override
        public void run() {
            int i = 0;
            ArrayList<String> specialList = new ArrayList<>(Arrays.asList(
                "!","@","#","$","%","^","&","*","-","_",
                "=","+","`",";"
            ));
            while (i < 10000) {
                System.out.println(returnList(specialList));
                i++;
            }
        }
    }
    
    public static void main(String[] args) {
        //System.out.println("Hello World!");
        Scanner scanner = new Scanner(System.in);
        var dummy = "";
        
        System.out.println("""
                           This program will create 3 threads, each of which will
                           print 10,000 random values. As such, please only continue
                           this program if you're ready to handle a large amount of
                           output.
                           """);
        System.out.println("Enter any key to continue.");
        dummy = scanner.nextLine();
        
        letterThread letterThread = new letterThread();
        numberThread numberThread = new numberThread();
        specialThread specialThread = new specialThread();
        
        letterThread.start(); // originally I started a thread after it was created,
        numberThread.start(); // but that just made them go in order
        specialThread.start(); // this way has them be more random
    }
}
