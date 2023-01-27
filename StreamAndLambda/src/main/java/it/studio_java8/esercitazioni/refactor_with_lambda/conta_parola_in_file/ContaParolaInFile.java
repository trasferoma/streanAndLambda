package it.studio_java8.esercitazioni.refactor_with_lambda.conta_parola_in_file;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ContaParolaInFile {
    public static void main(String[] args) {
        try {
            URL resource = ContaParolaInFile.class.getResource("/contaParolaInFile.txt");

            long count = Files.lines(Paths.get(resource.toURI()))
                    .filter(st -> st.contains("yyyy"))
                    .count();

            System.out.println("----" + count);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

    }
}
