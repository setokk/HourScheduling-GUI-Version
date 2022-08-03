package com.setokk.hourschedulinggui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RunApplication extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(RunApplication.class.getResource("application.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 700);

        stage.setTitle("CSV Hour Scheduling");
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/setokk/hourschedulinggui/icons/logoWindowIcon.png"))));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}