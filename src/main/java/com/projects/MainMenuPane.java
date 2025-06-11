package com.projects;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Pantalla de inicio del juego MemoryMath.
 * Permite seleccionar la dificultad y acceder al tablero de juego.
 */
public class MainMenuPane extends VBox {
    /**
     * Constructor que crea el menú principal con selección de dificultad.
     * Este constructor configura el layout (VBox) con un espaciado y alineación centrada, agrega un título (Label) y tres botones (FÁCIL, MEDIO, DIFÍCIL) que, al ser presionados, crean una instancia de GamePane con la dificultad correspondiente y cambian la raíz de la escena.
     * @param primaryStage Ventana principal de JavaFX
     */
    public MainMenuPane(Stage primaryStage) {
        setSpacing(30);
        setAlignment(Pos.CENTER);
        setStyle("-fx-background-color: #23A6AB;");

        Label title = new Label("MemoryMath");
        title.setFont(Font.font("Arial", 40));
        title.setTextFill(Color.web("#FFFFFF"));
        title.setStyle("-fx-font-weight: bold;");

        Button easyBtn = new Button("FÁCIL");
        easyBtn.setFont(Font.font("Arial", 24));
        easyBtn.setStyle("-fx-background-color: #FFF6E3; -fx-text-fill: #E07A2B; -fx-font-weight: bold; -fx-background-radius: 10; -fx-pref-width: 220; -fx-pref-height: 60;");
        easyBtn.setOnAction(e -> {
            GamePane gamePane = new GamePane(primaryStage, "FÁCIL");
            primaryStage.getScene().setRoot(gamePane);
        });

        Button mediumBtn = new Button("MEDIO");
        mediumBtn.setFont(Font.font("Arial", 24));
        mediumBtn.setStyle("-fx-background-color: #FFF6E3; -fx-text-fill: #3A8C6E; -fx-font-weight: bold; -fx-background-radius: 10; -fx-pref-width: 220; -fx-pref-height: 60;");
        mediumBtn.setOnAction(e -> {
            GamePane gamePane = new GamePane(primaryStage, "MEDIO");
            primaryStage.getScene().setRoot(gamePane);
        });

        Button hardBtn = new Button("DIFÍCIL");
        hardBtn.setFont(Font.font("Arial", 24));
        hardBtn.setStyle("-fx-background-color: #FFF6E3; -fx-text-fill: #4B5BA7; -fx-font-weight: bold; -fx-background-radius: 10; -fx-pref-width: 220; -fx-pref-height: 60;");
        hardBtn.setOnAction(e -> {
            GamePane gamePane = new GamePane(primaryStage, "DIFÍCIL");
            primaryStage.getScene().setRoot(gamePane);
        });

        getChildren().addAll(title, easyBtn, mediumBtn, hardBtn);
    }
} 