public class ReduceMethodParallelB {
    public static void main(String[] args) {

        /*
         * Executing this stream in parallel results in an entirely different execution
         * behavior. Now the combiner is actually called. Since the accumulator is
         * called in parallel, the combiner is needed to sum up the separate accumulated
         * values.
         */
        List<Person> persons = Arrays.asList(new Person("Max", 18), new Person("Peter", 23), new Person("Pamela", 23),
                new Person("David", 12));
        Integer ageSum = persons.parallelStream().reduce(0, (sum, p) -> {
            System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
            return sum += p.age;
        }, (sum1, sum2) -> {
            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
            return sum1 + sum2;
        });
        // the combiner function is only called in parallel but not in sequential
        // streams
        persons.parallelStream().reduce(0, (sum, p) -> {
            System.out.format("accumulator: sum=%s; person=%s [%s]\n", sum, p, Thread.currentThread().getName());
            return sum += p.age;
        }, (sum1, sum2) -> {
            System.out.format("combiner: sum1=%s; sum2=%s [%s]\n", sum1, sum2, Thread.currentThread().getName());
            return sum1 + sum2;
        });

    }

}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }
}
