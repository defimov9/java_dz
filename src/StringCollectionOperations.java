import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class StringCollectionOperations {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("cherry");
        stringList.add("date");
        stringList.add("elderberry");
        stringList.add("fig");

        List<String> filteredAndUpperCase = stringList.stream()
                .filter(s -> s.startsWith("a"))
                .map(String::toUpperCase)
                .toList();
        System.out.println("Строки, начинающиеся с 'a' и в верхнем регистре: " + filteredAndUpperCase);

        int totalLength = stringList.stream()
                .mapToInt(String::length)
                .sum();
        System.out.println("Суммарная длина всех строк: " + totalLength);

        List<String> reversedOrder = stringList.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("Строки в обратном порядке: " + reversedOrder);
    }
}
