import java.util.Scanner;

public class Loops1
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        for(int i = 1; (i <=10); i++)
        {
        int total = N * i;
        System.out.println(N + " x " + i + " = " + total);
        }
    }
}
