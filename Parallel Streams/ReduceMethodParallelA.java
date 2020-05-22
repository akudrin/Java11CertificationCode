public class ReduceMethodParallelA {
    public static void main(String[] args) {
        // we can use reduce() in a parallelized stream
        List<Integer> ages = Arrays.asList(25, 30, 45, 28, 32);
        int computedAges = ages.parallelStream().reduce(0, a, b -> a + b, Integer::sum);
        /*
         * When a stream executes in parallel, the Java runtime splits the stream into
         * multiple substreams. In such cases, we need to use a function to combine the
         * results of the substreams into a single one. This is the role of the combiner
         * – in the above snippet, it's the Integer::sum method reference. If we use
         * sequential streams and the types of the accumulator arguments and the types
         * of its implementation match, we don't need to use a combiner.
         */

    }

}