package br.com.program;

import br.com.model.ListaTelefonica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Principal {
    public static void main(String[] args) {
        String path = "C:\\Users\\vinic\\Desktop\\Lista.txt";
        List<ListaTelefonica> listaTelefonica = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while (line != null) {
                if (!line.trim().isEmpty()) {
                    ListaTelefonica registro = new ListaTelefonica(line.replaceAll("\\s", ""));
                    if (registro.getNumero().charAt(2) != '3') {
                        listaTelefonica.add(registro);
                        System.out.println(registro);
                    }
                }
                line = br.readLine();
            }

            Set<ListaTelefonica> valoresUnicos = new HashSet<>(listaTelefonica);

            for (ListaTelefonica numero : valoresUnicos) {
                System.out.println(numero);
            }

        } catch (IOException e) {
            System.out.println(STR."Error: \{e.getMessage()}");
        }
    }
}