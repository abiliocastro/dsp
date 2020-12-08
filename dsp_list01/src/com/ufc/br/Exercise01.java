package com.ufc.br;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Exercise01 {

    private static Scanner lerTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        String nomeArquivo = lerTeclado.nextLine();
        String n1s = lerTeclado.nextLine();
        String n2s = lerTeclado.nextLine();
        if(!n1s.equals("") && !n2s.equals("")) { // Quando o caba coloca os dois números
            processaComDoisNumeros(nomeArquivo, n1s, n2s);
        } else if(!n1s.equals("")) { // Quando o caba coloca só o primeiro número
            processaComPrimeiroNumero(nomeArquivo, n1s);
        } else if(!n2s.equals("")) { // Quando o caba coloca só o segundo número
            processaComSegundoNumero(nomeArquivo, n2s);
        } else { // Quando o caba é senvergoin e coloca nenhum número
            System.out.println("Por favor informe pelo menos um valor");
            lerTeclado.close();
            return;
        }
    }

    private static void processaComDoisNumeros(String nomeArquivo, String n1s, String n2s) {
        validaNumeros(n1s, n2s);
        Scanner lerArquivo = getScanner(nomeArquivo);
        if (lerArquivo == null) return;
        int n1 = Integer.valueOf(n1s);
        int n2 = Integer.valueOf(n2s);
        int count = 1;
        while (lerArquivo.hasNextLine()) {
            String linha = lerArquivo.nextLine();
            if(count >= n1 && count <= n2) {
                System.out.println(linha);
                if(count == n2) return;
            }
            count++;
        }
        fecharScanners(lerArquivo);
        return;
    }

    private static void processaComPrimeiroNumero(String nomeArquivo, String n1s) {
        validaNumero(n1s);
        Scanner lerArquivo = getScanner(nomeArquivo);
        if (lerArquivo == null) return;
        int n = Integer.valueOf(n1s);
        int count = 1;
        while (lerArquivo.hasNextLine()) {
            String linha = lerArquivo.nextLine();
            if(count >= n) System.out.println(linha);
            count++;
        }
        fecharScanners(lerArquivo);
        return;
    }

    private static void processaComSegundoNumero(String nomeArquivo, String n2s) {
        validaNumero(n2s);
        Scanner lerArquivo = getScanner(nomeArquivo);
        if (lerArquivo == null) return;
        int n = Integer.valueOf(n2s);
        int count = 1;
        while (lerArquivo.hasNextLine()) {
            String linha = lerArquivo.nextLine();
            if(count <= n) System.out.println(linha);
            count++;
        }
        fecharScanners(lerArquivo);
        return;
    }

    private static void fecharScanners(Scanner lerArquivo) {
        lerArquivo.close();
        lerTeclado.close();
    }

    private static void validaNumeros(String n1s, String n2s) {
        try {
            int n1 = Integer.valueOf(n1s);
            int n2 = Integer.valueOf(n2s);
            if(n1 > n2) {
                System.out.println("O primeiro numero deve ser menor que o segundo");
                System.exit(0);
            } else if(n1 < 1) {
                System.out.println("Valores inválidos");
                System.exit(0);
            }
        } catch (NumberFormatException ex) {
            System.out.println("Por favor digite um número válido");
            System.exit(0);
        }
    }

    private static void validaNumero(String numero) {
        try {
            int n = Integer.valueOf(numero);
            if(n < 1) {
                System.out.println("Valor inválido!");
                System.exit(0);
            }
        } catch (NumberFormatException ex) {
            System.out.println("Por favor digite um número válido");
            System.exit(0);
        }
    }

    private static Scanner getScanner(String nomeArquivo) {
        InputStream is;
        is = Exercise01.class.getClassLoader().getResourceAsStream(nomeArquivo);
        if(is == null) {
            System.out.println("Arquivo não encontrado");
            return null;
        }
        Scanner lerArquivo = new Scanner(is);
        return lerArquivo;
    }
}
