package br.com.program;

import br.com.model.ListaTelefonica;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class PrincialTeste {
    private static final String FILE_PATH = "C:\\Users\\vinic\\Desktop\\Lista.txt";
    private static final char TARGET_CHAR = '3';

    public static void main(String[] args) {
        try {
            List<ListaTelefonica> listaTelefonica = Files.lines(Paths.get(FILE_PATH))
                    .filter(line -> !line.trim().isEmpty())
                    .map(line -> new ListaTelefonica(line.replaceAll("\\s", "")))
                    .filter(registro -> registro.getNumero().charAt(2) != TARGET_CHAR)
                    .collect(Collectors.toList());

            listaTelefonica.stream().distinct().forEach(registro -> {
                System.out.println(registro);
            });

        } catch (IOException e) {
            System.out.println(STR."Error: \{e.getMessage()}");
        }
    }
}
