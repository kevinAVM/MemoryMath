package com.projects;

/**
 * CardButton representa una carta del tablero de MemoryMath.
 * Puede mostrar una operación matemática o un resultado.
 * Hereda de Button de JavaFX y permite mostrar u ocultar su valor.
 */
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class CardButton extends Button {
    private String value;
    private boolean isRevealed = false;

    /**
     * Crea una carta con el valor dado (operación o resultado).
     * Este constructor inicializa la carta con el valor proporcionado, configura su estilo (fondo, radio, tamaño) y oculta su valor.
     * @param value Operación matemática o resultado que se mostrará en la carta
     */
    public CardButton(String value) {
        super("");
        this.value = value;
        setFont(Font.font("Arial", 12));
        setStyle("-fx-background-color: #FFF6E3; -fx-background-radius: 16; -fx-pref-width: 110; -fx-pref-height: 110;");
        hideValue();
    }

    /**
     * Muestra el valor de la carta en pantalla.
     * Este método actualiza el texto del botón con el valor de la carta y marca la carta como revelada.
     */
    public void showValue() {
        setText(value);
        isRevealed = true;
    }

    /**
     * Oculta el valor de la carta en pantalla.
     * Este método borra el texto del botón y marca la carta como no revelada.
     */
    public void hideValue() {
        setText("");
        isRevealed = false;
    }

    /**
     * Devuelve el valor de la carta.
     * Este método retorna el valor (operación o resultado) que contiene la carta.
     * @return valor (operación o resultado) que contiene la carta
     */
    public String getValue() {
        return value;
    }

    /**
     * Indica si la carta está revelada.
     * Este método retorna el estado de revelación de la carta.
     * @return true si la carta está revelada, false si está oculta
     */
    public boolean isRevealed() {
        return isRevealed;
    }
} 