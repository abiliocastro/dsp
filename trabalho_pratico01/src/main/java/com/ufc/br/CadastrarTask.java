package com.ufc.br;

import java.io.*;
import java.util.Scanner;

public class CadastrarTask {
    private static PrintStream printStream;

    public static void main(String[] args) throws IOException {
        printStream = new PrintStream(new FileOutputStream("trabalho_pratico01/src/main/resources/tasks.csv", true));
        Scanner entrada = new Scanner(System.in);
        String entradaAtual;
        Task task;
        do {
            task = new Task();
            System.out.print("Digite o id da task: ");
            entradaAtual = entrada.nextLine();
            if(!deveSair(entradaAtual)){
                task.setId(Integer.parseInt(entradaAtual));
                System.out.print("Digite o nome do projeto da task: ");
                entradaAtual = entrada.nextLine();
                if(!deveSair(entradaAtual)){
                    task.setProject(entradaAtual);
                    System.out.print("Digite o resumo da task: ");
                    entradaAtual = entrada.nextLine();
                    if(!deveSair(entradaAtual)){
                        task.setSummary(entradaAtual);
                        System.out.print("Digite a descrição da task: ");
                        entradaAtual = entrada.nextLine();
                        if(!deveSair(entradaAtual)){
                            task.setDescription(entradaAtual);
                            System.out.print("Digite o tipo da task (bug ou melhoria): ");
                            entradaAtual = entrada.nextLine();
                            if(!deveSair(entradaAtual)){
                                task.setType(entradaAtual);
                                System.out.print("Digite o tempo usado no desenvolvimento da task em horas: ");
                                entradaAtual = entrada.nextLine();
                                if(!deveSair(entradaAtual)){
                                    task.setTimeSpent(Double.parseDouble(entradaAtual));
                                }
                            }
                        }
                    }
                }
            }
            if(taskValida(task)) salvarCsv(task);
        } while (!deveSair(entradaAtual));
        printStream.close();
    }

    private static boolean deveSair(String entrada) {
        return entrada.equals("sair");
    }

    private static boolean taskValida(Task task) {
        return task.getId() != null
                && task.getProject() != null
                && task.getSummary() != null
                && task.getDescription() != null
                && task.getType() != null
                && task.getTimeSpent() != null;

    }

    private static void salvarCsv(Task task) throws FileNotFoundException {
        printStream.println(task.getId()+","+
                task.getProject()+","+
                task.getSummary()+","+
                task.getDescription()+","+
                task.getType()+","+
                task.getTimeSpent());
    }
}
