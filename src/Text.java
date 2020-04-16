import java.util.*;

/**
 * Kostya Krivonos
 * 4/16/20
 * 8:07 PM
 */

public class Text {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String mes = "A literary text is input to the program. " +
                "The program should list the words found in the text, " +
                "in which for each word the number of occurrences of the word in the text is indicated, " +
                "and the words are displayed in descending order of occurrence frequency.";
        System.out.println(mes);
        System.out.println("Введите текст:");

        HashMap<String, Integer> wordCountMap = new HashMap<>();
        String line;
        List<String> words = new ArrayList<>();
        while ((line = scanner.nextLine()).length() > 0) {
            words.addAll(Arrays.asList(line.split("[,;:.!?\\s]+"))); // by not unicode letters
        }
        /*Calc words count*/
        for (String word : words) {
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }

        Map<String, Integer> sortedMapAsc = sortByComparator(wordCountMap);
        printMap(sortedMapAsc);
    }

    public static void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    private static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap) {

        List<Map.Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
