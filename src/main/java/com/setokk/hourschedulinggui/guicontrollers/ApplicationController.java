package com.setokk.hourschedulinggui.guicontrollers;

import com.setokk.hourschedulinggui.csv.CSVUtilities;
import com.setokk.hourschedulinggui.guicontrollers.popupwindow.PopupWindow;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static com.setokk.hourschedulinggui.calculations.Calculations.beginCalculations;

public class ApplicationController
{
    @FXML
    private AnchorPane dragPane;

    @FXML
    private Button saveButton;

    @FXML
    private Label pathToSaveLabel;

    @FXML
    private Button templateButton;

    private final DirectoryChooser directoryChooser = new DirectoryChooser();

    private String resultPath = "No Folder Selected";

    @FXML
    protected void handleDragOver(DragEvent dragEvent)
    {
        if (dragEvent.getDragboard().hasFiles())
        {
            dragEvent.acceptTransferModes(TransferMode.ANY);
        }

        dragPane.setStyle("-fx-opacity: 0.87;");
    }

    @FXML
    protected void handleDrop(DragEvent dragEvent) throws IOException
    {
        List<File> fileList = dragEvent.getDragboard().getFiles();

        if (fileList.size() != 1)
        {
            PopupWindow.display("Only 1 file is supported per drag.");
            dragPane.setStyle("-fx-opacity: 1;");
            return;
        }

        File draggedFile = fileList.get(0);
        if (!CSVUtilities.hasValidExtension(draggedFile.getName()))
        {
            PopupWindow.display("Invalid file extension.");
            dragPane.setStyle("-fx-opacity: 1;");
            return;
        }

        if (resultPath.equals("No Folder Selected"))
        {
            PopupWindow.display("No path selected to save the result.");
            return;
        }

        beginCalculations(draggedFile, resultPath);

        // Clear up
        dragEvent.getDragboard().clear();
        dragPane.setStyle("-fx-opacity: 1;");
    }

    @FXML
    protected void handleSaveButton() throws IOException
    {
        directoryChooser.setInitialDirectory(new File(System.getProperty("user.dir")));

       File selectedFolder = directoryChooser.showDialog(null);

        if (selectedFolder == null)
            return;

        resultPath = selectedFolder.getAbsolutePath();

        pathToSaveLabel.setText("Result will be saved at: " + resultPath);
    }

    @FXML
    protected void generateTemplateCSV() throws IOException
    {
        File templateFile = new File(System.getProperty("user.dir") + "/template.csv");

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(templateFile));
        bufferedWriter.write("Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday");
        bufferedWriter.close();

        PopupWindow.display("Template file generated at\n" + System.getProperty("user.dir") + "!");
    }
}
