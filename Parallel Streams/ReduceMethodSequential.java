public class ReduceMethodSequential {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        // the Integer value 0 is the identity
        // the lambda expression is the accumulator
        int result = numbers.stream().reduce(0, (subtotal, element) -> subtotal + element);
        System.out.println(result);
        // similar to the above but more concise
        int result_a = numbers.stream().reduce(0, Integer::sum);

        String output = Stream.of("hi", "fi").reduce("-", (s1, s2) -> s1 + s2);
        System.out.println(output);

        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        String result_b = letters.stream().reduce("", (partialString, element) -> partialString + element);
        String result_c = letters.stream().reduce("", String::concat);
        System.out.println(result_b + " " + result_c);

        String result_d = letters.stream().reduce("",
                (partialString, element) -> partialString.toUpperCase() + element.toUpperCase());

    }
}