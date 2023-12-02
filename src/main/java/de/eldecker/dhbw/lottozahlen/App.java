package de.eldecker.dhbw.lottozahlen;

import de.eldecker.dhbw.lottozahlen.engine.LottoException;
import de.eldecker.dhbw.lottozahlen.engine.LottoZahlenGenerator;

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
    public static void main (String[] args) throws LottoException {

        System.out.println();
        
        LottoZahlenGenerator lottoZahlenGenerator = new LottoZahlenGenerator(6, 49); // throws LottoException 
        
        int[] lottoTippArray = lottoZahlenGenerator.erzeugeTipp();        
        for (int zahl : lottoTippArray) {
            
            System.out.println(zahl);
        }
        
        System.out.println();
    }

}