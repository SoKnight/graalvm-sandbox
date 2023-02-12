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

    private static boolean instantClose;

    @Override
    public void start(Stage stage) {
        System.out.println("Hello world!");

        Module module = getClass().getModule();
        System.out.println("Current module is: " + (module.isNamed() ? module.getName() : "<unnamed>"));

        if (instantClose) {
            stage.close();
            return;
        }

        Font font = Font.loadFont(getClass().getResourceAsStream("/assets/fonts/herralds.otf"), 20D);

        Button closeButton = new Button("Close Window");
        closeButton.setFont(font);
        closeButton.setStyle("-fx-text-fill: white; -fx-background-color: black; -fx-background-radius: 12px; -fx-padding: 20px 40px 20px 40px;");
        closeButton.setOnAction(e -> stage.close());

        VBox root = new VBox(closeButton);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: aquamarine; -fx-background-radius: 20px;");

        Scene scene = new Scene(root, 800D, 600D);
        scene.setFill(Color.TRANSPARENT);

        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();

        stage.centerOnScreen();
        stage.requestFocus();
    }

    public static void main(String[] args) {
        instantClose = args.length != 0 && args[0].equalsIgnoreCase("--instant-close");
        Application.launch(args);
    }

}
