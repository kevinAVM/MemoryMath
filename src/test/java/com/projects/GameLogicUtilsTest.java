package com.projects;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la lógica de GameLogicUtils.
 *
 * Para ejecutar las pruebas:
 * 1. Asegúrate de tener Maven y JUnit configurados (ya está en el pom.xml).
 * 2. Ejecuta: mvn test
 *
 * Las pruebas validan la generación de pares, la lógica de emparejamiento y la evaluación de operaciones.
 */
public class GameLogicUtilsTest {
    @Test
    void testGeneratePairsByDifficulty() {
        List<String[]> easy = GameLogicUtils.generatePairsByDifficulty("FÁCIL", 6);
        assertEquals(6, easy.size());
        List<String[]> medium = GameLogicUtils.generatePairsByDifficulty("MEDIO", 6);
        assertEquals(6, medium.size());
        List<String[]> hard = GameLogicUtils.generatePairsByDifficulty("DIFÍCIL", 6);
        assertEquals(6, hard.size());
    }

    @Test
    void testIsPair() {
        assertTrue(GameLogicUtils.isPair("3 + 4", "7"));
        assertTrue(GameLogicUtils.isPair("7", "3 + 4"));
        assertTrue(GameLogicUtils.isPair("9 - 2", "7"));
        assertTrue(GameLogicUtils.isPair("7", "9 - 2"));
        assertTrue(GameLogicUtils.isPair("3 × 4", "12"));
        assertTrue(GameLogicUtils.isPair("12", "3 × 4"));
        assertTrue(GameLogicUtils.isPair("12 ÷ 4", "3"));
        assertTrue(GameLogicUtils.isPair("3", "12 ÷ 4"));
        assertFalse(GameLogicUtils.isPair("3 + 4", "8"));
    }

    @Test
    void testEval() {
        assertEquals(7, GameLogicUtils.eval("3 + 4"));
        assertEquals(1, GameLogicUtils.eval("5 - 4"));
        assertEquals(12, GameLogicUtils.eval("3 × 4"));
        assertEquals(3, GameLogicUtils.eval("12 ÷ 4"));
    }
} 