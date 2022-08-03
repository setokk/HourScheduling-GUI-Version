package com.setokk.hourschedulinggui.splitter;

import java.util.ArrayList;
import java.util.List;

public class Splitter
{
    public static List<Double> convertTimesToDouble(String times)
    {
        List<Double> convertedTimes = new ArrayList<>();
        StringBuilder startHour = new StringBuilder();
        char nextHourChar = '/';

        for (int i = 0; i < times.length(); i++)
        {
            // Tells us whether there is another hour span for that person or not
            if (times.charAt(i) == nextHourChar)
            {
                convertedTimes.add(Double.parseDouble(startHour.toString()));

                startHour.delete(0, startHour.length());
            }

            boolean isNumber = (times.charAt(i) != ' ') && (times.charAt(i) != '/');

            // We are at the first half (start hour)
            if (times.charAt(i) == ':')
            {
                startHour.append(".");
            }
            else if (isNumber)
            {
                startHour.append(times.charAt(i));
            }
        }

        // Add the last hour
        if (times.length() == 0) // No hour was inserted
        {
            // Arbitrary hour value of -1 if a person can't attend at any hour for a specific day
            convertedTimes.add(-1.0);
        }
        else // There was at least one hour inserted to this cell
        {
            convertedTimes.add(Double.parseDouble(startHour.toString()));
        }

        return convertedTimes;
    }
}
