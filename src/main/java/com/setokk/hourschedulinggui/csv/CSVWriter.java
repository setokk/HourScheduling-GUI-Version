package com.setokk.hourschedulinggui.csv;

import com.setokk.hourschedulinggui.calculations.Calculations;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.*;

import static com.setokk.hourschedulinggui.Main.TOTAL_DAYS_IN_WEEK;

public final class CSVWriter
{
    public static final int RANDOM_ID_BOUND = 2000000;
    public static final int LOWER_ID_BOUND = 1000000;

    public static boolean writeCSVFile(List<HashMap<Double, Integer>> hourFrequencies, String resultPath)
    {
        boolean write_status = true; // True if no error occurred (return value of function)

        // Random id number
        Random rand = new Random(System.currentTimeMillis());

        // Create file
        File csvOutput = new File(resultPath + "/result - " + (rand.nextInt(RANDOM_ID_BOUND) + LOWER_ID_BOUND) + ".csv");

        // Write to file
        try
        {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(csvOutput));

            String splitBy = ",";

            for (int i = 0; i < TOTAL_DAYS_IN_WEEK; i++)
            {
                // Add the day name
                DayOfWeek day = DayOfWeek.of(i + 1);
                StringBuilder hours = new StringBuilder(day.getDisplayName(TextStyle.FULL, Locale.US) + splitBy);

                // Get the HashMap of each day
                HashMap<Double, Integer> currentHours = hourFrequencies.get(i);
                List<Double> keySet = new ArrayList<>(currentHours.keySet());

                // We append the hours, and we then we write them to the csv output file
                // because bufferedWriter.write() function writes in a line
                for (Double key : keySet)
                {
                    String stringKey = String.valueOf(key);
                    stringKey = stringKey.replace('.', ':');

                    if (stringKey.length() != 5)
                    {
                        stringKey += "0";
                    }

                    Integer frequency = currentHours.get(key);

                    if (key != -1)
                    {
                        double percentage;

                        if (Calculations.getNumberOfPeople() == 0)
                            percentage = 0;
                        else
                            percentage = ((double) frequency / (double) Calculations.getNumberOfPeople()) * 100;

                        if (frequency == 1)
                        {
                            hours.append(stringKey + " (" + frequency + " person - " + percentage + "%)" + splitBy);
                        }
                        else if (frequency != -1)
                        {
                            hours.append(stringKey + " (" + frequency + " people - " + percentage + "%)" + splitBy);
                        }
                    }

                    // We don't want to include splitBy for key == -1
                }

                hours.deleteCharAt(hours.length() - 1); // Delete last splitBy

                // Write the hours (new line to csv file)
                bufferedWriter.write(hours + "\n");
            }

            bufferedWriter.close();
        }
        catch (IOException e)
        {
            write_status = false;
        }

        return write_status;
    }
}
