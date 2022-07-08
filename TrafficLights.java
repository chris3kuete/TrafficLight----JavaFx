/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficlights;

import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author sa
 */
public class TrafficLights extends Application implements Runnable {

    private double paneWidth = 200;
    private double paneHeight = 100;

    @Override
    public void start(Stage primaryStage) {

        BorderPane pane = new BorderPane();

        VBox pane1 = new VBox(40);
        pane1.setPadding(new Insets(5, 5, 5, 800));

        Circle red = new Circle(100, 100, 50);
        red.setFill(Color.WHITE);
        red.setStroke(Color.BLACK);

        Circle green = new Circle(100, 100, 50);
        green.setFill(Color.WHITE);
        green.setStroke(Color.BLACK);

        Circle yellow = new Circle(100, 100, 50);
        yellow.setFill(Color.WHITE);
        yellow.setStroke(Color.BLACK);

        Rectangle r1 = new Rectangle(750, 5, 200, 400);
        r1.setFill(Color.WHITE);
        r1.setStroke(Color.BLACK);
        pane.getChildren().add(r1);
        pane.setLeft(pane1);

        pane1.getChildren().addAll(red, green, yellow);
        pane.setLeft(pane1);

        HBox paneForRadioButtons = new HBox(100);
        paneForRadioButtons.setPadding(new Insets(5, 10, 5, 700));
        paneForRadioButtons.setStyle("-fx-border-width: 2px; -fx-border-color:green");

        RadioButton Red = new RadioButton("Red");
        RadioButton Green = new RadioButton("Green");
        RadioButton Yellow = new RadioButton("Yellow");
        RadioButton allRadio = new RadioButton("Automatic");

        paneForRadioButtons.getChildren().addAll(Red, Green, Yellow, allRadio);
        pane.setBottom(paneForRadioButtons);

        ToggleGroup group = new ToggleGroup();
        Red.setToggleGroup(group);
        Green.setToggleGroup(group);
        Yellow.setToggleGroup(group);
        allRadio.setToggleGroup(group);

        Red.setOnAction(e -> {
            if (Red.isSelected()) {
                red.setFill(Color.RED);
                green.setFill(Color.WHITE);
                yellow.setFill(Color.WHITE);
                r1.setFill(Color.TRANSPARENT);
            }
        });
        Green.setOnAction(e -> {
            if (Green.isSelected()) {
                green.setFill(Color.GREEN);
                red.setFill(Color.WHITE);
                yellow.setFill(Color.WHITE);
                r1.setFill(Color.TRANSPARENT);
            }
        });
        Yellow.setOnAction(e -> {
            if (Yellow.isSelected()) {
                yellow.setFill(Color.YELLOW);
                red.setFill(Color.WHITE);
                green.setFill(Color.WHITE);
                r1.setFill(Color.TRANSPARENT);
            }
        });

        allRadio.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent Event) {
                Thread th = new Thread() {
                    @Override
                    public void run() {
                        try {
                            while (green.getFill() != Color.ALICEBLUE) {
                                green.setFill(Color.GREEN);
                                Thread.sleep(5000L);
                                green.setFill(Color.WHITE);

                                yellow.setFill(Color.YELLOW);
                                Thread.sleep(5000L);
                                yellow.setFill(Color.WHITE);

                                red.setFill(Color.RED);
                                Thread.sleep(5000L);
                                red.setFill(Color.WHITE);
                            }

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                th.start();
            }

        });

        Scene scene = new Scene(pane, 400, 200);
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

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
