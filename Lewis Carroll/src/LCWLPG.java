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
        return Arrays.asList(input.split("\\s*,\\s*"));
    }

    static boolean isUniqueList(List<String> inputList){
        Set<String> set = new HashSet<>(inputList);
        return set.size() >= inputList.size();

    }

    static boolean isEnglishWord(String input, List<String> dictionary){
        Set<String> set = new HashSet<>(dictionary);
        return set.contains(input);
    }

    static boolean isDifferentByOne(String input1, String input2){
        String[] array1 = input1.split("");
        String[] array2 = input2.split("");

        Set<String> set1 = new HashSet<>(Arrays.asList(array1));
        Set<String> set2 = new HashSet<>(Arrays.asList(array2));

        return set1 == set2;
    }

    static boolean isWordChain(List<String> list){
        boolean determinant = false;
        if(isUniqueList(list)) {
            for (int i = 0; i < list.size(); i++) {
                if (isDifferentByOne(list.get(i), list.get(i+1))){
                    if(isEnglishWord(list.get(i), list)){
                        determinant = true;
                    }
                    else {
                        determinant = false;
                        break;
                    }
                }
            }
        }
        return determinant;
    }

    public static void main(String[] args){
        boolean finished = false;
        Scanner scanner = new Scanner(System.in);
        try {
            readDictionary("C:\\Users\\kacpe\\Desktop\\words.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        do{
            System.out.println("Enter a comma separated list of words (or an empty list to quit)");
            String readString = scanner.nextLine();
            if(readString.isEmpty()){
                finished = true;
                System.out.println("exiting");
            }
            else{
                boolean test = isWordChain(readWordList(readString));

            }

        }while (!finished);
        System.exit(0);
    }
}
