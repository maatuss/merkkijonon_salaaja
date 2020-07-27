package com.maatus.merkkijonon_salaaja;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author markus
 */
public class Salaaja {

    private final Map<Character, Character> salatutkirjaimet;
    private final Map<Character, Character> puretutkirjaimet;
    private List<Character> kirjaimet;

    public Salaaja() {
        this.salatutkirjaimet = new HashMap<>();
        this.puretutkirjaimet = new HashMap<>();

        this.kirjaimet = new ArrayList<>();

        lisaaKirjaimet();
    }

    public String pura(String merkkijono) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= merkkijono.length() - 1; i++) {
            char salattukirjain = merkkijono.charAt(i);
            sb.append(puretutkirjaimet.get(salattukirjain));
        }
        return sb.toString();
    }

    public String salaa(String merkkijono) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= merkkijono.length() - 1; i++) {
            char salattavaKirjain = merkkijono.charAt(i);
            sb.append(salatutkirjaimet.get(salattavaKirjain));
        }

        return sb.toString();
    }

    private void lisaaKirjaimet() {
        char kirjain;

        //lisätään kirjaimia
        //aloitetaan tyhjästä (space)
        for (kirjain = ' '; kirjain <= 'z'; kirjain++) {
            kirjaimet.add(kirjain);
        }

        //lisätään käännökset, avaimeksi space ... z ja arvoksi random-kirjain kirjaimet-listasta
        //toistetaan niin kauan että ollaan merkissä 'z'
        //tarkistetaan ettei samaa arvoa ole jo lisätty
        //esim a = x
        char c = ' ';
        while (c <= 'z') {
            char randomkirjain = this.kirjaimet.get(new Random().nextInt(this.kirjaimet.size()));
            if (!salatutkirjaimet.containsValue(randomkirjain)) {
                salatutkirjaimet.put(c, randomkirjain);
                c++;
            }
        }

        //lisätään käännökset myös toisinpäin toiseen hajautustauluun
        //esim x = a
        salatutkirjaimet.entrySet().stream()
                .forEach(k -> puretutkirjaimet.put(k.getValue(), k.getKey()));

    }

    public void tulostaKaannokset() {
        salatutkirjaimet.entrySet().stream()
                .forEach(k -> {
                    System.out.println(k.getKey() + " = " + k.getValue());
                });
    }

}
