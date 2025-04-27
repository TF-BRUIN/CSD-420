package com.mycompany.csd420_asgnt07;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * JavaFX App
 */
public class csd420_asgnt07 extends Application {

    private static Scene scene;

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(csd420_asgnt07.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////
    // I DUNNO IF ANY OF THE ABOVE CODE IS NEEDED, BUT I DECIDED NOT TO TOUCH IT, JUST TO BE SAFE //
    ////////////////////////////////////////////////////////////////////////////////////////////////
    
    @Override
    public void start(Stage stage) throws IOException {
        
        //scene = new Scene(loadFXML("primary"), 640, 480);
        HBox holdingBox = new HBox(5);
        holdingBox.setAlignment(Pos.CENTER);
        
        
        scene = new Scene(holdingBox, 500, 750);
        scene.getStylesheets().add(getClass().getResource("/css_sheet.css").toExternalForm());
        
        //Rectangle rectangle = new Rectangle(125, 450);
        //rectangle.getStyleClass().add("plaincircle");
        //rectangle.getStyleClass().add("plaincircle");
        
        Circle circle01 = new Circle(50);
        circle01.getStyleClass().add("plaincircle");
        
        Circle circle02 = new Circle(50);
        circle02.getStyleClass().add("plaincircle");
        
        Circle circle03 = new Circle(50);
        circle03.setId("redcircle");
        
        Circle circle04 = new Circle(50);
        circle04.setId("greencircle");
        
        StackPane stack = new StackPane();
        stack.getChildren().addAll(circle01);
        stack.getStyleClass().add("border");
        
        holdingBox.getChildren().add(stack);
        holdingBox.getChildren().add(circle02);
        holdingBox.getChildren().add(circle03);
        holdingBox.getChildren().add(circle04);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}