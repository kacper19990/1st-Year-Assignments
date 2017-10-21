import javax.swing.JOptionPane;
import java.util.Scanner;
import java.lang.Math;

public class Loan_Payments {

    public static void main(String[] args) {
        String inputPrincipal = JOptionPane.showInputDialog("How much money did you borrow?");
        Scanner principal = new Scanner(inputPrincipal);

        if (principal.hasNextInt()) {
            int userPrincipal = principal.nextInt();
            principal.close();
            String length = JOptionPane.showInputDialog("How many years did you borrow it for?");
            Scanner year = new Scanner(length);
            if (year.hasNextInt()) {

                int years= year.nextInt();
                String annualInterest = JOptionPane.showInputDialog("What's the annual interest?");
                Scanner interest = new Scanner(annualInterest);
                if (interest.hasNextDouble()) {
                    double userInterest = interest.nextDouble();
                    userInterest = userInterest / 100;
                    interest.close();
                    double total = (userPrincipal * Math.exp((userInterest * years)));
                    total = total / (years * 12);
                    JOptionPane.showMessageDialog(null, "Your monthly payment is €" + String.format("%.02f", total) + " per month.");
                    }
                }
            }
        }
    }
