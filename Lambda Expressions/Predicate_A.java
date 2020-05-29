import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Predicate_A {

    public static void main(String[] args) {

        List<Integer> values = Arrays.asList(2, 4, 6, 9);
        Predicate<Integer> check = (Integer i) -> {
            System.out.println("Checking");
            return i == 4;
        };
        Predicate<Integer> even = (Integer i) -> i % 2 == 0; // Compiles
        // Predicate even = i -> ((Integer)i) % 2 == 0; //Compiles
        // Predicate even = (Object i) -> ((Integer)i) % 2 == 0; //Compiles

        // Predicate even = (Integer i) -> i % 2 == 0; //Doesn't compile: expected
        // Object but found Integer
        // Predicate even = (Integer i) -> ((Integer)i) % 2 == 0; //Doesn't compile:
        // expected Object but found Integer
        // Predicate even = (Object i) -> ((Object)i) % 2 == 0; //Doesn't compile:
        // Operator '%' can't be applied to java.lang.Object
        // Predicate even = (Object i) -> i % 2 == 0; //Doesn't compile: Operator '%'
        // can't be applied to java.lang.Object

        values.stream().filter(check).filter(even).count(); // Checking Checking Checking Checking
    }
}