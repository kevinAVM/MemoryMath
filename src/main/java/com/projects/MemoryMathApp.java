package com.projects;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase principal que inicia la aplicación MemoryMath usando JavaFX.
 * Muestra el menú principal y gestiona el flujo entre pantallas.
 */
public class MemoryMathApp extends Application {
    /**
     * Inicia la aplicación y muestra la pantalla de menú principal.
     * Este método configura la ventana (Stage) de la aplicación, crea una instancia de MainMenuPane, y muestra la escena.
     * @param primaryStage Ventana principal de JavaFX
     */
    @Override
    public void start(Stage primaryStage) {
        MainMenuPane mainMenu = new MainMenuPane(primaryStage);
        Scene scene = new Scene(mainMenu, 400, 500);
        primaryStage.setTitle("MemoryMath");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Método principal. Lanza la aplicación JavaFX.
     * Este método es el punto de entrada de la aplicación y llama a launch(args) para iniciar el ciclo de vida de JavaFX.
     * @param args Argumentos de línea de comandos
     */
    public static void main(String[] args) {
        launch(args);
    }
} 