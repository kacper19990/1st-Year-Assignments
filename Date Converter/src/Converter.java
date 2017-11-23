import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Converter {
    public static final String FORMAT = "dd/MM/yyyy";
    public static final int MONTHS = 12;
    public static final int MONTHS_WITH_30_DAYS = 30;
    public static final int FEBRUARY_NORMAL = 28;
    public static final int FEBRUARY_LEAP = 29;
    public static final int OTHER_MONTHS = 31;

    private static String monthName(int month)
    {
        switch (month) {
            case 1:
                return ("January");
            case 2:
                return ("February");
            case 3:
                return ("March");
            case 4:
                return ("April");
            case 5:
                return ("May");
            case 6:
                return ("June");
            case 7:
                return ("July");
            case 8:
                return ("August");
            case 9:
                return ("September");
            case 10:
                return ("October");
            case 11:
                return ("November");
            case 12:
                return ("December");
        }
        return ("");
    }

    private static String numberEnding(int day)
    {
        int lastDigit = day % 10;
        switch (lastDigit) {
            case 1:
                if (day == 11)
                    return ("th");
                else
                    return ("st");
            case 2:
                if (day == 12)
                    return ("th");
                else
                    return ("nd");
            case 3:
                if (day == 13)
                    return ("th");
                else
                    return ("rd");
            default:
                return ("th");
        }
    }

    private static String dayOfTheWeek(int day, int month, int year)
    {
        if (month == 1 || month == 2)
            year = year - 1;
        int yearFirst = year / 100;
        int yearLast = year % 100;
        int determinant = (int) (day + Math.floor(2.6 * (((month + 9) % 12) + 1) - 0.2) + yearLast
                + Math.floor(yearLast / 4) + Math.floor(yearFirst / 4) - 2 * yearFirst) % 7;
        determinant = Math.abs(determinant);
        String dayInWords = "";
        switch (determinant) {
            case 0:
                dayInWords = "Sunday";
                break;
            case 1:
                dayInWords = "Monday";
                break;
            case 2:
                dayInWords = "Tuesday";
                break;
            case 3:
                dayInWords = "Wednesday";
                break;
            case 4:
                dayInWords = "Thursday";
                break;
            case 5:
                dayInWords = "Friday";
                break;
            case 6:
                dayInWords = "Saturday";
        }
        return (dayInWords);
    }

    private static boolean isLeapYear(int year)                         //From the validDate sample code
    {
        return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
    }

    private static boolean isValid(int day, int month, boolean isLeapYear)
    {
        if (month <= MONTHS) {
            switch (month) {
                case 4:
                case 6:
                case 9:
                case 11:
                    return (day <= MONTHS_WITH_30_DAYS);
                case 2:
                    if (isLeapYear && day <= FEBRUARY_LEAP)
                        return (true);
                    else if (day <= FEBRUARY_NORMAL)
                        return true;
                    else
                        return false;
                default:
                    return (day <= OTHER_MONTHS);
            }
        } else {
            return false;
        }
    }

    private static boolean validFormat(String input)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(FORMAT);
        if (input.trim().equals(""))
            return false;
        formatter.setLenient(false);
        try
        {
            formatter.parse(input);

        } catch (ParseException error)
        {
            return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        boolean finished = false;
        do
        {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the date in the format " + FORMAT + " or type 'exit' to leave.");
            if (input.hasNext("exit"))
            {
                finished = true;
            }
            else
            {
                String fullDate = input.next();
                if (validFormat(fullDate)) {
                    String[] numbers = fullDate.split("/");
                    int day = Integer.parseInt(numbers[0]);
                    int month = Integer.parseInt(numbers[1]);
                    int year = Integer.parseInt(numbers[2]);

                    String monthWord = monthName(month);
                    String dayEnd = numberEnding(day);
                    String dayWeek = dayOfTheWeek(day, month, year);
                    boolean leap = isLeapYear(year);
                    boolean validDate = isValid(day, month, leap);
                    boolean correctFormat = validFormat(fullDate);
                    if (validDate && correctFormat) {
                        System.out.println(dayWeek + " " + day + dayEnd + " of " + monthWord + " " + year);
                    } else {
                        System.out.println("Please enter a correct date");
                        finished = true;
                    }
                } else {
                    System.out.println("Please enter a correct date");

                }
            }
        }while (!finished);
    }
}