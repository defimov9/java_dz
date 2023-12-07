import java.util.*;
import java.util.stream.Collectors;
import java.util.List;

public class RandomNumberOperations {
    public static void main(String[] args) {
        List<Integer> randomIntegers = new Random()
                .ints(1000, 10, 10000)
                .boxed()
                .toList();

        long primeCount = randomIntegers.stream()
                .filter(RandomNumberOperations::isPrime)
                .count();

        Optional<Integer> sum = randomIntegers.stream()
                .reduce(Integer::sum);

        randomIntegers.stream()
                .limit(10)
                .forEach(System.out::println);

        Map<Integer, Long> frequencyMap = randomIntegers.stream()
                .collect(Collectors.groupingBy(
                        Integer::intValue,
                        Collectors.counting()
                ));

        System.out.println("Простых чисел: " + primeCount);
        System.out.println("Сумма: " + sum.orElse(0));
        System.out.println("Частота значений: " + frequencyMap);
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }
}
