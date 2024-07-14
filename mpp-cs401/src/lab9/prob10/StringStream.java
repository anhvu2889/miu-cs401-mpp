package lab9.prob10;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringStream {
    public static void main(String[] args) {
//        System.out.println( Stream.of("Bill", "Thomas", "Marry").reduce((s1, s2) -> STR."\{s1}, \{s2}").get());
        System.out.println( Stream.of("Bill", "Thomas", "Marry").collect(Collectors.joining(", ")));
    }
}
