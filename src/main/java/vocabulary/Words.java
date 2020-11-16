package vocabulary;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Words {
    public static final String LETTERS = "abcdefghijklmnopqastuvwxyz";
    private static final List<String> LETTER_LIST = Arrays.asList(LETTERS.split(""));

    private List<String> totalWordList = new ArrayList<>();
    private List<String> wordList = new ArrayList<>(LETTER_LIST);

    private void getWords() {
        List<String> newWordList = new ArrayList<>(wordList);

        for (String letter : LETTER_LIST) {
            List<String> partWordList = wordList
                .stream()
                .map(word -> word.concat(letter))
                .collect(Collectors.toList());

            newWordList.addAll(partWordList);
        }

        totalWordList.addAll(newWordList);
        wordList = newWordList;

    }

    private void createWords(int length) {
        for (int i = 1; i <= length; i++) {
            getWords();
        }
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        Words main = new Words();
        main.createWords(1);

        for (int i = 0; i < main.totalWordList.size(); i++) {
            System.out.print(/*"i=" + i + " : " +*/ "|" + main.totalWordList.get(i) + "|" + "\t");

            if ((i + 1) % 26 == 0) {
                System.out.println("\n");
            }
        }

    }
}
