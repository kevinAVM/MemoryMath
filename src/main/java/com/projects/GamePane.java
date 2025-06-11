package com.projects;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.*;

/**
 * GamePane es el tablero principal del juego MemoryMath.
 * Se encarga de generar las cartas, manejar la lógica de emparejamiento,
 * el temporizador, el score y mostrar la pantalla de resultados.
 *
 * Para pruebas unitarias, se recomienda testear los métodos generatePairsByDifficulty, isPair y eval.
 */
public class GamePane extends BorderPane {
    private Label scoreLabel;
    private Label levelLabel;
    private Label timerLabel;
    private GridPane boardGrid;
    private Stage primaryStage;
    private String difficulty;
    private int score = 0;
    protected int attempts = 0;
    private int pairsFound = 0;
    private int totalPairs;
    private int seconds = 0;
    private Timeline timer;
    private CardButton firstSelected = null;
    private CardButton secondSelected = null;
    private List<CardButton> allCards = new ArrayList<>();

    public GamePane(Stage primaryStage, String difficulty) {
        this.primaryStage = primaryStage;
        this.difficulty = difficulty;
        setStyle("-fx-background-color: #23A6AB;");

        // Top bar
        scoreLabel = new Label("Score: 0");
        scoreLabel.setFont(Font.font("Arial", 18));
        scoreLabel.setTextFill(Color.WHITE);
        levelLabel = new Label("Level 1");
        levelLabel.setFont(Font.font("Arial", 18));
        levelLabel.setTextFill(Color.WHITE);
        timerLabel = new Label("0:00");
        timerLabel.setFont(Font.font("Arial", 18));
        timerLabel.setTextFill(Color.WHITE);

        HBox topBar = new HBox(40, scoreLabel, levelLabel, timerLabel);
        topBar.setAlignment(Pos.CENTER);
        topBar.setPadding(new Insets(20, 0, 20, 0));

        // Board grid
        boardGrid = new GridPane();
        boardGrid.setAlignment(Pos.CENTER);
        boardGrid.setHgap(15);
        boardGrid.setVgap(15);
        boardGrid.setPadding(new Insets(10));

        setTop(topBar);
        setCenter(boardGrid);

        setupGame();
        startTimer();
    }

    private void setupGame() {
        int numPairs = 6;
        List<String[]> pairs = GameLogicUtils.generatePairsByDifficulty(difficulty, numPairs);
        totalPairs = pairs.size();
        List<String> values = new ArrayList<>();
        for (String[] pair : pairs) {
            values.add(pair[0]);
            values.add(pair[1]);
        }
        Collections.shuffle(values);
        int gridSize = (int) Math.ceil(Math.sqrt(values.size()));
        boardGrid.getChildren().clear();
        allCards.clear();
        int idx = 0;
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                if (idx >= values.size()) break;
                CardButton card = new CardButton(values.get(idx));
                card.setOnAction(e -> handleCardClick(card));
                boardGrid.add(card, col, row);
                allCards.add(card);
                idx++;
            }
        }
    }

    private void handleCardClick(CardButton card) {
        if (card.isRevealed() || secondSelected != null) return;
        card.showValue();
        if (firstSelected == null) {
            firstSelected = card;
        } else {
            secondSelected = card;
            attempts++;
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    javafx.application.Platform.runLater(() -> checkPair());
                }
            };
            new Timer().schedule(task, 800);
        }
    }

    private void checkPair() {
        if (firstSelected == null || secondSelected == null) return;
        String v1 = firstSelected.getValue();
        String v2 = secondSelected.getValue();
        if (GameLogicUtils.isPair(v1, v2)) {
            firstSelected.setDisable(true);
            secondSelected.setDisable(true);
            pairsFound++;
            score += 10;
        } else {
            firstSelected.hideValue();
            secondSelected.hideValue();
        }
        scoreLabel.setText("Score: " + score);
        firstSelected = null;
        secondSelected = null;
        if (pairsFound == totalPairs) {
            timer.stop();
            showResult();
        }
    }

    private void startTimer() {
        timer = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            seconds++;
            int min = seconds / 60;
            int sec = seconds % 60;
            timerLabel.setText(String.format("%d:%02d", min, sec));
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    private void showResult() {
        int maxScore = totalPairs * 10;
        int stars = 5;
        if (seconds > 120) stars = 3;
        else if (seconds > 90) stars = 4;
        else if (seconds > 60) stars = 4;
        else if (seconds > 40) stars = 5;
        if (attempts > totalPairs * 2) stars--;
        ResultPane resultPane = new ResultPane(primaryStage, stars, score, maxScore);
        primaryStage.getScene().setRoot(resultPane);
    }
} 