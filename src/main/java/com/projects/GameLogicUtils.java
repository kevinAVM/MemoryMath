package com.projects;

import java.util.*;

/**
 * Utilidades de lógica para MemoryMath (generación de pares, emparejamiento y evaluación).
 */
public class GameLogicUtils {
    /**
     * Genera los pares de operación y resultado según la dificultad.
     * @param difficulty Nivel de dificultad (FÁCIL, MEDIO, DIFÍCIL)
     * @param numPairs Número de pares a generar
     * @return Lista de pares [operación, resultado]
     */
    public static List<String[]> generatePairsByDifficulty(String difficulty, int numPairs) {
        List<String[]> pairs = new ArrayList<>();
        Random rand = new Random();
        if (difficulty.equals("FÁCIL")) {
            for (int i = 0; i < numPairs; i++) {
                int a = rand.nextInt(10) + 1;
                int b = rand.nextInt(10) + 1;
                if (rand.nextBoolean()) {
                    pairs.add(new String[]{a + " + " + b, String.valueOf(a + b)});
                } else {
                    int max = Math.max(a, b), min = Math.min(a, b);
                    pairs.add(new String[]{max + " - " + min, String.valueOf(max - min)});
                }
            }
        } else if (difficulty.equals("MEDIO")) {
            for (int i = 0; i < numPairs; i++) {
                int op = rand.nextInt(3);
                int a = rand.nextInt(10) + 1;
                int b = rand.nextInt(10) + 1;
                if (op == 0) {
                    pairs.add(new String[]{a + " + " + b, String.valueOf(a + b)});
                } else if (op == 1) {
                    int max = Math.max(a, b), min = Math.min(a, b);
                    pairs.add(new String[]{max + " - " + min, String.valueOf(max - min)});
                } else {
                    pairs.add(new String[]{a + " × " + b, String.valueOf(a * b)});
                }
            }
        } else { // DIFÍCIL
            for (int i = 0; i < numPairs; i++) {
                int op = rand.nextInt(4);
                int a = rand.nextInt(10) + 1;
                int b = rand.nextInt(9) + 2; // evitar división por 0 y 1
                if (op == 0) {
                    pairs.add(new String[]{a + " + " + b, String.valueOf(a + b)});
                } else if (op == 1) {
                    int max = Math.max(a, b), min = Math.min(a, b);
                    pairs.add(new String[]{max + " - " + min, String.valueOf(max - min)});
                } else if (op == 2) {
                    pairs.add(new String[]{a + " × " + b, String.valueOf(a * b)});
                } else {
                    int res = a * b;
                    pairs.add(new String[]{res + " ÷ " + b, String.valueOf(a)});
                }
            }
        }
        return pairs;
    }

    /**
     * Verifica si dos valores forman un par válido (operación y resultado).
     * @param a Operación o resultado
     * @param b Operación o resultado
     * @return true si forman un par correcto
     */
    public static boolean isPair(String a, String b) {
        try {
            if (a.contains("+")) return eval(a) == Integer.parseInt(b);
            if (b.contains("+")) return eval(b) == Integer.parseInt(a);
            if (a.contains("-")) return eval(a) == Integer.parseInt(b);
            if (b.contains("-")) return eval(b) == Integer.parseInt(a);
            if (a.contains("×")) return eval(a) == Integer.parseInt(b);
            if (b.contains("×")) return eval(b) == Integer.parseInt(a);
            if (a.contains("÷")) return eval(a) == Integer.parseInt(b);
            if (b.contains("÷")) return eval(b) == Integer.parseInt(a);
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /**
     * Evalúa una operación matemática en formato String.
     * @param op Operación (ej: "3 + 4")
     * @return Resultado entero de la operación
     */
    public static int eval(String op) {
        if (op.contains("+")) {
            String[] p = op.split(" \\+ ");
            return Integer.parseInt(p[0].trim()) + Integer.parseInt(p[1].trim());
        } else if (op.contains("-")) {
            String[] p = op.split(" - ");
            return Integer.parseInt(p[0].trim()) - Integer.parseInt(p[1].trim());
        } else if (op.contains("×")) {
            String[] p = op.split(" × ");
            return Integer.parseInt(p[0].trim()) * Integer.parseInt(p[1].trim());
        } else if (op.contains("÷")) {
            String[] p = op.split(" ÷ ");
            return Integer.parseInt(p[0].trim()) / Integer.parseInt(p[1].trim());
        }
        return 0;
    }
} 