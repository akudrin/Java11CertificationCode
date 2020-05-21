import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

public class PathOf {

    public static void main(String[] args) throws IOException {

        String tempFolder = System.getProperty("java.io.tmpdir");
        // Create Path from a sequence of Strings
        Path path1 = Path.of(tempFolder, "test.txt");
        System.out.println(path1);
        System.out.println(Files.exists(path1));
        File file = new File(path1.toString());
        // Create the file
        if (file.createNewFile()) {
            System.out.println("File is created!");
        } else {
            System.out.println("File already exists.");
        }

        String uriFullPath = "file:///" + tempFolder + "test.txt";
        URI uri = URI.create(uriFullPath);
        System.out.println(uri);

        // Create Path from a URI
        Path path2 = Path.of(uri);
        System.out.println(path2);
        System.out.println(Files.exists(path2));

    }

}