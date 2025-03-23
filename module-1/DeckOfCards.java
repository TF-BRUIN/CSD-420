package com.mycompany.csd420_asgnt01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;


/**
* Truman Forey - 3/23/25 - CSD 420 Assignment 12.2
* 
* This program is an experiment in JavaFX and using resources
* like .pngs in Java. This program randomly selects 4 cards out of
* a standard 52 card deck and displays them in JavaFX. It also creates
* a randomization button to repeat this process.
**/
public class DeckOfCards extends Application {

    Random rand = new Random();
    String routingString = "subdirectory1/AssignmentCards/";
    HBox containerBox = new HBox(20);
    VBox buttonBox = new VBox(15);
    Button rButton = new Button("Randomize Cards");
        
    List<Image> cardList = new ArrayList<>();
    List<ImageView> cardImageList = new ArrayList<>();
    // lots of lists weeeeeeeeeeeeeeeeeeeeeeee
        
    public String generateNumber() {
        int cardNum = rand.nextInt(52) + 1;
        String cardNumString = String.valueOf(cardNum);
        cardNumString = cardNumString.concat(".png");
        return cardNumString;
    }
    
    public void generateImages() {
        cardList.clear();
        cardImageList.clear();
        int c = 0;
        while (c < 52) {
            cardList.add(new Image(routingString.concat(generateNumber())));
            cardImageList.add(new ImageView(cardList.get(c)));
            // this is probably unnecessary if I knew more, but this was the
            // most straightforward way I could figure out how to do this
            c++;
        }
    }
    
    public int drawCard() { // this probably could've been simplified but I was way too tired by this point
        int drawNumber = rand.nextInt(cardImageList.size()-1); // plus I had to account for lists starting at 0 so eh
        return drawNumber;
    }
    
    public void constructScene() {
        containerBox.getChildren().clear();
        buttonBox.getChildren().clear();
        
        generateImages(); // this creates Objects for all 52 cards
        
        int d = 0;
        while (d < 4) {
            int dC = drawCard(); // uses a variable instead of just calling the method to make sure it was the same number
            containerBox.getChildren().add(cardImageList.get(dC));
            cardImageList.remove(dC);
            d++;  
            // had to get a bit creative to avoid a "added duplicate of same object" error
        }
        buttonBox.getChildren().add(containerBox);
        buttonBox.getChildren().add(rButton);
    }
    
    @Override
    public void start(Stage stage) {
        ///////////////////// BUTTON CODE, DO NOT TOUCH ///////////////////////////////////////////
        EventHandler<ActionEvent> randomizeCards;
        randomizeCards = (ActionEvent e) -> { constructScene(); }; // necessary lambda expression 
        rButton.setOnAction(randomizeCards);
        ///////////////////// BUTTON CODE, DO NOT TOUCH ///////////////////////////////////////////
        constructScene();
        
        containerBox.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);
        
        Scene compiledScene = new Scene(buttonBox,500,300);
        stage.setScene(compiledScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}