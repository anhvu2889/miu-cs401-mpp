package lab9.prob10;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyIntStream {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        IntSummaryStatistics intSummaryStatistics = integerStream.collect(Collectors.summarizingInt(Integer::intValue));
        System.out.printf("Max: %d \n", intSummaryStatistics.getMax());
        System.out.printf("Min: %d \n", intSummaryStatistics.getMin());
    }
}
