import java.util.Scanner;
import java.util.Objects;
import java.util.Random;

public class Cipher{

    public static final int ALPHABET_START = 97;

    public static void main(String[] args){
        boolean quit = false;

        while(!quit){
            System.out.print("What would you like to encrypt: ");
            Scanner input = new Scanner(System.in);
            String inputString = input.nextLine();

            if(Objects.equals(inputString, "quit")){
                quit = true;
                System.out.println("Goodbye.");
            }
            else {
                inputString = inputString.toLowerCase();

                char[][] cipherArray = createCipher();
                String encryptedString = encrypt(inputString.toCharArray(), cipherArray);
                String decryptedString = decrypt(encryptedString.toCharArray(), cipherArray);

                printCipherArray(cipherArray);

                System.out.println("The encrypted string is: " + encryptedString);
                System.out.println("The decrypted string is: " + decryptedString);
            }
        }
    }

    public static char[][] createCipher(){
        Random generator = new Random();
        char[][] randomMapping = new char[27][27];
        randomMapping[0][26] = ' ';
        randomMapping[1][26] = ' ';

        int ascii = ALPHABET_START;
        for(int index = 0; index < randomMapping.length - 1; index++){
            randomMapping[0][index] = (char)ascii;
            randomMapping[1][index] = (char)ascii;
            ascii++;
        }

        for (int index = 0; index < randomMapping.length; index++){
            int otherIndex = generator.nextInt(randomMapping.length);
            char temp = randomMapping[1][index];
            randomMapping[1][index] = randomMapping[1][otherIndex];
            randomMapping[1][otherIndex] = temp;
        }
        return randomMapping;
    }

    public static String encrypt(char[] inputString, char[][] cipherArray){
        char[] encryptedString = new char[inputString.length];

        for(int index = 0; index < encryptedString.length; index++){
            for(int cipherIndex = 0; cipherIndex < cipherArray[0].length; cipherIndex++){
                if(inputString[index] == cipherArray[0][cipherIndex]){
                    encryptedString[index] = cipherArray[1][cipherIndex];
                }
            }
        }
        return new String(encryptedString);
    }

    public static String decrypt(char[] encryptedString, char[][] cipherArray){
        char[] decryptedString = new char[encryptedString.length];

        for(int index = 0; index < decryptedString.length; index++){
            for(int cipherIndex = 0; cipherIndex < cipherArray[1].length; cipherIndex++){
                if(encryptedString[index] == cipherArray[1][cipherIndex]){
                    decryptedString[index] = cipherArray[0][cipherIndex];
                }
            }
        }
        return new String(decryptedString);
    }

    public static void printCipherArray(char[][] cipherArray){
        for(int index1 = 0; index1 < 2; index1++){
            for(int index2 = 0; index2 < 27; index2++){
                System.out.print(cipherArray[index1][index2]);
            }
            System.out.println();
        }
    }
}