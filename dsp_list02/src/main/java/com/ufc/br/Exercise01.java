package com.ufc.br;

import java.io.*;
import java.util.Scanner;

public class Exercise01 {

    public static void main(String[] args) throws IOException {
        Scanner lerEntrada = new Scanner(System.in);
        System.out.print("Nome do arquivo de origem: ");
        String nomeArquivoOrigem = lerEntrada.nextLine();
        System.out.print("Nome do arquivo de destino: ");
        String nomeArquivoDestino = lerEntrada.nextLine();
        InputStream is = Exercise01.class.getClassLoader().getResourceAsStream(nomeArquivoOrigem);
        File file = new File("dsp_list02/src/main/resources/" + nomeArquivoDestino);
        OutputStream os = new FileOutputStream(file);
        byte[] buffer = new byte[32];
        int total_read;
        long t1 = System.currentTimeMillis();
        while((total_read = is.read(buffer)) > 0){
            os.write(buffer, 0, total_read);
        }
        long time = System.currentTimeMillis() - t1;
        System.out.println("Tempo para copiar o arquivo em milisegundos: " + time);
        lerEntrada.close();
        is.close();
        os.close();
    }
}
