import java.util.Scanner;

public class ChuckaLuck {


    public static void main(String[] args){

        Wallet wallet = new Wallet();
        Scanner input = new Scanner(System.in);
        boolean finished = false;
        double won;
        double moneyBet;
        double bet;

        System.out.println("How much money do you have?");
        if (input.hasNextDouble()) {
                wallet.put(input.nextDouble());
                System.out.print("\n" +
                        "Type of Bet:   \tCondition:\t\t\t\t\t\t\t\t\t\t\tPayout (Odds):\n" +
                        " \t \t \n" +
                        "Triple\t\t\tAll 3 dice show same number (but not 1s or 6s).\t\t30:1\n" +
                        "Field\t\t\tTotal of 3 dice < 8 or total is > 12.\t\t\t\t1:1\n" +
                        "High\t\t\tTotal of 3 dice > 10 (but not a Triple).\t\t\t1:1\n" +
                        "Low  \t\t\tTotal of 3 dice < 11 (but not a Triple).\t\t\t1:1\n");
            while(!finished) {
                finished = false;
                won = 0;
                moneyBet = 0;
                bet = 0;

                System.out.println("How much do you want to bet?");
                Scanner betS = new Scanner(System.in);
                if(betS.hasNextDouble()) {
                    bet = betS.nextDouble();
                    if (bet <= wallet.check() && wallet.check() > 0){
                        moneyBet += bet;
                        wallet.get(bet);
                        System.out.println("What type of bet would you like to place?");
                        Scanner betType = new Scanner(System.in);
                        if(betType.hasNext("Triple") || betType.hasNext("Field") || betType.hasNext("High") || betType.hasNext("Low")) {
                            String answer = betType.next();
                            if (answer.equals(diceRoll())) {
                                if (answer.equals("Triple")) {
                                    wallet.put(bet * 30);
                                    System.out.println("You won this round.\nYou now have: " + wallet.check());
                                    won += bet*30;
                                    System.out.println("Do you want to continue? Yes/No");
                                    if(input.hasNext("No")){
                                        endGame(won, moneyBet);
                                    }
                                }
                                else {
                                    wallet.put(bet);
                                    System.out.println("You won this round.\nYou now have: " + wallet.check());
                                    won = won + bet;
                                    System.out.println("Do you want to continue? Yes/No");
                                    Scanner answerS = new Scanner(System.in);
                                    if(answerS.hasNext("No")) {
                                        endGame(won, moneyBet);
                                    }
                                }

                            }
                            else {
                                System.out.println("Sorry, you lost this round. The dice made: " + diceRoll() + "\nYou now have:"  + wallet.check());
                                if(wallet.check() <= 0) {
                                    System.out.println("You have ran out of money");
                                    endGame(won, moneyBet);
                                }
                                System.out.println("Do you want to continue? Yes/No");
                                Scanner answerS = new Scanner(System.in);
                                if(answerS.hasNext("No")) {
                                    endGame(won, moneyBet);
                                }
                            }

                        }
                        else{
                            finished = invalidInput(won, moneyBet);
                        }
                    }
                    else{
                        System.out.println("Not enough money.");
                        endGame(won, moneyBet);
                    }
                }
                else{
                    finished = invalidInput(won, moneyBet);
                }

            }
        }
    }


    public static boolean invalidInput(double won, double bet){
        Scanner input = new Scanner(System.in);
        System.out.println("Invalid input. Try again? Yes/No");
        if (input.hasNext("Yes"))
            return false;
        else {
            endGame(won, bet);
            return true;
        }
    }

    public static String diceRoll(){
        Dice die1 = new Dice();
        Dice die2 = new Dice();
        Dice die3 = new Dice();

        die1.roll();
        die2.roll();
        die3.roll();

        int total = die1.topFace() + die2.topFace() + die3.topFace();

        if((((die1.topFace() == die2.topFace())) &&  (die1.topFace() == die3.topFace())) && (die1.topFace() != 1) && (die1.topFace() != 6) ){
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

    public static void endGame(double won, double bet){
        System.out.println("You summary of the game is:\nMoney Bet:\t " + bet + "\nMoney Won:\t" + won );
        System.exit(1);
    }
}
