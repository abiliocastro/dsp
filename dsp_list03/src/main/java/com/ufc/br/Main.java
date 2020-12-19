package com.ufc.br;

import java.io.IOException;

public class Main {
    private static Serializar serializar;
    private  static  Deserializar deserializar;

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        String filename = "calangos.ser";
        serializar = new Serializar();
        serializar.serializarCalangos(filename);
        deserializar = new Deserializar();
        deserializar.deserializarCalangos(filename);
        deserializar.exibirCalangos();
    }
}
