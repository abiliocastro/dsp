package com.ufc.br;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Compressao {

    public static void main(String[] args) {
        String fileName = args[0];
        String filePath = "dsp_list03/src/main/resources/" + fileName;
        try {
            File fileRead = new File(filePath);

            File fileWrite = new File(fileRead.getPath() + ".zip");
            FileOutputStream fos = new FileOutputStream(fileWrite, false);
            ZipOutputStream zos = new ZipOutputStream(fos);

            zos.putNextEntry(new ZipEntry(fileRead.getName()));

            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            zos.write(bytes, 0, bytes.length);
            zos.closeEntry();
            zos.close();

        } catch (FileNotFoundException ex) {
            System.err.format("The file %s does not exist", filePath);
        } catch (IOException ex) {
            System.err.println("I/O error: " + ex);
        }
    }
}
