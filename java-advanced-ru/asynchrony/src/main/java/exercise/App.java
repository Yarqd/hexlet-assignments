package exercise;

import java.util.concurrent.CompletableFuture;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.StandardOpenOption;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String sourcePath1, String sourcePath2, String destPath) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Path path1 = Paths.get(sourcePath1);
                Path path2 = Paths.get(sourcePath2);
                Path dest = Paths.get(destPath);

                if (!Files.exists(path1)) {
                    throw new NoSuchFileException(sourcePath1);
                }
                if (!Files.exists(path2)) {
                    throw new NoSuchFileException(sourcePath2);
                }

                String content1 = Files.readString(path1);
                String content2 = Files.readString(path2);

                Files.writeString(dest, content1 + content2, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

                return "Files have been successfully merged";
            } catch (IOException e) {
                System.out.println("Error occurred: " + e.getMessage());
                return "Error during file merging";
            }
        });
    }

    public static CompletableFuture<Long> getDirectorySize(String dirPath) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Path dir = Paths.get(dirPath);
                return Files.list(dir)
                        .filter(Files::isRegularFile)
                        .mapToLong(file -> {
                            try {
                                return Files.size(file);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        })
                        .sum();
            } catch (IOException e) {
                throw new RuntimeException("Error while calculating directory size: " + e.getMessage(), e);
            }
        });
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        CompletableFuture<String> result = unionFiles(
                "src/main/resources/file1.txt",
                "src/main/resources/file2.txt",
                "src/main/resources/merged.txt"
        );
        System.out.println(result.get());

        CompletableFuture<Long> size = getDirectorySize("src/main/resources");
        System.out.println("Directory size: " + size.get() + " bytes");
        // END
    }
}
