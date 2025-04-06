/*
 * Truman Forey | 4/6/2025 | CSD 420 Assignment 3.2
 * 
 * This program is an experiment to learn about and gain
 * experience with generic types and ArrayLists. This program
 * generates an ArrayList with 50 random numbers between 1-20,
 * and then running the 'removeDuplicates()' method to remove
 * all duplicates in the ArrayList. It then prints the revised
 * ArrayList.
 */
package com.example.csd420.asgnt03;

import java.util.ArrayList;
import java.util.Random;

public class genericsTest {
    static Random random = new Random();
    
    public static void printArrayList(ArrayList givenAL) { // testing function
        for (Object value : givenAL) {
            System.out.println(value);
        }
    }
    
    public static Integer generate1to20() {
        Integer x = random.nextInt(20) + 1; // added a +1 since nextInt would generate 0-19
        return x;
    }
    
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> removalArrayList = new ArrayList<>();
        for (E o : list) {
            if (removalArrayList.contains(o)) {
                ; // empty statement just to guarantee that the code knows to do nothing
            } else {
                removalArrayList.add(o);
            }
        }
        return removalArrayList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> workingArrayList = new ArrayList<>();
        int u = 0;
        while (u < 50) {
            workingArrayList.add(generate1to20());
            u++;
        }
        //printArrayList(workingArrayList);
        
        ArrayList<Integer> revisedArrayList = new ArrayList<>();
        revisedArrayList = removeDuplicates(workingArrayList);
        printArrayList(revisedArrayList);
    }
}
