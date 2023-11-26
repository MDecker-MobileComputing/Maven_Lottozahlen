package de.eldecker.dhbw.lottozahlen;

import static de.eldecker.dhbw.lottozahlen.engine.LottoZahlenGenerator.erzeugeTipp;

/**
 * Klasse mit Einstiegsmethode.
 */
public class App {

    /**
     * Einstiegsmethode: schreibt einen Zahlentipp für deutsches Lotto
     * "6 aus 49" auf die Konsole.
     *
     * @param args Kommandozeilenargumente, werden nicht ausgewertet.
     */
    public static void main (String[] args) {

        System.out.println();
        
        int[] lottoTippArray = erzeugeTipp();
        
        for (int zahl : lottoTippArray) {
            
            System.out.println(zahl);
        }
        
        System.out.println();
    }

}