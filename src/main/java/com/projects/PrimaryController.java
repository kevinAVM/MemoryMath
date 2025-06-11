package com.projects;

import java.io.IOException;
import javafx.fxml.FXML;

/**
 * Controlador de la vista primaria en la aplicación JavaFX.
 */
public class PrimaryController {

    /**
     * Cambia a la vista secundaria.
     * Este método se invoca al presionar un botón (por ejemplo, mediante un evento FXML) y llama a App.setRoot("secondary") para cambiar la raíz de la escena a la vista secundaria.
     * @throws IOException si ocurre un error al cargar la vista secundaria
     */
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
