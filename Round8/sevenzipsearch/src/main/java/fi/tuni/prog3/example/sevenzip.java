package fi.tuni.prog3.example;

import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.regex.Pattern;

public class sevenzip {
    public static void main(String[] args) throws IOException {
        String zipfile = args[0];

        try (SevenZFile archiveFile = new SevenZFile(new File(zipfile))) {
            SevenZArchiveEntry entry;

            // Go through all entries
            while ((entry = archiveFile.getNextEntry()) != null) {
                String name = entry.getName();

                if (name.contains("txt")) {
                    System.out.println(name);

                    InputStream stream = archiveFile.getInputStream(entry);
                    BufferedReader br = new BufferedReader(new InputStreamReader(stream));

                    String line;
                    String word_to_find = args[1];
                    int index = 1;
                    while((line = br.readLine()) != null) {
                        if (line.toLowerCase().contains(word_to_find.toLowerCase())) {
                            System.out.println(index +  ": " + line.replaceAll("(?i)"+
                                            Pattern.quote(word_to_find),
                                    word_to_find.toUpperCase(Locale.ROOT)));
                        }
                        index += 1;
                    }
                    System.out.println();
                }
            }
        }
    }
}
