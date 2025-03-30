package com.mycompany.csd420_asgnt02;

/**
 * Truman Forey | 3/29/2025 | CSD 420 Assignment 2.2
 * 
 * This program is a basic test with file creating, writing, and reading
 * across multiple .java files. This .java program is one half of the assignment,
 * which creates a file if none exists with the same name or appends to it if 
 * a file with the same name exists.  The companion file (findFile.java)
 * searches for a file, and displays the content of the file if it exists.
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class createFile {

    public static int[] generateIntArray() {
        Random random = new Random();
        int[] genArray = {0,0,0,0,0};
        int i = 0;
        while (i < 5) {
            genArray[i] = random.nextInt(99) + 1; // generates number between 1 and 99
            i++;
        }
        return genArray;
    }
    
    public static double[] generateDoubleArray() {
        Random random = new Random();
        double[] genArray = {0,0,0,0,0};
        int i = 0;
        double r1 = 0.0;
        double r2 = 0.0;
        while (i < 5) {
            r1 = random.nextDouble();
            r2 = Math.round(r1 * 100.0) / 100.0; // simplifying the double
            genArray[i] = r2;
            i++;
        }
        return genArray;
    }
    
    public static void testArrays(int[] x, double[] y) { // test function
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
    }

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter your name. This name will be used to generate a unique file.");
        String username = scanner.next();
        String completeFileName = username + " datafile.dat";
        
        int[] intArray = generateIntArray();
        double[] doubleArray = generateDoubleArray();
        // testArrays(intArray,doubleArray);
        
        try {
            File arrayFile = new File(completeFileName);
            
            if (arrayFile.exists()) {
                System.out.println("File already exists");
                
                FileWriter writer = new FileWriter(completeFileName, true); 
                // took me a while to realize i needed to clarify true here to append
                writer.write(Arrays.toString(intArray));
                writer.write("\n"); // used to put a newline in the .dat file
                writer.write(Arrays.toString(doubleArray));
                writer.write("\n"); // used to put a newline in the .dat file
                writer.close();

                System.out.println("Arrays appended to " + arrayFile.getName());
            } else {
                System.out.println("A file with that name does not exist");
                arrayFile.createNewFile();
                System.out.println("File Created: " + arrayFile.getName());
                
                FileWriter writer = new FileWriter(completeFileName, false); 
                // didn't need to include false but did just to be safe
                //writer.write("FILE EXISTS"); // used to test if anything could be written and read
                writer.write(Arrays.toString(intArray));
                writer.write("\n"); // used to put a newline in the .dat file
                writer.write(Arrays.toString(doubleArray));
                writer.write("\n"); // used to put a newline in the .dat file
                writer.close(); // i forgot to include the .close() command for so long and i am SO mad
                
                System.out.println("Arrays added to " + arrayFile.getName());
            }
        } catch(IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace(); // netbeans says this is unnecessary, but I included it for fun
        }
    }
}
