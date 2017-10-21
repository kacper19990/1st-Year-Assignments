import javax.swing.JOptionPane;
import java.lang.Math;

public class WindChill
{
    public static void main(String args[])
    {
        String temperature = JOptionPane.showInputDialog("Temperature in Fahrenheit:");
        double t = Double.parseDouble(temperature);

        if((t < Math.abs(50)))
        {
            String windUser = JOptionPane.showInputDialog("Wind Speed in MPH:");
            double v = Double.parseDouble(windUser);

            if(v < 120 && v > 3)
            {
                double w = 35.74 + (0.6125 * t) + ((0.4275 * t) -35.75) * Math.pow(v, 0.16);
                JOptionPane.showMessageDialog(null, "Wind chill equals to: " + String.format("%.02f", w));
            }
        }
    }
}
