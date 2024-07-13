package lab9.prob4;

import java.util.function.Function;
import java.util.stream.IntStream;

public class PrimeStream {
    private static final Function<Long, IntStream> primes
            = (countOfFirstNumbers) -> IntStream.iterate(2, PrimeStream::nextPrime).limit(countOfFirstNumbers);

    public static void main(String[] args) {
        PrimeStream primeStream = new PrimeStream(); //PrimeStream is enclosing class
        primeStream.printFirstNPrimes(10);
        System.out.println("====");
        primeStream.printFirstNPrimes(5);
    }

    private void printFirstNPrimes(long n) {
        primes.apply(n)
                .forEach(System.out::println);
    }

    static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        return true;
    }

    static int nextPrime(int n) {
        int next = n + 1;
        while (!isPrime(next)) {
            next = next + 1;
        }
        return next;
    }
}
