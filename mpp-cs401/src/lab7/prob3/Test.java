package lab7.prob3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class Test {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Cris", "Duy", "Tuan");
        list.forEach(new CustomConsumer());
    }

    static class CustomConsumer implements Consumer<String> {
        public void accept(String s) {
            System.out.println(s.toUpperCase());
        }
    }
}
