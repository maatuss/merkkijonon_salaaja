package com.maatus.merkkijonon_salaaja;

/**
 *
 * @author markus
 */
public class Paaohjelma {

    public static void main(String[] args) {

        Salaaja salaaja = new Salaaja();

        String merkkijono = "123 merkkijonon salaaja 456";
        String salattu = salaaja.salaa(merkkijono);
        String purettu = salaaja.pura(salattu);

        System.out.println("Sana: " + merkkijono);
        System.out.println("Salattu: " + salattu);
        System.out.println("Purettu: " + purettu);

        //salaaja.tulostaKaannokset();
    }

}
