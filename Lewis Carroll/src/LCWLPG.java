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
        System.out.println("Word list read.");
        return Arrays.asList(input.split("\\s*,\\s*"));
    }

    static boolean isUniqueList(List<String> inputList){
        Set<String> set = new HashSet<>(inputList);
        System.out.println("Reached isUniqueList.");
        return set.size() >= inputList.size();

    }

    static boolean isEnglishWord(String input, List<String> dictionary){
        Set<String> set = new HashSet<>(dictionary);
        System.out.println("isEnglishWord reached");
        return set.contains(input);
    }

    static boolean isDifferentByOne(String input1, String input2){
        char[] array1 = input1.toCharArray();
        char[] array2 = input2.toCharArray();
        int differentChars;

        if(array1.length == array2.length){
            return false;
        }
        else{
            for(int i = 0; i < array1.length; i++){
                if(i !=array1.length-1){

                }
            }
        }

    }

    static boolean isWordChain(List<String> list, String fileLocation){
        boolean determinant = false;
        if(isUniqueList(list)) {
            System.out.println("Is Unique.");
            for (int i = 1; i < list.size(); i++) {
                if (isDifferentByOne(list.get(i-1), list.get(i))){
                    if(isEnglishWord(list.get(i), readDictionary())){
                        determinant = true;
                    }
                    else {
                        System.out.println("not english");
                        determinant = false;
                        break;
                    }
                }
                else System.out.println("not different by one");
            }
        }
        return determinant;
    }

    public static void main(String[] args){
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
