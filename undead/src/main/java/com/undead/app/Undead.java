package com.undead.app;

public class Undead 
{
    private String nazwa;
    private String typ;
    private int tier;
    private String lokacja;
    private String zdolnoscSpecjalna;


    public Undead(String nazwa, String typ, int tier, String lokacja, String zdolnoscSpecjalna) {
        this.nazwa = nazwa;
        this.typ = typ;
        this.tier = tier;
        this.lokacja = lokacja;
        this.zdolnoscSpecjalna = zdolnoscSpecjalna;   
    }
}
