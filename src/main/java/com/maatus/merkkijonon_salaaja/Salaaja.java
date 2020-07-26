package com.maatus.merkkijonon_salaaja;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author markus
 */
public class Salaaja {

    private Map<Character, Character> salatutkirjaimet;
    private Map<Character, Character> puretutkirjaimet;
    private List<Character> kirjaimet;

    public Salaaja() {
        this.salatutkirjaimet = new HashMap<>();
        this.puretutkirjaimet = new HashMap<>();

        lisaaKirjaimet();
    }

    public String pura(String merkkijono) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= merkkijono.length() - 1; i++) {
            char salattukirjain = merkkijono.charAt(i);
            // purettu += puretutkirjaimet.get(salattukirjain);
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
        char aakkonen;
        char kirjain;

        kirjaimet = new ArrayList<>();

        //lisätään kirjaimia
        for (kirjain = 'a'; kirjain <= 'z'; kirjain++) {
            kirjaimet.add(kirjain);
        }

        //sekoitetaan kirjaimien järjestys
        Collections.shuffle(kirjaimet);

        //käydään läpi sekoitettu kirjain -lista
        //lisätään hajautustauluun avain väliltä a-z ja sille arvo kirjain -listasta
        //esim a = b
        char c = 'a';
        for (int i = 0; i <= kirjaimet.size() - 1; i++) {

            salatutkirjaimet.put(c, kirjaimet.get(i));
            if (c == 'z') {
                break;
            }
            c++;

        }

        //tarkistetaan vielä että avain ei ole sama kuin arvo, vaihdetaan tarvittaessa
        //esim a = a
        tarkistaJaVaihdaSamat(salatutkirjaimet);

        //lisätään käännökset myös toisinpäin toiseen hajautustauluun
        //esim b = a
        salatutkirjaimet.entrySet().stream()
                .forEach(k -> puretutkirjaimet.put(k.getValue(), k.getKey()));

    }

    public void tarkistaJaVaihdaSamat(Map<Character, Character> kirjaimet) {

        while (onkoSamoja(kirjaimet)) {

            List<Character> avaimet = new ArrayList<>();
            List<Character> arvot = new ArrayList<>();

            avaimet.addAll(kirjaimet.keySet());
            arvot.addAll(kirjaimet.values());

            for (int i = 0; i <= kirjaimet.size() - 1; i++) {
                if (avaimet.get(i).equals(arvot.get(i))) {
                    kirjaimet.put(avaimet.get(i), this.kirjaimet.get(new Random().nextInt(this.kirjaimet.size())));
                }
            }
        }

    }

    public boolean onkoSamoja(Map<Character, Character> kirjaimet) {
        List<Character> avaimet = new ArrayList<>();
        List<Character> arvot = new ArrayList<>();

        avaimet.addAll(kirjaimet.keySet());
        arvot.addAll(kirjaimet.values());
        boolean loytyykoSamoja = true;

        for (int i = 0; i <= kirjaimet.size() - 1; i++) {
            if (!avaimet.get(i).equals(arvot.get(i))) {
                loytyykoSamoja = false;
            }
        }
        return loytyykoSamoja;
    }

    public void tulostaKaannokset() {
        salatutkirjaimet.entrySet().stream()
                .forEach(k -> {
                    System.out.println(k.getKey() + " = " + k.getValue());
                });
    }

}
