package me.soknight.graalvm.sandbox;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public final class Main extends Application {

    @Override
    public void start(Stage stage) {
        Font font = Font.loadFont(getClass().getResourceAsStream("/assets/fonts/herralds.otf"), 20D);

        Button closeButton = new Button("Close Window");
        closeButton.setFont(font);
        closeButton.setStyle("-fx-text-fill: white; -fx-background-color: black; -fx-background-radius: 12px; -fx-padding: 20px 40px 20px 40px;");
        closeButton.setOnAction(e -> stage.close());

        VBox root = new VBox(closeButton);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: aquamarine; -fx-background-radius: 20px;");

        Scene scene = new Scene(root, 800D, 600D);

        // the app scene completely isn't visible on native run
        // I have temporary set white scene background to fix it :(
        scene.setFill(Color.WHITE);

        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();

        stage.centerOnScreen();
        stage.requestFocus();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
