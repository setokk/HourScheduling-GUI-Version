package com.setokk.hourschedulinggui.csv;

public class CSVUtilities
{
    public static final String CSV_FILE_EXTENSION = ".csv";

    // Checks whether the file has the csv file extension once only or not
    // (if csv extension is included two times, we return false)
    public static boolean hasValidExtension(String filename)
    {
        return (filename.split(CSV_FILE_EXTENSION, -1).length - 1 == 1);
    }
}
