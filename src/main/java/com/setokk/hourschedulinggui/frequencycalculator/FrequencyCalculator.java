package com.setokk.hourschedulinggui.frequencycalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.setokk.hourschedulinggui.Main.TOTAL_DAYS_IN_WEEK;

public class FrequencyCalculator
{
    public static List<HashMap<Double, Integer>> calculateHourFrequencies(List<List<Double>> convertedTimes)
    {
        List<HashMap<Double, Integer>> hourFrequencies = new ArrayList<>();

        for (int i = 0; i < TOTAL_DAYS_IN_WEEK; i++)
        {
            hourFrequencies.add(new HashMap<>());
        }

        for (int i = 0; i < convertedTimes.size(); i++)
        {
            List<Double> convertedTime = convertedTimes.get(i);

            for (Double time : convertedTime)
            {
                if (!hourFrequencies.get(i % TOTAL_DAYS_IN_WEEK).containsKey(time))
                {
                    hourFrequencies.get(i % TOTAL_DAYS_IN_WEEK).put(time, 1);
                }
                else
                {
                    hourFrequencies.get(i % TOTAL_DAYS_IN_WEEK).put(time, hourFrequencies.get(i % TOTAL_DAYS_IN_WEEK).get(time) + 1);
                }
            }
        }

        return hourFrequencies;
    }
}