package com.setokk.hourschedulinggui.calculations;

import com.setokk.hourschedulinggui.csv.CSVReader;
import com.setokk.hourschedulinggui.csv.CSVWriter;
import com.setokk.hourschedulinggui.frequencycalculator.FrequencyCalculator;
import com.setokk.hourschedulinggui.guicontrollers.popupwindow.PopupWindow;
import com.setokk.hourschedulinggui.splitter.Splitter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Calculations
{
    private static int numberOfPeople = 0;

    public static void beginCalculations(File draggedFile, String resultPath) throws IOException
    {
        String path = draggedFile.getAbsolutePath();

        CSVReader.readCSVFile(path);
        List<List<String>> result = CSVReader.getResult().orElseThrow();

        List<List<Double>> convertedTimes = new ArrayList<>();

        // We ignore first row (Day names)
        for (int i = 1; i < result.size(); i++)
        {
            for (int j = 0; j < result.get(i).size(); j++)
            {
                String times = result.get(i).get(j);
                convertedTimes.add(Splitter.convertTimesToDouble(times));
            }
        }

        // Hour frequencies for each day
        List<HashMap<Double, Integer>> hourFrequencies = FrequencyCalculator.calculateHourFrequencies(convertedTimes);

        if (CSVWriter.writeCSVFile(hourFrequencies, resultPath))
        {
            PopupWindow.display("Result successfully created at:\n" + resultPath + "!");
        }
        else
        {
            PopupWindow.display("There was an error creating the result file.");
        }
    }

    public static int getNumberOfPeople() {
        return numberOfPeople;
    }

    public static void setNumberOfPeople(int numberOfPeople) {
        Calculations.numberOfPeople = numberOfPeople;
    }
}
