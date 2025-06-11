package com.projects;

import java.io.IOException;
import javafx.fxml.FXML;

/**
 * Controlador de la vista secundaria en la aplicación JavaFX.
 */
public class SecondaryController {

    /**
     * Cambia a la vista primaria.
     * Este método se invoca al presionar un botón (por ejemplo, mediante un evento FXML) y llama a App.setRoot("primary") para cambiar la raíz de la escena a la vista primaria.
     * @throws IOException si ocurre un error al cargar la vista primaria
     */
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}