package com.example.grafic1;

import java.io.Serializable;

enum Etaj{ETAJ_1, ETAJ_2, ETAJ_3}

public class Apartament implements Serializable {
    private String adresa;
    private String numeProprietar;
    private int chirie;
    private boolean renovat; //checkbox
    private Etaj etaj; //radiobutton

    public Apartament(String adresa, String numeProprietar, int chirie, boolean renovat, Etaj etaj) {
        this.adresa = adresa;
        this.numeProprietar = numeProprietar;
        this.chirie = chirie;
        this.renovat = renovat;
        this.etaj = etaj;
    }

    public Apartament() {
        this.etaj=Etaj.ETAJ_1;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getNumeProprietar() {
        return numeProprietar;
    }

    public void setNumeProprietar(String numeProprietar) {
        this.numeProprietar = numeProprietar;
    }

    public int getChirie() {
        return chirie;
    }

    public void setChirie(int chirie) {
        this.chirie = chirie;
    }

    public boolean isRenovat() {
        return renovat;
    }

    public void setRenovat(boolean renovat) {
        this.renovat = renovat;
    }

    public Etaj getEtaj() {
        return etaj;
    }

    public void setEtaj(Etaj etaj) {
        this.etaj = etaj;
    }

    @Override
    public String toString() {
        return "Apartament{" +
                "adresa='" + adresa + '\'' +
                ", numeProprietar='" + numeProprietar + '\'' +
                ", chirie=" + chirie +
                ", renovat=" + renovat +
                ", etaj=" + etaj +
                '}';
    }
}
