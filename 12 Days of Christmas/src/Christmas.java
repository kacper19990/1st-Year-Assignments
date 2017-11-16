/* SELF ASSESSMENT
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 5: 5
       Comment: Didn't use constants, could use them to refer to each day, but it comes out shorter this way.
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE?
       Mark out of 5: ?
       Comment: Decided to overwrite each line with the new line and the previous line.
   3. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
       Mark out of 10: 10
   4. Did I indent the code appropriately?
       Mark out of 10: 10
   5. Did I use an appropriate loop (or loops) to produce the different verses?
       Mark out of 20:  20
   6. Did I use a switch to build up the verses?
       Mark out of 25:  25
   7. Did I avoid duplication of code and of the lines which make up the verses (each line should be referred to in the code only once (or twice))?
       Mark out of 10:  10
   8. Does the program produce the correct output?
       Mark out of 10:  10
   9. How well did I complete this self-assessment?
       Mark out of 5: 4
   Total Mark out of 100 (Add all the previous marks): 94
*/


public class Christmas
{
    public static void main(String[] args)
    {
        String dayNumber= "first";                              //Initiates the day String
        String line = "a Partridge in a Pear Tree.";            //Sets the first line of the verse
        for(int day = 1; day <=12; day++)                       //The loop goes from day 1 to day 12
        {
            switch (day)                                        //Determines which day to go to based on the day
            {
                case 1:
                    break;
                case 2:
                    dayNumber = "second";
                    line = "2 Turtle Doves,\nand " + line;      //Adds the new line to the previous one, and prints the previous one on a new line
                    break;
                case 3:
                    dayNumber = "third";
                    line = "3 French Hens,\n" + line;
                    break;
                case 4:
                    dayNumber = "fourth";
                    line = "4 Calling Birds,\n" + line;
                    break;
                case 5:
                    dayNumber = "fifth";
                    line = "5 Golden Rings,\n" + line;
                    break;
                case 6:
                    dayNumber = "sixth";
                    line = "6 Geese a Laying\n" + line;
                    break;
                case 7:
                    dayNumber = "seventh";
                    line = "7 Swans a Swimming\n" + line;
                    break;
                case 8:
                    dayNumber = "eighth";
                    line = "8 Maids a Milking\n" + line;
                    break;
                case 9:
                    dayNumber = "ninth";
                    line = "9 Ladies Dancing\n" + line;
                    break;
                case 10:
                    dayNumber = "tenth";
                    line = "10 Lords a Leaping\n" + line;
                    break;
                case 11:
                    dayNumber = "eleventh";
                    line = "11 Pipers Piping\n" + line;
                    break;
                case 12:
                    dayNumber = "twelfth";
                    line = "12 Drummers Drumming\n" + line;
                    break;

            }
            String lyrics = "\nOn the " + dayNumber + " day of Christmas \nmy true love sent to me:\n" + line;  //First line where the day name changes
            System.out.println(lyrics);                             //Prints the lyrics each loop iteration.
        }
        System.out.println("\nMerry Christmas!\n" + "            \\ /"
        +"\n          -->*<--" + "\n            /_\\ \n           /_\\_\\ \n          /_/_/_\\ \n          /_\\_\\_\\" +
                "\n         /_/_/_/_\\ \n         /_\\_\\_\\_\\ \n        /_/_/_/_/_\\ \n        /_\\_\\_\\_\\_\\" +
                "\n       /_/_/_/_/_/_\\ \n       /_\\_\\_\\_\\_\\_\\ \n      /_/_/_/_/_/_/_\\ \n           [___]");
        //Above line prints a Christmas Tree.
    }
}

//Kacper Maczka 16/11/2017