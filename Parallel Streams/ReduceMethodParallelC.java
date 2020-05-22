public class ReduceMethodParallelC {
    public static void main(String[] args) {
        // Parallel streams use a common ForkJoinPool available via
        // the static ForkJoinPool.commonPool() method.
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println(commonPool.getParallelism());

        /*
         * Collections support the method parallelStream() to create a parallel stream
         * of elements. Alternatively you can call the intermediate method parallel() on
         * a given stream to convert a sequential stream to a parallel counterpart.
         *the parallel stream utilizes all available threads from the common ForkJoinPool 
         *for executing the stream operations
         */
        Arrays.asList("a1", "a2", "b1", "c2", "c1").parallelStream().filter(s -> {
            System.out.format("filter: %s [%s]\n", s, Thread.currentThread().getName());
            return true;
        }).map(s -> {
            System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
            return s.toUpperCase();
        }).forEach(s -> System.out.format("forEach: %s [%s]\n", s, Thread.currentThread().getName()));
        
        //add stream operation, sort
        Arrays.asList("a1", "a2", "b1", "c2", "c1")
    .parallelStream()
    .filter(s -> {
        System.out.format("filter: %s [%s]\n",
            s, Thread.currentThread().getName());
        return true;
    })
    .map(s -> {
        System.out.format("map: %s [%s]\n",
            s, Thread.currentThread().getName());
        return s.toUpperCase();
    })
    .sorted((s1, s2) -> {
        System.out.format("sort: %s <> %s [%s]\n",
            s1, s2, Thread.currentThread().getName());
        return s1.compareTo(s2);
    })
    .forEach(s -> System.out.format("forEach: %s [%s]\n",
        s, Thread.currentThread().getName()));


    }

}