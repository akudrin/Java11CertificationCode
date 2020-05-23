public class Path_Methods_A {
    public static void main(String[] args) {
        // Normalizing a path involves removing redundancies in it.
        Path p1 = Paths.get("/a/./b/c");
        Path cleanPath1 = p1.normalize();
        Path p2 = Paths.get("/a/b/../c");
        Path cleanPath2 = p2.normalize();

        System.out.println(cleanPath1 + " " + cleanPath2);

        Path p3 = Paths.get("/a/b/articles.html");
        URI uri = p3.toUri();

        Path p4 = Paths.get("/a/b/c/articles.html");
        Path absPath = p4.toAbsolutePath();

        // when the path string passed to the resolve method is
        // not a partial path; most notably an absolute path, then
        // the passed-in path is returned
        Path p5 = Paths.get("/a/b");
        Path p6 = p.resolve("java");

        Path p7 = Paths.get("a");
        Path p8 = Paths.get("b");

        Path p7_rel_p8 = p7.relativize(p8);
        Path p8_rel_p7 = p8.relativize(p7);

    }

}