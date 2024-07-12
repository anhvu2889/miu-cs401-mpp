package lab8.prob5;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<String> consumer = (x) -> System.out.println(x.toUpperCase());
        List<String> list = Arrays.asList("Cris", "Duy", "Tuan");
        list.forEach(consumer);

    }
}
