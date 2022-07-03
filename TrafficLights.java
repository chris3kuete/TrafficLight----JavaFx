/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficlights;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author sa
 */
public class TrafficLights extends Application {
    
    
     private double paneWidth=200;
    private double paneHeight=100;
    
    public void start(Stage primaryStage){
        
        
        BorderPane pane=new BorderPane();
        
        
        VBox pane1=new VBox(40);
        pane1.setPadding(new Insets(5,5,5,800));
        
        Circle red=new Circle(100,100,50);
        red.setFill(Color.WHITE);
        red.setStroke(Color.BLACK);
        
        Circle green=new Circle(100,100,50);
        green.setFill(Color.WHITE);
        green.setStroke(Color.BLACK);
        
        Circle yellow=new Circle(100,100,50);
        yellow.setFill(Color.WHITE);
        yellow.setStroke(Color.BLACK);
        
        Rectangle r1=new Rectangle(750,5,200,400);
        r1.setFill(Color.WHITE);
        r1.setStroke(Color.BLACK);
        pane.getChildren().add(r1);
        pane.setLeft(pane1);
        
        
        
        
        pane1.getChildren().addAll(red,green,yellow);
        pane.setLeft(pane1);
        
        
        HBox paneForRadioButtons=new HBox(100);
        paneForRadioButtons.setPadding(new Insets(5,10,5,700));
        paneForRadioButtons.setStyle("-fx-border-width: 2px; -fx-border-color:green");
        
        
        RadioButton Red=new RadioButton("Red");
        RadioButton Green=new RadioButton("Green");
        RadioButton Yellow=new RadioButton("Yellow");
        
        paneForRadioButtons.getChildren().addAll(Red,Green,Yellow);
        pane.setBottom(paneForRadioButtons);
        
        ToggleGroup group=new ToggleGroup();
        Red.setToggleGroup(group);
        Green.setToggleGroup(group);
        Yellow.setToggleGroup(group);
        
        
        Red.setOnAction(e -> {
            if (Red.isSelected()){
                red.setFill(Color.RED);
                green.setFill(Color.WHITE);
                yellow.setFill(Color.WHITE);
                r1.setFill(Color.TRANSPARENT);
            }
        });
        Green.setOnAction(e -> {
            if(Green.isSelected()){
                green.setFill(Color.GREEN);
                red.setFill(Color.WHITE);
                yellow.setFill(Color.WHITE);
                r1.setFill(Color.TRANSPARENT);
            }
        });
        Yellow.setOnAction(e ->{
            if (Yellow.isSelected()){
                yellow.setFill(Color.YELLOW);
                red.setFill(Color.WHITE);
                green.setFill(Color.WHITE);
                r1.setFill(Color.TRANSPARENT);
            }
        });
        
        Scene scene=new Scene(pane,400,200);
        primaryStage.setTitle("Exercise 16.03");
        primaryStage.setScene(scene);
        primaryStage.show();    
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
