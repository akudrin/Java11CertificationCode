import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlatmapVSMap {
    public static void main(String[] args) {

        // map()
        List<String> names1 = Arrays.asList("Dzmitry", "John");
        List<String> names2 = Arrays.asList("David", "Laura");
        Stream<String> names3 = Arrays.asList("Dzmitry", "John").stream();
        Stream<String> names4 = Arrays.asList("David", "Laura").stream();
        System.out.println(names3 + "  " + names4);
        Stream<List<String>> s = Stream.of(names1, names2);
        s.map(names -> names.stream()).forEach(System.out::println);

        // flatMap()
        List<String> n1 = Arrays.asList("Dzmitry", "John");
        List<String> n2 = Arrays.asList("David", "Laura");
        Stream<List<String>> stream1 = Stream.of(names1, names2);
        stream1.flatMap(names -> names.stream()).forEach(System.out::println);

    }
}