package com.mycompany.csd420_asgnt10;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.sql.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

/**
 * Truman Forey | 5/11/25 | CSD 420 Module 10.2 Assignment
 * 
 * This program is an advanced experiment about combining JavaFX with
 * MySQL, using JDBC. Note that this program requires a proper MySQL database to
 * function.
 */
public class mySQLDisplayAndUpdate extends Application {
    
    @Override
    public void start(Stage stage) {
        //var javaVersion = SystemInfo.javaVersion();
        //var javafxVersion = SystemInfo.javafxVersion();
        //var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        
        var label01 = new Label("This is a program that searches for information within a MySQL database, using the following information:");
        var label02 = new Label("|| Database: databasedb || User: student1 || Password: pass || Table: fans ||");
        //var label03 = new Label("User: student1"); // condensed explanation
        //var label04 = new Label("Password: pass");
        //var label05 = new Label("Table: fans");
        var label06 = new Label("If you do not have that information available, this program will not work.");
        
        var labelHoldingBox = new VBox(2);
        labelHoldingBox.setAlignment(Pos.CENTER);
        labelHoldingBox.getChildren().add(label01);
        labelHoldingBox.getChildren().add(label02);
        //labelHoldingBox.getChildren().add(label03); // simplified the text
        //labelHoldingBox.getChildren().add(label04);
        //labelHoldingBox.getChildren().add(label05);
        labelHoldingBox.getChildren().add(label06);
        
        var getRecordsLabelTop = new Label("DISPLAY RECORDS");
        var getRecordsLabel = new Label("Enter the ID number of the record (1-10) you would like to display.");
        var getRecordsField = new TextField();
        var getRecordsButton = new Button("Display Record");
        var getRecordsResult = new Label("");
        
        var vboxGetRecords = new VBox(2);
        vboxGetRecords.setAlignment(Pos.CENTER);
        vboxGetRecords.getChildren().add(getRecordsLabelTop);
        vboxGetRecords.getChildren().add(getRecordsLabel);
        vboxGetRecords.getChildren().add(getRecordsField);
        vboxGetRecords.getChildren().add(getRecordsButton);
        vboxGetRecords.getChildren().add(getRecordsResult);
        
        var setRecordsLabelTop = new Label("UPDATE RECORDS");
        var setRecordsLabel_01 = new Label("Enter the ID number of the record (1-10) you would like to update.");
        var setRecordsField_01 = new TextField(); // I considered making the text fields not stretch to the sides of the window, 
                                                    //but tbh the program still functions fine as-is and also I don't care
        var setRecordsLabel_02 = new Label("Select which field you would like to update.");
        var setRadioButton_01 = new RadioButton("First Name");
        var setRadioButton_02 = new RadioButton("Last Name");
        var setRadioButton_03 = new RadioButton("Favorite Team");
        var setRecordsLabel_03 = new Label("Enter the new value of the record.");
        var setRecordsField_02 = new TextField();
        var setRecordsButton = new Button("Update Record");
        var setRecordsResult = new Label("");
        
        var radioButtons = new ToggleGroup();
        setRadioButton_01.setToggleGroup(radioButtons);
        setRadioButton_02.setToggleGroup(radioButtons);
        setRadioButton_03.setToggleGroup(radioButtons);

        var vboxRadioButtons = new VBox();
        vboxRadioButtons.setAlignment(Pos.CENTER);
        vboxRadioButtons.getChildren().add(setRadioButton_01);
        vboxRadioButtons.getChildren().add(setRadioButton_02);
        vboxRadioButtons.getChildren().add(setRadioButton_03);
        
        var vboxSetRecords = new VBox(2);
        vboxSetRecords.setAlignment(Pos.CENTER);
        vboxSetRecords.getChildren().add(setRecordsLabelTop);
        vboxSetRecords.getChildren().add(setRecordsLabel_01);
        vboxSetRecords.getChildren().add(setRecordsField_01);
        vboxSetRecords.getChildren().add(setRecordsLabel_02);
        vboxSetRecords.getChildren().add(vboxRadioButtons);
        vboxSetRecords.getChildren().add(setRecordsLabel_03);
        vboxSetRecords.getChildren().add(setRecordsField_02);
        vboxSetRecords.getChildren().add(setRecordsButton);
        vboxSetRecords.getChildren().add(setRecordsResult);
        
        var labelBLANK = new Label("");
        VBox totalHoldingBox = new VBox(25);
        totalHoldingBox.setAlignment(Pos.CENTER);
        totalHoldingBox.getChildren().add(labelHoldingBox);
        totalHoldingBox.getChildren().add(labelBLANK);
        totalHoldingBox.getChildren().add(vboxGetRecords);
        //totalHoldingBox.getChildren().add(labelBLANK); // this caused an error when I added it, just decided to remove it
        totalHoldingBox.getChildren().add(vboxSetRecords);
        
        try {
            String url = "jdbc:mysql://localhost:3306/databasedb?user=student1&password=pass";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, // I spent way too long realized I needed to add both of these instead of just the 2nd one haaaaaaa
                    ResultSet.CONCUR_UPDATABLE
            );
            // recycled some of this code from 'Select5.java' in order to make sure I was using correct code, 
            // though I did change it slightly to make it more comfortable for me to use

            try {
                EventHandler<ActionEvent> getRecords = new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        try {
                            //int getIDNum = Integer.parseInt(getRecordsField.getText()); // wrong code before I realized it needed to be a string anyways
                            String getIDNum = getRecordsField.getText();
                            ResultSet results = statement.executeQuery("SELECT * FROM fans WHERE ID IN (" + getIDNum + ")");
                            String firstName = null;
                            String lastName = null;
                            String favoriteTeam = null;

                            while (results.next()) {
                                firstName = results.getString("FIRSTNAME");
                                lastName = results.getString("LASTNAME");
                                favoriteTeam = results.getString("FAVORITETEAM");
                            }
                            getRecordsResult.setText("|| First Name: " + firstName + " || Last Name: " + lastName + 
                                " || Favorite Team: " + favoriteTeam + " ||");
                            results.close();
                        } catch (Exception e) {
                            getRecordsResult.setText("Error Encountered. Please enter a proper input.");
                            //e.printStackTrace(); // testing code
                        }
                    }
                };
                getRecordsButton.setOnAction(getRecords);
                
