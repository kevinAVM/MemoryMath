package com.projects;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ResultPane extends VBox {
    public ResultPane(Stage primaryStage, int stars, int score, int maxScore) {
        setAlignment(Pos.CENTER);
        setSpacing(30);
        setStyle("-fx-background-color: #23A6AB;");

        Label congrats = new Label("¡Felicidades!");
        congrats.setFont(Font.font("Arial", 36));
        congrats.setTextFill(Color.WHITE);
        congrats.setStyle("-fx-font-weight: bold;");

        HBox starsBox = new HBox(10);
        starsBox.setAlignment(Pos.CENTER);
        for (int i = 1; i <= 5; i++) {
            Label star = new Label(i <= stars ? "★" : "☆");
            star.setFont(Font.font("Arial", 36));
            star.setTextFill(Color.web("#FFD600"));
            starsBox.getChildren().add(star);
        }

        Label scoreLabel = new Label("Calificación: " + score + " de " + maxScore);
        scoreLabel.setFont(Font.font("Arial", 22));
        scoreLabel.setTextFill(Color.WHITE);

        Button backBtn = new Button("Volver al menú");
        backBtn.setFont(Font.font("Arial", 18));
        backBtn.setStyle("-fx-background-color: #FFF6E3; -fx-text-fill: #4B5BA7; -fx-font-weight: bold; -fx-background-radius: 10; -fx-pref-width: 180; -fx-pref-height: 40;");
        backBtn.setOnAction(e -> {
            MainMenuPane menu = new MainMenuPane(primaryStage);
            primaryStage.getScene().setRoot(menu);
        });

        getChildren().addAll(congrats, starsBox, scoreLabel, backBtn);
    }
} 