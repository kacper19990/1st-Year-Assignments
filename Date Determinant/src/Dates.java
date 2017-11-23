import java.util.Scanner;

public class Dates {
    /*public static int daysInMonth(int month)
    {
        switch (month)
        {
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("30");
                break;
            case 2:
                if(isLeapYear)
                    System.out.println("29");
                else
                    System.out.println("28");
                break;
            default:
                System.out.println("31");
                break;
        }

    }
    boolean validDate(String date)
    {
        Scanner format = new Scanner(date);
        format.useDelimiter("/");
        while(format.hasNext())
        {
            if(format.hasNextInt())
                continue;
            else
                return false;
        }
        return true;
    }
    boolean isLeapYear(int year)
    {

    }
    public static void main(String[] args)
    {
    }
    */
    public static void main(String[] args)
    {
        final String FORMAT = "DD/MM/YYYY";
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the date in the format " + FORMAT);
        if (input.hasNext()) {
            String fullDate = input.next();
            System.out.println(fullDate);
            input.useDelimiter("/");
            int day = input.nextInt();
            System.out.println("tete");
            System.out.println(day);
            System.out.println("tete");
            int month = input.nextInt();
            System.out.println(month);
            System.out.println("tete");
            int year = input.nextInt();
            System.out.println(year);
            System.out.println("tete");

        }

    }
}
