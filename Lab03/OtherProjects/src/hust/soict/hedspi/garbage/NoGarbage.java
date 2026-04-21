package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String file = "test";
        byte[] input = {0};
        try {
            input = Files.readAllBytes(Paths.get(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long start = System.currentTimeMillis();
        StringBuilder output = new StringBuilder();
        for (byte b : input) output.append((char) b);
        System.out.println(System.currentTimeMillis() - start);
    }
}
