import java.util.Scanner;

public class Ernests {

    public static int[] createSequence(int inputN)
    {
        int[] intSequence = new int[inputN - 1];
        for (int currentInt = 2, index = 0; currentInt <= inputN; currentInt++, index++)
        {
            intSequence[index] = currentInt;
        }
        return intSequence;
    }

    public static void crossOutHigherMultiples(int[] intSequence, int factorN)
    {
        if (intSequence != null)
        {
            boolean hasMultiple = false;
            for ( int index = factorN - 1 ; index < intSequence.length; index++)
            {
                if (intSequence[index]%factorN == 0 && intSequence[index] != 0)
                {
                    intSequence[index] = 0;
                    hasMultiple = true;

                }
            }
            if (hasMultiple)
            {
                System.out.println(sequenceToString(intSequence));
            }
        }
    }

    public static int[] sieve(int inputN)
    {
        int[] intSequence = createSequence(inputN);
        crossOutHigherMultiples(intSequence, 2);
        for (int factorInt = 3 ; factorInt < intSequence.length; factorInt+=2)
        {
            crossOutHigherMultiples(intSequence, factorInt);
        }
        return intSequence;
    }

    public static String sequenceToString(int[] intSequence)
    {
        String stringSequence = "";
        if (intSequence != null)
        {
            for(int index = 0; index < intSequence.length; index++)
            {
                if (intSequence[index] == 0)
                {
                    stringSequence += "[" + String.valueOf(index + 2) + "]" + (index < intSequence.length-1 ?  ", ":  "");
                }
                else
                {
                    stringSequence += intSequence[index] + (index < intSequence.length-1 ?  ", ":  "");
                }
            }
            return stringSequence;
        }
        return stringSequence;
    }

    public static String nonCrossedOutSubseqToString(int[] intSequence)
    {
        String stringSequence = "";
        for(int index = 0; index < intSequence.length; index++)
        {
            if(intSequence[index] != 0)
            {
                stringSequence += ((intSequence.length > index+1) ? ((intSequence[index+1] == 0) ?  ", ":  "" ) : ", ") +  intSequence[index];
            }
        }
        return stringSequence;
    }

    public static void main(String[] args) {


        while (true)
        {
            System.out.println("Enter an integer thats greater or equal to 2.");
            Scanner inputScanner = new Scanner(System.in);
            int numberN = inputScanner.nextInt();
            if (numberN < 2 )
            {
                System.out.println("Only integer 2 and over are allowed for input");
            }
            else
            {
                int[] primeNumbers = sieve(numberN);
                System.out.println(nonCrossedOutSubseqToString(primeNumbers));
            }
        }
    }

}
