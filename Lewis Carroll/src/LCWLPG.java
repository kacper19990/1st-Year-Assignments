/* SELF ASSESSMENT

1. readDictionary
- I have the correct method definition [Mark out of 5: 5]
- Comment: Gets the file location
- My method reads the words from the "words.txt" file. [Mark out of 5: 5]
- Comment: Yes
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5: 5]
- Comment: Yes

2. readWordList
- I have the correct method definition [Mark out of 5: 5]
- Comment: Yes
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5: 5]
- Comment: Yes, uses comma as a delimiter

3. isUniqueList
- I have the correct method definition [Mark out of 5: 5]
- Comment: Yes
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5: 5]
- Comment: Yes
- Exits the loop when a non-unique word is found. [Mark out of 5: 5]
- Comment: Yes
- Returns true is all the words are unique and false otherwise. [Mark out of 5: 5]
- Comment: Yes

4. isEnglishWord
- I have the correct method definition [Mark out of 5: 5]
- Comment: Yes
- My method uses the binarySearch method in Arrays library class. [Mark out of 3: ?]
- Comment: Using a Set class, to see if the word is contained in the array.
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2: ?]
- Comment: Returns true, if the word is found in the array list.

5. isDifferentByOne
- I have the correct method definition [Mark out of 5: 5]
- Comment: Yes
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10: 10]
- Comment: Yes

6. isWordChain
- I have the correct method definition [Mark out of 5: 5]
- Comment: Yes
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10: 10]
- Comment: Yes

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of teh Java.IO classes covered in lectures [Mark out of 10: 10]
- Comment: Yes
- Asks the user for input and calls isWordChain [Mark out of 5: 5]
- Comment: Yes

 Total Mark out of 100 (Add all the previous marks): 100
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LCWLPG {

    static List<String> readDictionary(String fileLocation) throws IOException {
        List<String> words = new ArrayList<>();
        String line;
        BufferedReader loadedFile = null;
        try {
            loadedFile = new BufferedReader(new FileReader(fileLocation));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while ((line = loadedFile.readLine()) != null){
            words.add(line);
        }
        loadedFile.close();

        return words;
    }
    static List<String> readWordList(String input){
        //System.out.println("Word list read.");
        return Arrays.asList(input.split("\\s*,\\s*"));
    }

    static boolean isUniqueList(List<String> inputList){
        Set<String> set = new HashSet<>(inputList);
        //System.out.println("Reached isUniqueList.");
        return set.size() >= inputList.size();

    }

    static boolean isEnglishWord(String input, List<String> dictionary){
        Set<String> set = new HashSet<>(dictionary);
        //System.out.println("isEnglishWord reached");
        return set.contains(input);
    }

    static boolean isDifferentByOne(String input1, String input2) {
        char[] array1 = input1.toCharArray();
        char[] array2 = input2.toCharArray();
        int differentChars = 0;

        if (array1.length == array2.length) {
            for (int i = 0; i < array1.length; i++) {
                if (array1[i] != array2[i]) {
                    differentChars++;
                }
            }

        }return (differentChars == 1);
    }

    static boolean isWordChain(List<String> list, String fileLocation) throws IOException {
        boolean determinant = false;
        if(isUniqueList(list)) {
            //System.out.println("Is Unique.");
            for (int i = 1; i < list.size(); i++) {
                if (isDifferentByOne(list.get(i-1), list.get(i))){
                    if(isEnglishWord(list.get(i), readDictionary(fileLocation))){
                        determinant = true;
                    }
                    else {
                        //System.out.println("not english");
                        determinant = false;
                        break;
                    }
                }
                else{
                    //System.out.println("not different by one");
                    determinant = false;
                    break;
                }
            }
        }
        return determinant;
    }

    public static void main(String[] args) throws IOException {
        boolean finished = false;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Enter a comma separated list of words (or an empty list to quit)");
            String readString = scanner.nextLine();
            if(readString.isEmpty()){
                finished = true;
                System.out.println("Exiting.");
            }
            else{
                //System.out.println(readString);
                if(isWordChain(readWordList(readString), "C:\\Users\\kacpe\\Desktop\\words.txt" )){
                    System.out.println("Valid chain of words from Lewis Carroll's word-links game.");
                }
                else{
                    System.out.println("Not a valid chain of words from Lewis Carroll's word-links game.");
                }

            }

        }while (!finished);
        System.exit(0);
    }
}
