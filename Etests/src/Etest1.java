import java.util.Scanner;
import java.lang.Math;

public class Etest1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Pick a number closest to a number in a Fibonacci sequence:");
        int user = input.nextInt();

        int fN1 = 0;
        int fN2 = 1;
        boolean finished = false;

        do {
            int fN = 0;
            do
            {
                fN = fN1 + fN2;
                fN2 = fN1;
                fN1 = fN;
            }
            while (fN1 <= user);
            int fCompare1 = fN1;
            int fCompare2 = fN2;
            int fDiff1 = fCompare1 - user;
            int fDiff2 = fCompare2 - user;
            if(Math.abs(fDiff1) == Math.abs(fDiff2)) {
                System.out.println(fCompare2 + " " + fCompare1);
                finished = true;
            }
            else if ((Math.abs(fDiff1) < Math.abs(fDiff2)))
            {
                System.out.println(fCompare1);
                finished = true;
            }
            else
            {
                System.out.println(Math.abs(fCompare2));
                finished = true;
            }
        }
        while (!finished) ;
    }
}