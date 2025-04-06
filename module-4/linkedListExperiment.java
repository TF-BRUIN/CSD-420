
package com.mycompany.csd420_asgnt04;

// experimenting with switching between gradle and maven

import java.util.Iterator;
import java.util.Random;
import java.util.LinkedList;
import java.util.Scanner;

// i don't know what the difference is and it probably doesn't matter
// but that would explain why some assignments look different

/**
 * Truman Forey | 4/6/2025 | CSD 420 Assignment 4.2
 * 
 * This program is an experiment with LinkedLists, as well as a test
 * for how fast LinkedLists can perform actions compared to other actions.
 * This program first creates 2 different LinkedLists - one with 50,000 integers
 * and 500,000 integers. This program then uses iterators and the .get() method
 * to find the final value in both lists. There is a note at the bottom of the
 * program listing the findings I found from making this program.
 */
public class linkedListExperiment {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    
    public static int generateInt() {
        int x = random.nextInt(1000); // random number between 0 and 999
        return x;
    }
    
    public static int randomIndex(int listSize) {
        int y = random.nextInt(listSize);
        return y;
    }
    
    public static void main(String[] args) {
        int i = 0;
        int r = 0;
        String dummy = "";
        /////////////////////// PUTTING A SPACE INBETWEEN CODING BLOCKS ///////////////////////
        LinkedList<Integer> intStorage50k = new LinkedList<>();
        System.out.println("This program will now generate 50,000 integers (int) and store them in a LinkedList.");
        System.out.println("This will be called the '50k LinkedList'.");
        System.out.println("Enter any key to continue.");
        dummy = scanner.next(); // dummy is used to just pause the program, it is never read
        while (i < 50000) {
            intStorage50k.add(generateInt());
            i++;
        }
        i = 0;
        System.out.println("Process completed.\n");
        /////////////////////// PUTTING A SPACE INBETWEEN CODING BLOCKS ///////////////////////
        LinkedList<Integer> intStorage500k = new LinkedList<>();
        System.out.println("This program will now generate 500,000 integers (int) and store them in a LinkedList.");
        System.out.println("This will be called the '500k LinkedList'.");
        System.out.println("Enter any key to continue.");
        dummy = scanner.next();
        while (i < 500000) {
            intStorage500k.add(generateInt());
            i++;
        }
        i = 0;
        System.out.println("Process completed.\n");
        /////////////////////// PUTTING A SPACE INBETWEEN CODING BLOCKS ///////////////////////
        System.out.println("""
                           This program will now find the value in the final index in both LinkedLists.
                           This will be done in two different ways, to test which is faster.
                           The first way will be by using an iterator,
                           the second way will be by using the .get() method.
                           """);
        System.out.println("Enter any key to continue.");
        dummy = scanner.next();
        
        /////////////////////// PUTTING A SPACE INBETWEEN CODING BLOCKS ///////////////////////
        ///
        System.out.println("This program will now use an iterator to find the final index in the 50k LinkedList.");
        System.out.println("Enter any key to continue.");
        dummy = scanner.next();
        
        Iterator<Integer> iterator50k = intStorage50k.iterator();
        while (iterator50k.hasNext()) {
            r = iterator50k.next();
        }
        System.out.println("The final index value is: " + r);
        System.out.println("Process completed.\n");
        /////////////////////// PUTTING A SPACE INBETWEEN CODING BLOCKS ///////////////////////
        System.out.println("This program will now use an iterator to find the final index in the 500k LinkedList.");
        System.out.println("Enter any key to continue.");
        dummy = scanner.next();
        
        Iterator<Integer> iterator500k = intStorage500k.iterator();
        while (iterator500k.hasNext()) {
            r = iterator500k.next();
        }
        System.out.println("The final index value is: " + r);
        System.out.println("Process completed.\n");
        /////////////////////// PUTTING A SPACE INBETWEEN CODING BLOCKS ///////////////////////
        System.out.println("This program will now use the .get() method to find the final index in the 50k LinkedList.");
        System.out.println("Enter any key to continue.");
        dummy = scanner.next();
        
        r = intStorage50k.get(50000-1); // instead of doing 49,999, I jsut went with -1 because it's easier to remember
        System.out.println("The final index value is: " + r);
        System.out.println("Process completed.\n");
        /////////////////////// PUTTING A SPACE INBETWEEN CODING BLOCKS ///////////////////////
        System.out.println("This program will now use the .get() method to find the final index in the 500k LinkedList.");
        System.out.println("Enter any key to continue.");
        dummy = scanner.next();
        
        r = intStorage500k.get(500000-1); 
        System.out.println("The final index value is: " + r);
        System.out.println("Process completed.\n");
        /////////////////////// PUTTING A SPACE INBETWEEN CODING BLOCKS ///////////////////////
    }
    /**
     * FINDINGS - 
     * 
     * Despite the instructions in the assignment, I was not able to detect
     * any particular speed differences in any of the four processes made
     * above. 
     */
}
