package com.ufc.br;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Serializar {
    private List<Calango> calangos;

    public Serializar() {
        this.calangos = new ArrayList<>();
        for (int i = 0; i <= 995; i += 5){
            Calango calango01 = new Calango(i+1, "Mike", "Guegueh", 20.89F, 205.03F);
            Calango calango02 = new Calango(i+2, "Untoin", "Briba", 18.69F, 110.58F);
            Calango calango03 = new Calango(i+3, "John Cricket", "Teju", 35.22F, 521.84F);
            Calango calango04 = new Calango(i+4, "Zeh", "Calango Cego", 25.32F, 320.72F);
            Calango calango05 = new Calango(i+5, "Sivirino", "Calango Cego", 25.38F, 340.72F);
            this.calangos.addAll(Arrays.asList(calango01, calango02, calango03, calango04, calango05));
        }
    }

    public void serializarCalangos(String filename) throws IOException {
        File file = new File("dsp_list03/src/main/resources/" + filename);
        FileOutputStream outputStream = new FileOutputStream(file, false);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        for (Calango calango: this.calangos) {
            objectOutputStream.writeObject(calango);
        }
        objectOutputStream.writeObject(null);
        objectOutputStream.close();
        outputStream.close();
        System.out.println("Calangos serializados!");
    }


}
