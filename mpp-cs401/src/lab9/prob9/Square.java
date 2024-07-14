package lab9.prob9;

import java.util.stream.IntStream;

public class Square {
    public static void main(String[] args) {
        printSquares(4);
    }

    public static void printSquares(int num) {
        IntStream.iterate(1, Square::nextSquare)
                .limit(num)
                .forEach(System.out::println);
    }

    private static int nextSquare(int prev) {
        return (int) Math.pow(Math.sqrt(prev) + 1, 2);
    }
}
