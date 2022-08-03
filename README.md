# HourScheduling-GUI-Version
#### HourScheduling is a simple app that facilitates the process of finding the best hours and days for a meeting to take place for a large number of people.
![alt text](https://i.postimg.cc/2yVxDTpS/app.png)

## Using the app
- ### Input File
#### The input csv file should look like this:
Monday | Tuesday | Wednesday | Thursday | Friday | Saturday | Sunday
---    | ---     | ---       | ---      | ---    | ---      | ---
19:00/13:00 | 15:00 | | | 11:00 | 
15:00 | | |19:00 |12:00/11:00 |
15:00 | | | | 11:00/13:00 |
16:00 | | | 19:00 | |
#### where each row represents a person and the hours they can attend a meeting.
#### (there is also an option of generating this template input file automatically)

## Requirements
This project requires:
* Java SE Development Kit 17.0.1 and above which can be found here: https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
* JavaFX which can be found here: https://openjfx.io/

## Running the app
````java -jar HourSchedulingGUI.jar```` 
#### is all that is needed to run the app.
#### - The app runs in Windows only for now (due to JavaFX modules). Linux versions will be released in the future.

## Importing project on IDE
This project is an IntelliJ IDEA JavaFX project.