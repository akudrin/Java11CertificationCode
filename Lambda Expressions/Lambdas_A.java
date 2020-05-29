interface Foo {
    int change(int i);
}

interface Bar {
    int change(Foo foo, int i);
}

public class Lambdas_A {
    Bar modify(Foo foo) {
        int i = foo.change(2);
        return (x, y) -> x.change(y) + i;
    }

    public static void main(String[] args) {
        Lambdas_A test = new Lambdas_A();
        Bar bar = test.modify(i -> i * 2);
        // Bar lambda expression becomes (x,y)->x.change(y) + 4
        int result = bar.change(i -> i * 3, 4);
        /*
         * the change method in Bar interface without lambda would have looked like
         * that: int change (Foo x, int y) { return x.change(y) + 4; } because it was
         * returned from modify() method as (x,y)->x.change(y) + 4 everything after ->
         * is method body then add lambda for Foo interface int change (i -> i * 3, 4) {
         * return x.change(4) + 4; } this part x.change(4) gives us 4 * 3 = 12 and plus
         * 4 = 16 is the answer
         */
        System.out.println(result);
    }
}
