package com.mycompany.csd420_asgnt06;

//import java.util.ArrayList;
//import java.util.Arrays;
//import static java.util.Collections.list;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Truman Forey || 4/20/2025 || CSD 420 Assignment 6.2
 * 
 * This program is a simple experiment with comparable and comparator interfaces.
 * This program has two void classes that are used together to bubble sort an
 * Integer[] list. The list before and after being sorted will be printed as
 * a way to test these classes.
 */

public class bubbleSort {
    
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        int x = 0; // index of list being compared
        int y = 0; // number being compared against x
        E z; // I'm astonished this works
        
        for (x = 0; x < list.length - 1; x++) {
            for (y = 0; y < list.length - 1; y++) {
                if (list[y].compareTo(list[y + 1]) > 0) { // checks if returned value is positive
                    z = list[y];
                    list[y] = list[y + 1];
                    list[y + 1] = z;
                }
                //y++; // attempted to use longer form since that's what I'm used to but i kept throwing an error
            }
            //y = 0;
            //x++;
        }
    }
    
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        int x = 0; // copied most of this code from comparable
        int y = 0;
        E z;

        for (x = 0; x < list.length - 1; x++) {
            for (y = 0; y < list.length - 1 - y; y++) {
                if (comparator.compare(list[y], list[y + 1]) > 0) {
                    z = list[y];
                    list[y] = list[y + 1];
                    list[y + 1] = z;
                }
            }
        }
    }

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        //ArrayList<Integer> testList = new ArrayList<>(
        //    Arrays.asList(5,3,4,9,0,1,2,7,6,8)
        //);
        
        Integer[] testList = {5,3,4,9,0,1,2,7,6,8}; // had to use Integer instead of int
        
        System.out.println("The unsorted list is as follows:");
        System.out.println(Arrays.toString(testList));
        bubbleSort(testList);
        System.out.println("\nThe sorted list is as follows:");
        System.out.println(Arrays.toString(testList));
    }
}
