package com.setokk.hourschedulinggui.guicontrollers.popupwindow;

import com.setokk.hourschedulinggui.RunApplication;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class PopupWindow
{
    public static void display(String message) throws IOException
    {
        Stage popupWindow = new Stage();

        popupWindow.initModality(Modality.APPLICATION_MODAL);
        popupWindow.setTitle("Prompt Message");
        popupWindow.centerOnScreen();
        popupWindow.setResizable(false);
        popupWindow.getIcons().add(new Image(Objects.requireNonNull(RunApplication.class.getResourceAsStream("/com/setokk/hourschedulinggui/icons/logoWindowIcon.png"))));

        AnchorPane pane = new AnchorPane();

        Label errorLabel = new Label(message);
        errorLabel.setFont(Font.font("KacstBook", FontWeight.NORMAL, 18));

        pane.getChildren().add(errorLabel);

        Scene scene = new Scene(pane, 400, 80);
        popupWindow.setScene(scene);
        popupWindow.showAndWait();
    }
}
