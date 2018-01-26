/* SELF ASSESSMENT

 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?

        Mark out of 5:  5

 2. Did I indent the code appropriately?

        Mark out of 5: 5

 3. Did I write the createCipher function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:  10

 4. Did I write the encrypt function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:  10

 5. Did I write the decrypt function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:  10

 6. Did I write the main function body correctly (repeatedly obtaining a string and encrypting it and then decrypting the encrypted version)?

       Mark out of 25  12

 7. How well did I complete this self-assessment?

        Mark out of 5:2

 Total Mark out of 100 65(Add all the previous marks):

*/


import java.util.Random;
import java.util.Scanner;

public class Cipher {
    public static char[][] createCypher()
    {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz ".toCharArray();
        char[][] cypher = new char[2][28];
        for(int i = 0; i <28; i++)
        {
            cypher[1][i] = alphabet[i];
            cypher[2][i] = alphabet[i];
        }
        if (cypher!=null)
        {

            Random generator = new Random();

            for (int index=0; index<cypher.length; index++ )

            {

                int otherIndex = generator.nextInt(cypher.length);

                char temp = cypher[2][index];

                cypher[2][index] = cypher[2][otherIndex];

                cypher[2][otherIndex] = temp;

            }

        }

    }
    public static void encrypt(char[] textToEncrypt)
    {

    }
    public static void decrypt(String[] encryptedText)
    {

    }
    public static void main(String[] args)
    {
        boolean finished = false;
        do
        {
            System.out.println("Text to be encrypted");
            Scanner input = new Scanner(System.in);
            if(input.hasNext("Quit"))
            {
                finished = true;
            }
            else if(input.hasNext()){
                char[][] cypher = createCypher();
                String text = input.next();
                String lowerCaseString = text.toLowerCase();
                char[] characterArray = lowerCaseString.toCharArray();
                encrypt(characterArray);

            }
            else {
                System.out.println("Wrong input. Stop?");
                if(input.hasNext("Yes"))
                    finished = true;
            }
        }while (!finished);
    }
}
