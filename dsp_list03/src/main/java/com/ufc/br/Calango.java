package com.ufc.br;

import java.io.Serializable;

public class Calango implements Serializable {
    private int id;
    private String nome;
    private String especie;
    private transient float tamanho;
    private float peso;

    public Calango(int id, String nome, String especie, float tamanho, float peso) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.tamanho = tamanho;
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public float getTamanho() {
        return tamanho;
    }

    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Calango{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", especie='" + especie + '\'' +
                ", tamanho=" + tamanho +
                ", peso=" + peso +
                '}';
    }
}
