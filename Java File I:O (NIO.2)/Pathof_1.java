import java.nio.file.Path;

public class Pathof_1 {
    public static void main(String[] args) {
        Path p1 = Path.of("/a/b");
        Path p2 = Path.of("a/c");
        System.out.println(p1.resolve(p2));
        System.out.println(p1.getClass());
    }
}