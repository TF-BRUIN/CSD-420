/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csd420_asgnt02;

/**
 * Refer to the createFile file to read the description of this assignment
 * 
 * I put like a quarter of the effort I put into that file into this one
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class findFile {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter your name. This name will be used to search for files.");
        String username = scanner.next();
        String completeFileName = username + " datafile.dat";
        
        try {
            File readingFile = new File(completeFileName);
            Scanner fileReader = new Scanner(readingFile);
            // int i = 1; // test stuff
            while (fileReader.hasNextLine()) {
                // System.out.println("Line " + i + ":"); // test stuff
                String info = fileReader.nextLine();
                System.out.println(info);
                // i++; // test stuff
            }
        } catch (FileNotFoundException e) {
            System.out.println("That file could not be found.");
            e.printStackTrace();
        }
    }
}
