import java.util.Scanner;
import javax.swing.JOptionPane;
import java.lang.Math;


public class Minus_b
{
    public static void main(String[] args)
    {
        boolean loop = true;
        do
        {
            String equationInput = JOptionPane.showInputDialog("Enter the coefficients of your second order polynomial separated by spaces (or enter quit):");
            Scanner equation = new Scanner(equationInput);

            if(equation.hasNext("quit"))
            {
                JOptionPane.showMessageDialog(null, "Goodbye.");
                break;
            }
            else if(equation.hasNextInt())
            {
                equation.useDelimiter(" ");
                int a = equation.nextInt();
                int b = equation.nextInt();
                int c = equation.nextInt();
                double answerPlus = (-b + Math.sqrt((Math.pow(b, 2) - 4 * a * c))) / (2*a);
                double answerMinus = (-b - Math.sqrt((Math.pow(b, 2) - 4 * a * c))) / (2*a);
                //JOptionPane.showMessageDialog(null, "X = " + answerPlus + " and X = " + answerMinus);
                String total = String.format("X = %4.3f and X = %4.3f", answerMinus, answerPlus);
                JOptionPane.showMessageDialog(null, total);

                loop = false;
            }
        }
        while(loop);
    }
}
