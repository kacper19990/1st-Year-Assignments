import java.util.Scanner;

public class ChuckaLuck {




    public static void main(String[] args){

        Wallet wallet = new Wallet();
        Scanner input = new Scanner(System.in);
        boolean finished = false;

        while(!finished) {
            System.out.println("How much money do you have?");
            if (input.hasNextDouble()) {
                wallet.put(input.nextDouble());
                System.out.print("\n" +
                        "Type of Bet:   \tCondition:\tPayout (Odds):\n" +
                        " \t \t \n" +
                        "Triple\tAll 3 dice show same number (but not 1s or 6s).\t30:1\n" +
                        "Field\tTotal of 3 dice < 8 or total is > 12.\t1:1\n" +
                        "High\tTotal of 3 dice > 10 (but not a Triple).\t1:1\n" +
                        "Low\tTotal of 3 dice < 11 (but not a Triple).\t1:1");

                if(input.hasNext("Triple") || input.hasNext("Field") || input.hasNext("High") || input.hasNext("Low")){
                    String answer = input.next();
                    if(answer == diceRoll()){

                    }




            }
            else{
               finished = invalidInput();
                }

            }
        }
    }

    public static boolean invalidInput(){
        Scanner input = new Scanner(System.in);
        System.out.println("Invalid input. Try again?");
        return !input.hasNext("Yes");
    }
    public static String diceRoll(){
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        Dice dice3 = new Dice();

        dice1.roll();
        dice2.roll();
        dice3.roll();

        int total = dice1.topFace() + dice2.topFace() + dice3.topFace();

        if((((dice1.topFace() == dice2.topFace())) &&  (dice1.topFace() == dice3.topFace())) && (dice1.topFace() != 1) && (dice1.topFace() != 6) ){
            return "Triple";

        }
        else if((total < 8) || (total > 12)){
            return "Field";

        }
        else if ((total > 10)){
            return "High";

        }
        else{
            return "Low";

        }
    }
}
