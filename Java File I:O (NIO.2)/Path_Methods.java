import java.nio.file.Path;

public class Path_Methods {
    public static void main(String[] args) {
        Path path = Path.of("a/b/c");
        Path root = path.getRoot();
        Path parent = path.getParent();
        Path file = path.getFileName();
        System.out.println(root + " " + parent + " " + file);

    }
}