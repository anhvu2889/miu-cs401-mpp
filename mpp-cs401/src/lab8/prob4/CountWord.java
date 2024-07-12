package lab8.prob4;

import java.util.ArrayList;
import java.util.List;

public class CountWord {
    public int countWords(List<String> words, char c, char d, int len) {
        return (int) words.stream()
                .filter(word -> word.length() == len)
                .filter(w -> w.contains(STR."\{c}"))
                .filter(w -> !w.contains(STR."\{d}"))
                .count();
    }

    public static void main(String[] args) {
        CountWord countWord = new CountWord();
        System.out.println(countWord.countWords(new ArrayList<>(List.of("Anh Vu", "AnhVu")), 'n', 'b', 6));
    }
}
