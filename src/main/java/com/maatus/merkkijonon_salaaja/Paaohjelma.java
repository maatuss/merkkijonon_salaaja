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

        long aloitus = System.nanoTime();
        System.out.println("Sana: " + merkkijono);
        System.out.println("Salattu: " + salattu);

        long lopetus = System.nanoTime();
        long kesto = lopetus - aloitus;

        System.out.println("\nAikaa meni: " + (kesto / 1000000) + " ms.");

        ///salaaja.tulostaKaannokset();
    }

}
