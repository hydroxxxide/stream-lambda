import java.util.*;
import java.util.function.Function;


public class Main {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        double average = nums.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(Double.NaN);
        System.out.println("\n1. Найти среднее значение чисел в списке:  - " + average);

        List<Integer> squares = nums.stream()
                .map(n -> n * n)
                .toList();
        System.out.println("\n2. Получить список квадратов чисел в списке: - " + squares);

        List<Integer> evenNums = nums.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println("\n3. Отфильтровать элементы списка, оставив только четные числа: - " + evenNums);

        boolean contains3 = nums.contains(3);
        System.out.println("\n4. Проверить, содержит ли список число 3: - " + contains3);

        List<String> strings = Arrays.asList("one", "two", "three", "four", "five");
        String joinedStrings = String.join(", ", strings);
        System.out.println("\n5. Соединить элементы списка в одну строку через запятую: - " + joinedStrings);

        List<Integer> first3nums = nums.subList(0, 3);
        System.out.println("\n6. Получить первые три элемента списка: - " + first3nums);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 3, 4, 6);
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .toList();
        System.out.println("\n7. Извлечь из списка все уникальные элементы: - " + uniqueNumbers);

        int max = nums.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(Integer.MAX_VALUE);
        System.out.println("\n8. Найти максимальное значение в списке: - " + max);

        List<Integer> reverseNums = nums.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("\n9. Отсортировать список в обратном порядке: - " + reverseNums);


        System.out.println("\nЛямбда-выражение:");

        nums.replaceAll(n -> n * 2);
        System.out.println("\n1. Напишите лямбда-выражение, которое умножает каждый элемент списка на 2. - " + nums);


        Sum sum = (a, b) -> a + b;
        System.out.println("\n2. Напишите лямбда-выражение, которое находит сумму двух чисел.c"
                + sum.apply(2, 2));

        MoreThanTen moreThanTen = n -> n > 10;
        System.out.println("\n3. Напишите лямбда-выражение, которое возвращает True, если переданное число больше 10. - "
                + moreThanTen.apply(9));

        LengthMoreThanFive l = s -> String.valueOf(s.length() > 5);
        System.out.println("\n4. Напишите лямбда-выражение, которое возвращает True, " +
                "если переданная строка содержит более 5 символов. - "
                + l.apply("123456"));

        LengthOfString l1 = s -> s.length();
        System.out.println("\n5. Напишите лямбда-выражение, которое возвращает длину переданной строки. - "
                + l1.apply("String"));

        Square square = n -> n * n;
        System.out.println("\n6. Напишите лямбда-выражение, которое возвращает квадрат переданного числа. - "
                + square.apply(2));

        List<Integer> nums1 = Arrays.asList(1, 2, 3, 4, 5);
        SumOfList sumOfList = n -> nums1.stream().reduce(0, (a, b) -> a + b);
        System.out.println("\n7. Напишите лямбда-выражение, которое возвращает сумму элементов списка. - "
                + sumOfList.apply(nums1));

        StartsWithA startsWithA = s -> s.startsWith("А");
        System.out.println("\n8. Напишите лямбда-выражение, которое возвращает True, " +
                "если переданная строка начинается с буквы \"A\".  - "
                + startsWithA.apply("Абракадабра"));

        List<Integer> nums2 = Arrays.asList(1, 2, 3, 4, 5);
        nums2.replaceAll(n -> n * n);
        System.out.println("\n9. Напишите лямбда-выражение, " +
                "которое возвращает список квадратов элементов исходного списка. - " + nums2);
    }
    public interface SquareOfList{
        List<Integer> apply(List<Integer> nums);
    }
    public interface StartsWithA{
        boolean apply(String s);
    }
    public interface SumOfList{
        int apply(List<Integer> nums);
    }
    public interface Square{
        int apply(int n);
    }
    public interface LengthOfString{
        int apply(String s);
    }
    public interface LengthMoreThanFive {
        String apply(String s);
    }
    public interface MoreThanTen {
         boolean apply(int n);
    }
    public interface Sum {
         int apply(int a, int b);
    }
}