                EventHandler<ActionEvent> setRecords = new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        try {
                            String setIDNum = setRecordsField_01.getText();
                            String setNewValue = setRecordsField_02.getText();
                            ResultSet results = statement.executeQuery("SELECT * FROM fans WHERE ID IN (" + setIDNum + ")");
                            
                            //if (setNewValue == "") {
                            //    throw new IllegalArgumentException("Must Enter A New Value");
                            //} // was gonna make sure no field was blank, but it's not a big deal if it is tbh
                            
                            if (results.next()) {
                                if (setRadioButton_01.isSelected()) {
                                    results.updateString("FIRSTNAME",setNewValue);
                                } else if (setRadioButton_02.isSelected()) {
                                    results.updateString("LASTNAME",setNewValue);
                                } else if (setRadioButton_03.isSelected()) {
                                    results.updateString("FAVORITETEAM",setNewValue);
                                } else {
                                    throw new IllegalArgumentException("No Radio Button Accepted");
                                }
                            }
                            
                            results.updateRow();
                            setRecordsResult.setText("Record successfully updated.");
                            results.close();
                        } catch (Exception e) {
                            setRecordsResult.setText("Error Encountered. Please enter a proper input.");
                            //e.printStackTrace(); // testing code
                        }
                    }
                };
                setRecordsButton.setOnAction(setRecords);

                var scene = new Scene(new StackPane(totalHoldingBox), 600, 540);
                stage.setScene(scene);
                stage.show();
            
            } catch (Exception e) {
                System.out.println("Error: Erroe encountered."); // lol erroe
            } finally {
                //connection.close();
                //statement.close(); // tried to make sure these were properly closed, but was unable to make it close properly whiel letting the program run normally
            }
            
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Class Not Found Exception.");
            System.exit(0);
        } catch (SQLException e01) {
            System.out.println("Error: SQL Exception.");
            System.exit(0);
        } catch (Exception e00) {
            System.out.println("Error: Unknown Error Occured.");
            //e00.printStackTrace();
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        launch();
    }

}