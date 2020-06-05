import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;

public class BufferedIO {
    public static void main(String[] args) {
        // The following code snippet shows how to use the newBufferedReader method to
        // read from a file. The file is encoded in "US-ASCII"
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (NoSuchFileException x) {
            System.err.format("No such file: %s", x.getFile());
        } catch (IOException x) {
            System.err.println(x);
        }

        String s = "ABC";
        try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
            writer.write(s, 0, s.length());
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        // To open a file for reading, you can use the newInputStream(Path,
        // OpenOption...) method. This method returns an unbuffered input stream for
        // reading bytes from the file.
        try (InputStream in = Files.newInputStream(file);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (NoSuchFileException x) {
            System.err.println("No such file exists: " + x.getFile());
        } catch (IOException x) {
            System.err.println(x);
        }

    }

}