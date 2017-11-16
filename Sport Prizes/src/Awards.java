public class Awards
{
    public static void main(String[] args) {
        int players = 25;
        String list = "1st";
       for(int currentChecked = 2; (currentChecked <= players); currentChecked++)
       {
           boolean isPrime = true;
           for(int divisor =2; ((divisor <currentChecked) && (isPrime)); divisor++)
           {
               if (currentChecked%divisor == 0)
                   isPrime = false;
           }
           if (isPrime)
           {
               list = list + ", " + currentChecked;
               if (((currentChecked%100)/10) == 1)
                   list += "th";
               else
               {
                   switch (currentChecked%10)
                   {
                       case 1:
                           list+="st";
                           break;
                       case 2:
                           list+="nd";
                           break;
                       case 3:
                           list+="rd";
                           break;
                       default:
                           list+="th";
                           break;
                   }
               }
           }
       }
        System.out.println( list );
    }
}

