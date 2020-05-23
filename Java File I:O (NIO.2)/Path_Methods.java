import java.nio.file.Path;

public class Path_Methods {
    public static void main(String[] args) {

        String HOME = System.getProperty("user.home");
        System.out.println(HOME);

        Path path = Path.of("a/b/c");
        Path root = path.getRoot();
        Path parent = path.getParent();
        Path file = path.getFileName();
        Path subpath = path.subpath(0, 2)
        System.out.println(root + " " + parent + " " + file + " " + subpath);

    }
}