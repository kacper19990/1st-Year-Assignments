import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LCWLPG {

    public static List<String> readDictionary(String fileLocation) throws IOException {
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
    public static List<String> readWordList(String input){
        return Arrays.asList(input.split("\\s*,\\s*"));
    }

    public static boolean isUniqueList(List<String> inputList){
        List<String> list = inputList;
        Set<String> set = new HashSet<>(list);
        return set.size() >= list.size();

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
                isUniqueList(readWordList(readString));
            }

        }while (!finished);
        System.exit(0);
    }
}
