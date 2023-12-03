package de.eldecker.dhbw.lottozahlen;

import de.eldecker.dhbw.lottozahlen.engine.LottoZahlenGenerator;
import de.eldecker.dhbw.lottozahlen.engine.model.LottoException;

/**
 * Klasse mit Einstiegsmethode für Erzeugung Zahltipp für
 * "6 aus 49" (Deutschland).
 */
public class App {

    /**
     * Einstiegsmethode: schreibt einen Zahlentipp für deutsches Lotto
     * "6 aus 49" auf die Konsole (aufsteigend sortiert).
     *
     * @param args Kommandozeilenargumente, werden nicht ausgewertet.
     */
    public static void main (String[] args) throws LottoException {

        System.out.println("\nTipp deutsches Zahlenlotto \"6 aus \"49:\n");

        LottoZahlenGenerator lottoZahlenGenerator = new LottoZahlenGenerator(6, 49); // throws LottoException

        int[] lottoTippArray = lottoZahlenGenerator.erzeugeTipp();
        for (int zahl : lottoTippArray) {

            System.out.println("  " + zahl);
        }

        System.out.println();
    }

}