package com.ufc.br;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Descompressao {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String resourcePath = "dsp_list03/src/main/resources/";
        File zipFile = new File(resourcePath + args[0]);
        File unzipedFile = new File(resourcePath + "unzipedcalangos.ser");
        InputStream is = new FileInputStream(zipFile);
        ZipInputStream zis = new ZipInputStream(is);
        ZipEntry zipEntry = zis.getNextEntry();
        FileOutputStream fileOutputStream = new FileOutputStream(unzipedFile);
        while (zipEntry != null) {
            fileOutputStream.write(zis.readAllBytes());
            zipEntry = zis.getNextEntry();
        }
        fileOutputStream.close();
        is = new FileInputStream(unzipedFile);
        ObjectInputStream objectInputStream = new ObjectInputStream(is);
        Calango calango = (Calango) objectInputStream.readObject();
        while (calango != null) {
            System.out.println(calango);
            calango = (Calango) objectInputStream.readObject();
        }
    }
}
