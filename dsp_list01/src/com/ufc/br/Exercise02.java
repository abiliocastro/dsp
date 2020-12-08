package com.ufc.br;

import java.io.*;
import java.util.Scanner;

public class Exercise02 {

    public static void main(String[] args) throws IOException {
        Scanner lerEntrada = new Scanner(System.in);
        System.out.print("Nome do arquivo a ser copiado: ");
        String nomeArquivo = lerEntrada.nextLine();
        System.out.print("Nome da cópia do arquivo: ");
        String nomeCopiaArquivo = lerEntrada.nextLine();
        InputStream is = Exercise02.class.getClassLoader().getResourceAsStream(nomeArquivo);
        File file = new File("dsp_list01/resources/" + nomeCopiaArquivo);
        OutputStream os = new FileOutputStream(file);
        long t1 = System.currentTimeMillis();
        byte[] arquivo = is.readAllBytes();
        os.write(arquivo);
        long time = System.currentTimeMillis() - t1;
        System.out.println("Tempo para copiar o arquivo em milisegundos: " + time);
        lerEntrada.close();
        is.close();
        os.close();
    }
}
