package com.setokk.hourschedulinggui.csv;

import com.setokk.hourschedulinggui.calculations.Calculations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public final class CSVReader
{
    private static List<List<String>> result;

    public static void readCSVFile(String name)
    {
        // Create new list
        result = new ArrayList<>();

        int numberOfPeople = 0;

        String line;
        String splitBy = ",";

        try
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(name));

            while ((line = bufferedReader.readLine()) != null)
            {
                result.add(Arrays.asList(line.split(splitBy, -1)));
                numberOfPeople++;
            }

            numberOfPeople--; // We disregard the first line ("Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday")
            Calculations.setNumberOfPeople(numberOfPeople);

            bufferedReader.close();
        }
        catch (IOException e)
        {
            System.out.println("The file " + "'" + name + "' was not found. Please try again.");
            System.exit(1);
        }
    }

    public static Optional<List<List<String>>> getResult()
    {
        return Optional.ofNullable(result);
    }
}
