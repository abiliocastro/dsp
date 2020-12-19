package com.ufc.br;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Deserializar {
    private List<Calango> calangos;

    public void deserializarCalangos(String fileName) throws IOException, ClassNotFoundException {
        calangos = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream("dsp_list03/src/main/resources/" + fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Calango calango = (Calango) objectInputStream.readObject();
        while (calango != null) {
            calangos.add(calango);
            calango = (Calango) objectInputStream.readObject();
        }
    }

    public void exibirCalangos() {
        if(this.calangos != null && !this.calangos.isEmpty()) {
            for (Calango calango : this.calangos) {
                System.out.println(calango);
            }
            return;
        }
        System.out.println("Sem calangos para exibir!");
    }
}
